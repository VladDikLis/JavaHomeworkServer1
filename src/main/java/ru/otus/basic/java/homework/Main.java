package ru.otus.basic.java.homework;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8088);
        Scanner scanner = new Scanner(System.in);

        String userInput1 = "8";
        String userInput2 = "+";
        String userInput3 = "8";
        String userInput = userInput1 + ";" + userInput2 + ";" + userInput3 + ";";

        socket.getOutputStream().write(userInput.getBytes());
        socket.getOutputStream().flush();

        byte [] request = new byte[100];
        socket.getInputStream().read(request);
        String fullRequest = new String(request);
        String[] parts = fullRequest.split(";");

        System.out.println(parts[0]);
    }
}