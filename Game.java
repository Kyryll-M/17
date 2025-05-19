import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Game {
    public static void runGame(Scanner scanner, int boardSize, String player1, String player2) {
        int gridSize = (boardSize * 2) + 1;
        char[][] board = BoardUtils.initBoard(boardSize);
        char currentPlayer = 'X';
        boolean gameOver = false;

        while (!gameOver) {
            BoardUtils.printBoard(board);
            System.out.println("Гравець " + (currentPlayer == 'X' ? player1 : player2) + " (" + currentPlayer + "), ваш хід.");
            int[] move = InputUtils.getValidMove(scanner, board, boardSize);
            int row = move[0];
            int col = move[1];

            board[row * 2 - 1][col * 2 - 1] = currentPlayer;

            if (WinChecker.checkWin(board, boardSize, currentPlayer)) {
                System.out.println("Гравець " + (currentPlayer == 'X' ? player1 : player2) + " переміг!");
                FileUtils.saveWinStat("stats.txt", currentPlayer, boardSize, (currentPlayer == 'X' ? player1 : player2));
                gameOver = true;
            } else if (WinChecker.checkDraw(board, boardSize)) {
                System.out.println("Нічия");
                FileUtils.saveDrawStat("stats.txt", boardSize);
                gameOver = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }
}