package serverPackage;

import java.io.*;
import java.net.*;
import sharedPackage.Operation;

public class Server {
    public static void main(String[] args) {
        final int PORT = 1234;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Serveur en attente de connexion...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connecté.");

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            Operation op = (Operation) ois.readObject();
            System.out.println("Opération reçue : " + op.getOperand1() + " " + op.getOperator() + " " + op.getOperand2());

            double result = switch (op.getOperator()) {
                case "+" -> op.getOperand1() + op.getOperand2();
                case "-" -> op.getOperand1() - op.getOperand2();
                case "*" -> op.getOperand1() * op.getOperand2();
                case "/" -> op.getOperand2() != 0 ? op.getOperand1() / op.getOperand2() : Double.NaN;
                default -> Double.NaN;
            };

            oos.writeObject(result);
            System.out.println("Résultat envoyé : " + result);

            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erreur serveur : " + e.getMessage());
        }
    }
}