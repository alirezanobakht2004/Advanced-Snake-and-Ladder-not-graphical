package ir.ac.kntu.gamelogic;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Board {

    private static String[][] gameBoard;

    private static int size;

    private static List<OrdinarySnake> ordinary = new ArrayList<>();

    private static List<KindSnake> kind = new ArrayList<>();

    private static List<WildSnake> wild = new ArrayList<>();

    public static List<WildSnake> getWild() {
        return wild;
    }

    public static List<KindSnake> getKind() {
        return kind;
    }

    public static List<OrdinarySnake> getOrdinary() {
        return ordinary;
    }

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

    public void boardDraw() {
        gameBoard = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (gameBoard[i][j] == null) {
                    gameBoard[i][j] = "";
                }
            }
        }
        positionChange();
        gameBoard[0][size - 1] = "\033[1;92m" + "$" + "\033[0m";
        gameBoard[Board.getGameBoard().length - 1][0] = "\033[1;96m" + "*" + "\033[0m";
        if (Player.getI() == Board.getGameBoard().length - 1 && Player.getJ() == 0) {
            gameBoard[Board.getGameBoard().length - 1][0] = "\033[1;96m" + "*P" + "\033[0m";
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
                if (gameBoard[o][k].equals("")) {
                    gameBoard[o][k] = " ";
                }
                System.out.print(gameBoard[o][k] + "\033[1;91m" + "|" + "\033[0m");
            }
            System.out.println();
            for (int k = 0; k < 2 * size; k++) {
                System.out.print("\033[1;93m" + "-" + "\033[0m");
            }
            System.out.println();
        }
    }

    public void boardStart() {
        System.out.println("Enter the size of your n*n boardgame:");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        size = n;
        System.out.println("Health: " + Player.getHealth());
        snakesNumber();
        ordinarySnakeHead();
        kindSnakesHead();
        boardDraw();
    }

    public void snakesNumber() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of OrdinarySnakes:");
        int a = input.nextInt();
        System.out.println("Enter number of KindSnakes:");
        int b = input.nextInt();
        System.out.println("Enter number of WildSnakes:");
        int c = input.nextInt();

        for (int i = 0; i < a; i++) {
            OrdinarySnake tempOne = new OrdinarySnake();
            ordinary.add(tempOne);
        }

        for (int j = 0; j < b; j++) {
            KindSnake tempTwo = new KindSnake();
            kind.add(tempTwo);
        }

        for (int k = 0; k < c; k++) {
            WildSnake tempThree = new WildSnake();
            wild.add(tempThree);
        }
    }

    public void ordinarySnakeHead() {
        for (int i = 0; i < ordinary.size(); i++) {
            ordinary.get(i).setSnakeHeadI();
            ordinary.get(i).setSnakeHeadJ();
        }
    }

    public void kindSnakesHead() {
        for (int j = 0; j < kind.size(); j++) {
            kind.get(j).setSnakeHeadI();
            kind.get(j).setSnakeHeadJ();
        }
    }

    public void positionChange() {
        gameBoard[Player.getI()][Player.getJ()] += "\033[1;96m" + "P" + "\033[0m";
        for (int i = 0; i < ordinary.size(); i++) {
            ordinary.get(i).setPosition();
            gameBoard[ordinary.get(i).getSnakeHeadI()][ordinary.get(i).getSnakeHeadJ()] += "O" + i;
            gameBoard[ordinary.get(i).getSnakeTailI()][ordinary.get(i).getSnakeTailJ()] += "o" + i;
        }

        for (int j = 0; j < kind.size(); j++) {
            kind.get(j).setPosition();
            gameBoard[kind.get(j).getSnakeHeadI()][kind.get(j).getSnakeHeadJ()] += "K" + j;
            gameBoard[kind.get(j).getSnakeTailI()][kind.get(j).getSnakeTailJ()] += "k" + j;
        }

        for (int k = 0; k < wild.size(); k++) {
            wild.get(k).setPosition();
            gameBoard[wild.get(k).getSnakeHeadI()][wild.get(k).getSnakeHeadJ()] += "W" + k;
            gameBoard[wild.get(k).getSnakeTailI()][wild.get(k).getSnakeTailJ()] += "w" + k;
        }

    }

}
