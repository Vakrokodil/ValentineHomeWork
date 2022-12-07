package com.valya.homework.section20.serverSocketThread.multi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler extends Thread {
    private final Socket clientSocket;
    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;

    private final MultiServer multiServer;


    public ClientHandler(Socket clientSocket, DataInputStream inputStream, DataOutputStream outputStream, MultiServer multiServer) {
        this.clientSocket = clientSocket;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        this.multiServer = multiServer;
    }

    @Override
    public void run() {

        boolean isShutdown = false;

        try
        {
            String string = "";

            while (!string.equalsIgnoreCase("Finish") && !string.equalsIgnoreCase("Shutdown")) {

                string = inputStream.readUTF();
                System.out.println("READ from client message - " +  string);

                outputStream.writeUTF("Server reply - " + string + " - OK");

            }

            if (string.equalsIgnoreCase("Shutdown")) {
                isShutdown = true;
            }

            System.out.println("Client disconnected");
            System.out.println("Closing connections.");

        } catch (IOException e) {
           throw new RuntimeException(e);
        } finally {
            try {
                clientSocket.close();
                inputStream.close();
                outputStream.close();

                if (isShutdown) {
                    multiServer.shutdown();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}