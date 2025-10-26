package clientPackage;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        final String SERVER_IP = "127.0.0.1"; // ou IP r�elle
        final int PORT = 1234;

        try (Socket socket = new Socket(SERVER_IP, PORT)) {
            System.out.println("Connect� au serveur.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            System.out.print("Entrez une op�ration  : ");
            String operation = scanner.nextLine();

            // Envoyer l'op�ration au serveur
            out.println(operation);

            // Lire la r�ponse
            String response = in.readLine();
            System.out.println("R�sultat re�u : " + response);

            System.out.println("Appuyez sur Entr�e pour quitter...");
            scanner.nextLine();

        } catch (IOException e) {
            System.err.println("Erreur client : " + e.getMessage());
        }
    }
}