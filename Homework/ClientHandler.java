package HW_01;

import java.net.Socket;

// Интерфейс для обработчика клиента
public interface ClientHandler {
    void handleClient(Socket clientSocket);
}

