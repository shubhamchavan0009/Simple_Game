
import java.util.Scanner;

public class TicTacToe {

    private static final char PLAYER_1 = 'X';
    private static final char PLAYER_2 = 'O';
    private static final char BLANK = '-';

    private char[][] board;
    private int currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = BLANK;
            }
        }
        currentPlayer = PLAYER_1;
    }

    public void play() {
        while (!isGameOver()) {
            printBoard();
            int row, col;
            do {
                System.out.println("Player " + currentPlayer + ", enter your move (row, col): ");
                Scanner scanner = new Scanner(System.in);
                row = scanner.nextInt();
                col = scanner.nextInt();
            } while (!isValidMove(row, col));

            board[row][col] = (char) currentPlayer;
            currentPlayer = (currentPlayer == PLAYER_1) ? PLAYER_2 : PLAYER_1;
        }

        printBoard();
        if (isPlayer1Winner()) {
            System.out.println("Player 1 wins!");
        } else if (isPlayer2Winner()) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("Tie!");
        }
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == BLANK;
    }

    private boolean isGameOver() {
        return hasPlayerWon() || isBoardFull();
    }

    private boolean hasPlayerWon() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != BLANK) {
                return true;
            } else if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != BLANK) {
                return true;
            }
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != BLANK) {
            return true;
        } else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != BLANK) {
            return true;
        }

        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == BLANK) {
                    return false;
                }
            }
        }

        return true;
    }

    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private boolean isPlayer1Winner() {
        return hasPlayerWon() && currentPlayer == PLAYER_1;
    }

    private boolean isPlayer2Winner() {
        return hasPlayerWon() && currentPlayer == PLAYER_2;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }
}
