package org.example;

import org.example.dao.puntuacionesDAOMySql;
import org.example.entities.puntuaciones;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        puntuacionesDAOMySql dao = new puntuacionesDAOMySql();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Menu:");
            System.out.println("1. List all scores");
            System.out.println("2. Insert a new score");
            System.out.println("3. Delete a score");
            System.out.println("4. Update a score");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    List<puntuaciones> scores = dao.getAll();
                    for (puntuaciones score : scores) {
                        System.out.println(score);
                    }
                    break;
                case 2:
                    System.out.print("Enter player name: ");
                    String player = scanner.nextLine();
                    System.out.print("Enter score: ");
                    int score = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    dao.insertPuntuacion(new puntuaciones(player, score));
                    break;
                case 3:
                    System.out.print("Enter player name to delete: ");
                    String playerToDelete = scanner.nextLine();
                    dao.deletePuntuacion(new puntuaciones(playerToDelete, 0));
                    break;
                case 4:
                    System.out.print("Enter player name to update: ");
                    String playerToUpdate = scanner.nextLine();
                    System.out.print("Enter new score: ");
                    int newScore = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    dao.updatePuntuacion(new puntuaciones(playerToUpdate, newScore));
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 5);

        scanner.close();
    }
}