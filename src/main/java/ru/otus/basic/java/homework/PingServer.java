package ru.otus.basic.java.homework;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class PingServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8088);
        while (true) {
            String sum = "";
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            byte[] request = new byte[100];
            socket.getInputStream().read(request);
            String str = new String(request);
            System.out.println(str);

            String[] parts = str.split(";");

            if (Objects.equals(parts[1], "+")) {
                sum = "Результат: " + (Integer.parseInt(parts[0]) + Integer.parseInt(parts[2])) + ";";
            }
            if (Objects.equals(parts[1], "-")) {
                sum = "Результат: " + (Integer.parseInt(parts[0]) - Integer.parseInt(parts[2])) + ";";
            }
            if (Objects.equals(parts[1], "*")) {
                sum = "Результат: " + (Integer.parseInt(parts[0]) * Integer.parseInt(parts[2])) + ";";
            }
            if (Objects.equals(parts[1], "/")) {
                sum = "Результат: " + (Integer.parseInt(parts[0]) / Integer.parseInt(parts[2])) + ";";
            }

            socket.getOutputStream().write(sum.getBytes());
            socket.getOutputStream().flush();
        }
    }
}
