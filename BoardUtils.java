public class BoardUtils {
    public static char[][] initBoard(int boardSize) {
        int gridSize = boardSize * 2 + 1;
        char[][] board = new char[gridSize][gridSize];

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (i == 0 && j == 0) {
                    board[i][j] = ' ';
                } else if (i == 0 && j % 2 == 1) {
                    board[i][j] = (char) ('0' + (j / 2 + 1));
                } else if (j == 0 && i % 2 == 1) {
                    board[i][j] = (char) ('0' + (i / 2 + 1));
                } else if (i % 2 == 0 && j % 2 == 0) {
                    board[i][j] = '+';
                } else if (i % 2 == 0) {
                    board[i][j] = '-';
                } else if (j % 2 == 0) {
                    board[i][j] = '|';
                } else {
                    board[i][j] = ' ';
                }
            }
        }
        return board;
    }

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(" " + cell + " ");
            }
            System.out.println();
        }
    }
}