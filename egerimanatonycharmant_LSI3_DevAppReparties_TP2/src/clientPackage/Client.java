package clientPackage;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import sharedPackage.Operation;

public class Client {
    public static void main(String[] args) {
        final String SERVER_IP = "127.0.0.1"; // ou IP r�elle
        final int PORT = 1234;

        try (Socket socket = new Socket(SERVER_IP, PORT)) {
            System.out.println("Connect� au serveur.");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Scanner scanner = new Scanner(System.in);

            System.out.print("Entrez le premier nombre : ");
            double a = scanner.nextDouble();
            System.out.print("Entrez l'op�rateur (+, -, *, /) : ");
            String op = scanner.next();
            System.out.print("Entrez le deuxi�me nombre : ");
            double b = scanner.nextDouble();

            Operation operation = new Operation(a, op, b);
            oos.writeObject(operation);

            double result = (double) ois.readObject();
            System.out.println("R�sultat re�u : " + result);

            System.out.println("Appuyez sur Entr�e pour quitter...");
            scanner.nextLine(); scanner.nextLine();

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erreur client : " + e.getMessage());
        }
    }
}