import java.util.Scanner;

public class Settings {
    private static String player1 = "Гравець1";
    private static String player2 = "Гравець2";

    public static int[] runSettings(Scanner scanner, int currentSize) {
        int boardSize = currentSize;
        while (true) {
            System.out.println("=== Налаштування ===");
            System.out.println("1. Змінити розмір поля");
            System.out.println("2. Змінити імена гравців");
            System.out.println("0. Назад");
            System.out.print("Ваш вибір: ");

            int choice = InputUtils.getIntInput(scanner);
            if (choice == 1) {
                System.out.println("1. 3x3\n2. 5x5\n3. 7x7\n4. 9x9");
                int s = InputUtils.getIntInput(scanner);
                if (s == 1) boardSize = 3;
                else if (s == 2) boardSize = 5;
                else if (s == 3) boardSize = 7;
                else if (s == 4) boardSize = 9;
                else System.out.println("Невірно.");
            } else if (choice == 2) {
                System.out.print("Ім’я першого гравця: ");
                player1 = scanner.next();
                System.out.print("Ім’я другого гравця: ");
                player2 = scanner.next();
            } else if (choice == 0) break;
            FileUtils.saveConfig("config.txt", boardSize, player1, player2);
        }
        return new int[]{boardSize};
    }

    public static String getPlayer1() {
        return player1;
    }

    public static String getPlayer2() {
        return player2;
    }
}
