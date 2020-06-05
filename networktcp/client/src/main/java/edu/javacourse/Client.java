package edu.javacourse;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            //sendRequest();
            SimpleClient sc = new SimpleClient(i);
            sc.start();
        }
    }

    private static void sendRequest() throws IOException {
        Socket client = new Socket("127.0.0.1",25225);

        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

        String str = "Дмитрий";
        bw.write(str);
        bw.newLine();
        bw.flush();

        String answer = br.readLine();
        System.out.println("Client got string "+answer);

        br.close();
        bw.close();
    }
}

class SimpleClient extends Thread {

    private static final String[] COMAND = {
            "HELLO", "MORNING", "DAY", "IVNING"};
    private int cmdNumber;

    public SimpleClient(int cmdNumber) {
        this.cmdNumber = cmdNumber;
    }

    @Override
    public void run() {
        try {
            //System.out.println("Started "+ LocalDateTime.now());
            Socket client = new Socket("127.0.0.1",25225);

            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            String comand = COMAND[cmdNumber % COMAND.length];
            String str = comand + " "+ "Дмитрий";
            bw.write(str);
            bw.newLine();
            bw.flush();

            String answer = br.readLine();
            System.out.println("Client got string "+answer);

            br.close();
            bw.close();
            //System.out.println("Finished "+ LocalDateTime.now());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
