package com.valya.homework.section20.serverSocketThread.multi;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyClient {

    // constructor takes address and port as parameters
    public MyClient(String address, int port) throws IOException {

        try (Socket socket = new Socket(address, port);
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // for input purposes (from terminal)
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());  // for output purposes (send to the socket)
             DataInputStream ois = new DataInputStream(socket.getInputStream());
            )
        {
            System.out.println("Client has been connected");
            System.out.println();

            // string to persist data from input
            String string = "";
            System.out.println("Client enter messages:");

            while (!string.equalsIgnoreCase("Finish") && !string.equalsIgnoreCase("Shutdown")) {
                string = reader.readLine();
                outputStream.writeUTF(string);

                System.out.println("reading...");
                String in = ois.readUTF();
                System.out.println(in);
            }

            System.out.println("Closing connections & channels on clientSide - DONE.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        MyClient client = new MyClient("localhost", 8000);
    }
}
