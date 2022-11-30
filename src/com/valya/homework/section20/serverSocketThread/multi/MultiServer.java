package com.valya.homework.section20.serverSocketThread.multi;

import javax.sound.midi.Soundbank;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

public class MultiServer {

    private ServerSocket serverSocket;

    AtomicBoolean isShutdown = new AtomicBoolean();

    // constructor takes port as parameter
    public MultiServer(int port) throws IOException {

            try (ServerSocket serverSocket = new ServerSocket(port)) {

                this.serverSocket = serverSocket;

                System.out.println("The server is ready.");

                while (!serverSocket.isClosed()) {
                    Socket clientSocket = null;

                    try {
                        System.out.println("The server waiting for a client ...");

                        clientSocket = serverSocket.accept();

                        System.out.println("Server: Client has been joined");

                        // for input purposes (from the client)
                        DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
                        DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

                        Thread thread = new ClientHandler(clientSocket, inputStream, outputStream, this);
                        thread.start();

                    } catch (IOException i) {
                        if (isShutdown.get()) {
                            System.out.println("Client sent Shutdown - signal. Ignore Exception");
                        } else {
                            i.printStackTrace();
                        }

                    }
                }
            }
    }

    public void shutdown() throws IOException {
        isShutdown.set(true);
        serverSocket.close();
    }

    public static void main(String args[]) throws IOException {
        MultiServer server = new MultiServer(8000);
    }
}
