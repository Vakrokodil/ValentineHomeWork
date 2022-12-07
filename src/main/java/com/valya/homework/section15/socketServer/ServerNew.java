package com.valya.homework.section15.socketServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerNew {

    public static void main(String[] args) throws IOException {

        String str = "";
        String exitWord = "exit";

        ServerSocket serverSocket = new ServerSocket(5000);

        System.out.println("Server is running...");
        System.out.println("Waiting a client...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        InputStreamReader in = new InputStreamReader(socket.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        while(!str.equals(exitWord)) {
            str = bf.readLine();
            System.out.println("client: " + str);
            PrintWriter pr = new PrintWriter(socket.getOutputStream());
            pr.println("success!");
        }

        System.out.println("Server was disconnected");
    }
}
