package com.zehui.net.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTest {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);

            Socket socket = serverSocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = reader.readLine();
            System.out.println("received from client : "+line);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.write("received data: "+ line);
            printWriter.flush();
            serverSocket.close();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
