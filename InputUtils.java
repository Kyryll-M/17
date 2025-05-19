import java.util.Scanner;

public class InputUtils {
    public static int getIntInput(Scanner scanner) {
        if (scanner.hasNextInt()) return scanner.nextInt();
        scanner.next(); return -1;
    }

    public static int[] getValidMove(Scanner scanner, char[][] board, int boardSize) {
        int row = -1, col = -1;
        while (true) {
            System.out.print("Введіть рядок та стовпець: ");
            if (scanner.hasNextInt()) {
                row = scanner.nextInt();
                if (scanner.hasNextInt()) {
                    col = scanner.nextInt();
                    if (row >= 1 && row <= boardSize && col >= 1 && col <= boardSize &&
                            board[row * 2 - 1][col * 2 - 1] == ' ') {
                        return new int[]{row, col};
                    }
                }
            }
            scanner.nextLine();
            System.out.println("Невірний хід.");
        }
    }
}