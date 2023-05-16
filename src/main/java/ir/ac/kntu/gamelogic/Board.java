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
        positionChange();
        gameBoard[0][size - 1] = "$";
        if (gameBoard[Board.getGameBoard().length - 1][0] != "P") {
            gameBoard[Board.getGameBoard().length - 1][0] = "*";
        }
        if(Player.getI()==0 && Player.getJ()==size - 1)
        {
            System.out.println("\n"+"You Win!"+"\n");
            System.exit(0);
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (gameBoard[i][j] ==null) {
                    gameBoard[i][j] = " ";
                }
                System.out.print(gameBoard[i][j] + "|");
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
        boardDraw();
    }

    public static void positionChange() {
        OrdinarySnake.setPosition();
        gameBoard[Player.getI()][Player.getJ()] = "P";
        gameBoard[OrdinarySnake.getSnakeHeadI()][OrdinarySnake.getSnakeHeadJ()] = "O";
        gameBoard[OrdinarySnake.getSnakeTailI()][OrdinarySnake.getSnakeTailJ()] = "o";
        if (OrdinarySnake.getSnakeTailI() == Player.getI() && OrdinarySnake.getSnakeTailJ() == Player.getJ()) {
            gameBoard[OrdinarySnake.getSnakeTailI()][OrdinarySnake.getSnakeTailJ()] +="P";
        }
        WildSnake.setPosition();
        gameBoard[Player.getI()][Player.getJ()] = "P";
        gameBoard[WildSnake.getSnakeHeadI()][WildSnake.getSnakeHeadJ()] = "W";
        gameBoard[WildSnake.getSnakeTailI()][WildSnake.getSnakeTailJ()] = "w";
        if (WildSnake.getSnakeTailI() == Player.getI() && WildSnake.getSnakeTailJ() == Player.getJ()) {
            gameBoard[WildSnake.getSnakeTailI()][WildSnake.getSnakeTailJ()] +="P";
        }
        if (WildSnake.getSnakeTailI() == OrdinarySnake.getSnakeTailI() && WildSnake.getSnakeTailJ() ==  OrdinarySnake.getSnakeTailJ()) {
            gameBoard[WildSnake.getSnakeTailI()][WildSnake.getSnakeTailJ()] +="o";
        }
    }
}
