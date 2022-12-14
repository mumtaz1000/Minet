package com.minet.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void startServer() {
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected!");
                ClientHandler clientHandler = new ClientHandler(socket);

                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocketObject = new ServerSocket(1234);
        Server server = new Server(serverSocketObject);
        server.startServer();
    }
}
