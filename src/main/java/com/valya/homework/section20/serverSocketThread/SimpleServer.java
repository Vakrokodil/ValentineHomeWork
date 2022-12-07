package com.valya.homework.section20.serverSocketThread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class SimpleServer {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[36m";

    public static void main(String[] args) throws InterruptedException {

        //создаю серверСокет на порту 8000
        try (ServerSocket server = new ServerSocket(8000))
        {
            //ожидание подключения к сокету "client" на серверной стороне
            System.out.println("Status: " + ANSI_BLUE + "The Server is waiting for a client." + ANSI_RESET);
            Socket client = server.accept();

            //сервер ассоциирует подключающегося клиента с этим сокет- соединением
            System.out.println("Status: " + ANSI_BLUE + "Connection accept" + ANSI_RESET);

            //инициируем канал чтения в сокете для сервера
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            String entry = "";

            while (!entry.equalsIgnoreCase("finish")) {
                System.out.println("Status: " + ANSI_BLUE + "Server reading from channel" + ANSI_RESET);
                entry = in.readUTF();
                System.out.println("READ from client message - "+ ANSI_BLUE + entry + ANSI_RESET);

                out.writeUTF("Server reply - " + ANSI_BLUE + entry +  ANSI_RESET + " - OK" );
            }

            //если условие выхода -верно выключаем соединения
            System.out.println("Status: " + ANSI_BLUE + "Client disconnected" + ANSI_RESET);
            System.out.println("Status: " + ANSI_BLUE + "Closing connections." + ANSI_RESET);

            //закрываем сначала канал сокета!
            in.close();

            //затем закрыаем сокет общения на стороне сервера!
            client.close();

            System.out.println("Status: " + ANSI_BLUE + "Closing connections & channels - DONE." + ANSI_RESET);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
