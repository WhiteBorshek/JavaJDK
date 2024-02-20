package HW_01;

// Реализация интерфейса ClientHandler
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClientHandler implements ClientHandler {
    @Override
    public void handleClient(Socket clientSocket) {
        try (
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            // Отправляем историю чата при подключении нового клиента
            for (String message : Server.getChatHistory()) {
                out.println(message);
            }

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Получено сообщение от клиента: " + inputLine);
                Server.addToChatHistory(inputLine); // Добавляем сообщение в историю чата

                // Рассылаем сообщение всем клиентам
                for (ClientHandler client : Server.getActiveClients()) {
                    if (client != this) { // Исключаем отправку сообщения самому себе
                        ((SimpleClientHandler) client).sendMessage(inputLine);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для отправки сообщения клиенту
    public void sendMessage(String message) {
        // Реализация отправки сообщения клиенту
    }
}

