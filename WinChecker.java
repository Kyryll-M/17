public class WinChecker {
    public static boolean checkWin(char[][] board, int boardSize, char player) {
        for (int i = 1; i <= (boardSize * 2) - 1; i += 2) {
            int count = 0;
            for (int j = 1; j <= (boardSize * 2) - 1; j += 2)
                if (board[i][j] == player) count++;
            if (count == boardSize) return true;
        }

        for (int j = 1; j <= (boardSize * 2) - 1; j += 2) {
            int count = 0;
            for (int i = 1; i <= (boardSize * 2) - 1; i += 2)
                if (board[i][j] == player) count++;
            if (count == boardSize) return true;
        }

        int countMain = 0;
        int countSec = 0;
        for (int i = 1; i <= (boardSize * 2) - 1; i += 2) {
            if (board[i][i] == player) countMain++;
            if (board[i][(boardSize * 2) - i] == player) countSec++;
        }
        return countMain == boardSize || countSec == boardSize;
    }

    public static boolean checkDraw(char[][] board, int boardSize) {
        for (int i = 1; i <= (boardSize * 2) - 1; i += 2)
            for (int j = 1; j <= (boardSize * 2) - 1; j += 2)
                if (board[i][j] == ' ') return false;
        return true;
    }
}