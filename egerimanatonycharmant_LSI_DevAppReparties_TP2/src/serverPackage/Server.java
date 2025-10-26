package serverPackage;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        final int PORT = 1234;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Serveur en attente de connexion...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connecté.");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Lire l'opération complète envoyée par le client
            String operation = in.readLine();
            System.out.println("Opération reçue : " + operation);

            // Calculer le résultat
            String result = calculer(operation);

            // Envoyer le résultat au client
            out.println(result);

            clientSocket.close();
            System.out.println("Connexion fermée.");

        } catch (IOException e) {
            System.err.println("Erreur serveur : " + e.getMessage());
        }
    }

    private static String calculer(String op) {
        try {
            String[] tokens = op.trim().split(" ");
            if (tokens.length != 3) return "Format invalide. Utilisez : nombre1 opérateur nombre2";

            double a = Double.parseDouble(tokens[0]);
            String operateur = tokens[1];
            double b = Double.parseDouble(tokens[2]);

            return switch (operateur) {
                case "+" -> String.valueOf(a + b);
                case "-" -> String.valueOf(a - b);
                case "*" -> String.valueOf(a * b);
                case "/" -> b != 0 ? String.valueOf(a / b) : "Erreur : division par zéro";
                default -> "Opérateur invalide";
            };
        } catch (Exception e) {
            return "Erreur de calcul : " + e.getMessage();
        }
    }
}