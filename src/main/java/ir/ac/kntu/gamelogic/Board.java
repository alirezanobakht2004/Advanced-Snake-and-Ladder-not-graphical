package ir.ac.kntu.gamelogic;

import java.util.Scanner;

public class Board {

    private static char[][] gameBoard;
    private static int size;

    public static void setGameBoard(char[][] gameBoard) {
        Board.gameBoard = gameBoard;
    }

    public static char[][] getGameBoard() {
        return gameBoard;
    }

    public static void boardDraw() {
        gameBoard = new char[size][size];
        gameBoard[0][size - 1] = '$';
        positionChange();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (gameBoard[i][j] == 0) {
                    gameBoard[i][j] = ' ';
                }
                System.out.print(gameBoard[i][j] + "|");
            }
            System.out.println();
            for (int k = 0; k < 2 * size; k++) {
                System.out.print('-');
            }
            System.out.println();
        }
    }

    public static void boardSize() {
        System.out.println("Enter the size of your n*n boardgame:");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        size = n;
        boardDraw();
    }

    public static void positionChange(){
        gameBoard[Player.getI()][Player.getJ()]='*';

        
    }
}
