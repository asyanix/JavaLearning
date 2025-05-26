public class Game {
    private final String[][] board = new String[3][3];
    private boolean xTurn = true; // true — X, false — O
    private String winner = null;
    private int moves = 0;

    // Модификатор synchronized гарантирует, что только один поток может 
    // одновременно выполнять этот метод на одном и том же объекте
    public synchronized boolean makeMove(String player) {
        while ((xTurn && player.equals("O")) || (!xTurn && player.equals("X"))) {
            try {
                wait(); // Ждём своей очереди
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (winner != null || moves >= 9) return false;

        // Найдём первую свободную клетку 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == null) {
                    board[i][j] = player;
                    moves++;
                    printBoard();
                    checkWinner(player);
                    xTurn = !xTurn;
                    notifyAll(); // Разрешаем следующему
                    return true;
                }
            }
        }

        return false;
    }

    private void printBoard() {
        System.out.println("------");
        for (String[] row : board) {
            for (String cell : row) {
                System.out.print((cell != null ? cell : ".") + " ");
            }
            System.out.println();
        }
        System.out.println("------");
    }

    private void checkWinner(String player) {
        for (int i = 0; i < 3; i++) {
            if (
                player.equals(board[i][0]) && player.equals(board[i][1]) && player.equals(board[i][2]) ||
                player.equals(board[0][i]) && player.equals(board[1][i]) && player.equals(board[2][i])
            ) {
                winner = player;
            }
        }

        if (
            player.equals(board[0][0]) && player.equals(board[1][1]) && player.equals(board[2][2]) ||
            player.equals(board[0][2]) && player.equals(board[1][1]) && player.equals(board[2][0])
        ) {
            winner = player;
        }
    }

    public synchronized String getWinner() {
        return winner != null ? winner : "Ничья";
    }
}
