package HW_01;

// Клиентская часть
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("Подключение к серверу успешно");

            // Чтение истории чата
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println(message);
            }

            // Чтение сообщений от пользователя и отправка их на сервер
            while (true) {
                String userMessage = scanner.nextLine();
                out.println(userMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


