import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int boardSize = 3;
        String player1 = "Гравець1";
        String player2 = "Гравець2";

        String[] config = FileUtils.loadConfig("config.txt");
        if (config != null) {
            boardSize = Integer.parseInt(config[0]);
            player1 = config[1];
            player2 = config[2];
        }

        char[][] board = new char[1][1];
        char currentPlayer = 'X';

        while (true) {
            System.out.println("=== Головне меню ===");
            System.out.println("1. Розпочати гру");
            System.out.println("2. Налаштування");
            System.out.println("3. Ознайомитися з правилами");
            System.out.println("4. Вийти");

            System.out.print("Ваш вибір: ");

            int choice = InputUtils.getIntInput(scanner);
            switch (choice) {
                case 1:
                    Game.runGame(scanner, boardSize, player1, player2);
                    break;
                case 2:
                    int[] sizeAndNames = Settings.runSettings(scanner, boardSize);
                    boardSize = sizeAndNames[0];
                    player1 = Settings.getPlayer1();
                    player2 = Settings.getPlayer2();
                    break;
                case 3:
                    System.out.println("=== Правила гри ===");
                    System.out.println("Потрібно поставити свої символи в ряд, стовпчик або діагональ.");
                    break;
                case 4:
                    System.out.println("Вихід...");
                    return;
                case 5:
                    FileUtils.displayStats("stats.txt");
                    break;
                default:
                    System.out.println("Невірний вибір.");
            }
        }
    }
}