package HW_01;

// Серверная часть с использованием интерфейса ClientHandler
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static final int PORT = 12345;
    private static List<String> chatHistory = new ArrayList<>();
    private static List<ClientHandler> activeClients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Сервер запущен на порту " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Подключился новый клиент: " + clientSocket);

                ClientHandler clientHandler = new SimpleClientHandler();
                activeClients.add(clientHandler);
                clientHandler.handleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized List<String> getChatHistory() {
        return chatHistory;
    }

    public static synchronized void addToChatHistory(String message) {
        chatHistory.add(message);
    }

    public static synchronized List<ClientHandler> getActiveClients() {
        return activeClients;
    }
}

