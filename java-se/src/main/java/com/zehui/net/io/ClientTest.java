package com.zehui.net.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientTest {
    public static void main(String[] args) {
        String msg= "hello world";
        Socket socket  = null;
        try {
            socket = new Socket("localhost",8080);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter.println(msg);
            printWriter.flush();
            String line = bufferedReader.readLine();
            System.out.println("received from server: " + line );
            printWriter.close();;
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
