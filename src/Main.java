import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        board.displayBoard();

        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';

        while (true) {
            System.out.println("Player " + currentPlayer + ", enter row (0-2) and column (0-2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board.placeSymbol(row, col, currentPlayer)) {
                board.displayBoard();

                if (board.checkForWin()) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                } else if(board.isBoardFull()) {
                    System.out.println("It's a draw!");
                    break;
                } else {
                    currentPlayer = (currentPlayer == 'X' ? 'O' : 'X');
                }
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
    }
}
