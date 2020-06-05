package edu.javacourse.local;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class TestStreams {

    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("D:/01 - Padam.mp3");
       int lenght = fis.available();
       byte[] data = new byte[lenght];
       fis.read(data);
        FileOutputStream fos = new FileOutputStream("D:/Test/01-Padam.mp3");
        fos.write(data);

        fis.close();
        fos.close();
        //System.out.println("Количество байт = "+sum);
    }
}
