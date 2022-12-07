package com.valya.homework.section20.serverSocketThread;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[36m";

    public static void main(String[] args) throws InterruptedException {

        // запускаем подключение сокета по известным координатам и инициализируем приём сообщений с консоли клиента
        try(Socket socket = new Socket("localhost", 8000);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //потому что с консоли System.in, Буфер данных для передачи
            DataOutputStream oos = new DataOutputStream(socket.getOutputStream());   //запись
            DataInputStream ois = new DataInputStream(socket.getInputStream());
        )
        {
            System.out.println("Status: " + ANSI_BLUE + "Client connected..." + ANSI_RESET);
            System.out.println();

            String string = "";
            System.out.println("Status: " + ANSI_BLUE + "Client start writing in channel..." + ANSI_RESET);

            while (!string.equalsIgnoreCase("finish")) {
                string = br.readLine();
                //пишем данные с консоли в канал сокета для сервера
                oos.writeUTF(string);

                System.out.println("Status: " + ANSI_BLUE + "reading..." + ANSI_RESET);
                String in = ois.readUTF();
                System.out.println(in);
            }

            System.out.println("Status: " + ANSI_BLUE + "Closing connections & channels on clientSide - DONE." + ANSI_RESET);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
