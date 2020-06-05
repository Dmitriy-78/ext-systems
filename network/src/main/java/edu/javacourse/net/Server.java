package edu.javacourse.net;

import java.io.*;
import java.lang.reflect.Constructor;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket socket = new ServerSocket(25225,2000);

        Map<String,Greetable> handlers = loadHandlers();

        System.out.println("Server is started...");
        while (true) {
            Socket client = socket.accept();//ожидает сообщения в виде потока байтов
            new SimpleServer(client,handlers).start();
            //handleRequest(client);
        }
    }

    private static Map<String, Greetable> loadHandlers() {
        Map<String, Greetable> result = new HashMap<>();

        try (InputStream is = Server.class.getClassLoader()
                .getResourceAsStream("server.properties")) {
            Properties properties = new Properties();
            properties.load(is);

            for (Object comand : properties.keySet()) {
                String className = properties.getProperty(comand.toString());
                Class<Greetable> cl = (Class<Greetable>) Class.forName(className);

                Greetable handler = cl.getConstructor().newInstance();
                result.put(comand.toString(),handler);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return result;
    }

    private static void handleRequest(Socket client) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

        StringBuilder sb = new StringBuilder("Hello, ");
        String userName = br.readLine();
        System.out.println("Server got string "+userName);
        Thread.sleep(2000);

        sb.append(userName);
        bw.write(sb.toString());
        bw.newLine();
        bw.flush();

        br.close();
        bw.close();

        client.close();
    }
}

class SimpleServer extends Thread {

    private Socket client;
    private Map<String, Greetable> handlers;

    public SimpleServer(Socket client, Map<String, Greetable> handlers) {
        this.client = client;
        this.handlers = handlers;
    }

    public void run() {
        handleRequest();
    }

    private void handleRequest() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            String request = br.readLine();
            String[] lines = request.split("\\s+");//делим строку по шаблону между словами 1 пробел и болеее
            String userName = lines[1];
            String comand = lines[0];
            System.out.println("Server got string 1 "+userName);
            System.out.println("Server got string 2 "+comand);
            //Thread.sleep(2000);

//            StringBuilder sb = new StringBuilder("Hello, ");
//            sb.append(userName);
            String responnse = buildResponse(comand,userName);
            bw.write(responnse);
            bw.newLine();
            bw.flush();

            br.close();
            bw.close();

            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String buildResponse(String comand, String userName) {
        Greetable handler = handlers.get(comand);
        if (handler != null) {
            return handler.buildResponse(userName);
        }
        return "Hello "+userName;
    }
}
