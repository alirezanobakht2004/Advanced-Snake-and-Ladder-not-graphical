package ir.ac.kntu.gamelogic;

import java.util.Scanner;

public class Board {
    private char[][] gameBoard;
    private char[][] elementOfBoard;

    public void boardDraw() {
        System.out.println("Enter the size of your n*n boardgame:");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        gameBoard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (gameBoard[i][j] == 0) {
                    gameBoard[i][j] = ' ';
                }
                System.out.print(gameBoard[i][j] + "|");
            }
            System.out.println();
            for (int k = 0; k < 2 * n; k++) {
                System.out.print('-');
            }
            System.out.println();
        }
    }
}
