package ir.ac.kntu.gamelogic;

import java.util.Scanner;

public class Board {

    private static String[][] gameBoard;

    private static int size;

    public static void setGameBoard(String[][] gameBoard) {
        Board.gameBoard = gameBoard;
    }

    public static String[][] getGameBoard() {
        return gameBoard;
    }

    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        Board.size = size;
    }

    public static void boardDraw() {
        gameBoard = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (gameBoard[i][j] == null) {
                    gameBoard[i][j] = "";
                }
            }
        }
        positionChange();
        gameBoard[0][size - 1] = "$";
        gameBoard[Board.getGameBoard().length - 1][0] = "*";
        if (Player.getI() == Board.getGameBoard().length - 1 && Player.getJ() == 0) {
            gameBoard[Board.getGameBoard().length - 1][0] = "*P";
        }
        if (Player.getI() == 0 && Player.getJ() == size - 1) {
            System.out.println("\n" + "You Win!" + "\n");
            System.exit(0);
        }
        if (Player.getHealth() == 0) {
            System.out.println("\n" + "You Lose!" + "\n");
            System.exit(0);
        }
        for (int o = 0; o < size; o++) {
            for (int k = 0; k < size; k++) {
                if (gameBoard[o][k] == "") {
                    gameBoard[o][k] = " ";
                }
                System.out.print(gameBoard[o][k] + "|");
            }
            System.out.println();
            for (int k = 0; k < 2 * size; k++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static void boardStart() {
        System.out.println("Enter the size of your n*n boardgame:");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        size = n;
        System.out.println("Health: " + Player.getHealth());
        OrdinarySnake.setSnakeHeadI();
        OrdinarySnake.setSnakeHeadJ();
        KindSnake.setSnakeHeadI();
        KindSnake.setSnakeHeadJ();
        boardDraw();
    }

    public static void positionChange() {
        gameBoard[Player.getI()][Player.getJ()] += "P";
        OrdinarySnake.setPosition();
        gameBoard[OrdinarySnake.getSnakeHeadI()][OrdinarySnake.getSnakeHeadJ()] += "O";
        gameBoard[OrdinarySnake.getSnakeTailI()][OrdinarySnake.getSnakeTailJ()] += "o";
        KindSnake.setPosition();
        gameBoard[KindSnake.getSnakeHeadI()][KindSnake.getSnakeHeadJ()] += "K";
        gameBoard[KindSnake.getSnakeTailI()][KindSnake.getSnakeTailJ()] += "k";
        WildSnake.setPosition();
        gameBoard[WildSnake.getSnakeHeadI()][WildSnake.getSnakeHeadJ()] += "W";
        gameBoard[WildSnake.getSnakeTailI()][WildSnake.getSnakeTailJ()] += "w";

    }
}
