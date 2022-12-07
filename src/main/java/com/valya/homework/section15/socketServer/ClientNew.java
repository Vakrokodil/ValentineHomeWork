package com.valya.homework.section15.socketServer;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class ClientNew {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 5000);

        String clientLine = "";
        String exitWord = "exit";

        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (!clientLine.equals(exitWord)) {
            System.out.println("client: ");
            clientLine = reader.readLine();
            writer.println(clientLine);
        }

        InputStreamReader in = new InputStreamReader(socket.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        String str = bf.readLine();
        System.out.println("server: " + str);

    }
}
