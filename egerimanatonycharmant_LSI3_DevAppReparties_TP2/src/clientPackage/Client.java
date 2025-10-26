package clientPackage;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import sharedPackage.Operation;

public class Client {
    public static void main(String[] args) {
        final String SERVER_IP = "127.0.0.1"; // ou IP réelle
        final int PORT = 1234;

        try (Socket socket = new Socket(SERVER_IP, PORT)) {
            System.out.println("Connecté au serveur.");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Scanner scanner = new Scanner(System.in);

            System.out.print("Entrez le premier nombre : ");
            double a = scanner.nextDouble();
            System.out.print("Entrez l'opérateur (+, -, *, /) : ");
            String op = scanner.next();
            System.out.print("Entrez le deuxième nombre : ");
            double b = scanner.nextDouble();

            Operation operation = new Operation(a, op, b);
            oos.writeObject(operation);

            double result = (double) ois.readObject();
            System.out.println("Résultat reçu : " + result);

            System.out.println("Appuyez sur Entrée pour quitter...");
            scanner.nextLine(); scanner.nextLine();

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erreur client : " + e.getMessage());
        }
    }
}