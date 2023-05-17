package ir.ac.kntu.gamelogic;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Board {

    private static String[][] gameBoard;

    private static int size;

    private static List<OrdinarySnake> Ordinary = new ArrayList<>();

    private static List<KindSnake> Kind = new ArrayList<>();

    private static List<WildSnake> Wild = new ArrayList<>();

    public static List<WildSnake> getWild() {
        return Wild;
    }

    public static List<KindSnake> getKind() {
        return Kind;
    }

    public static List<OrdinarySnake> getOrdinary() {
        return Ordinary;
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
                if (gameBoard[o][k].equals("")) {
                    gameBoard[o][k] = " ";
                }
                System.out.print(gameBoard[o][k] + "|");
            }
            System.out.println();
            for (int k = 0; k <2 * size; k++) {
                System.out.print("-");
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
        KindSnakesHead();
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
            Ordinary.add(tempOne);
        }

        for (int j = 0; j < b; j++) {
            KindSnake tempTwo = new KindSnake();
            Kind.add(tempTwo);
        }

        for (int k = 0; k < c; k++) {
            WildSnake tempThree = new WildSnake();
            Wild.add(tempThree);
        }
    }

    public void ordinarySnakeHead() {
        for (int i = 0; i < Ordinary.size(); i++) {
            Ordinary.get(i).setSnakeHeadI();
            Ordinary.get(i).setSnakeHeadJ();
        }
    }

    public void KindSnakesHead() {
        for (int j = 0; j < Kind.size(); j++) {
            Kind.get(j).setSnakeHeadI();
            Kind.get(j).setSnakeHeadJ();
        }
    }

    public void positionChange() {
        gameBoard[Player.getI()][Player.getJ()] += "P";
        for (int i = 0; i < Ordinary.size(); i++) {
            Ordinary.get(i).setPosition();
            gameBoard[Ordinary.get(i).getSnakeHeadI()][Ordinary.get(i).getSnakeHeadJ()] += "O" + i;
            gameBoard[Ordinary.get(i).getSnakeTailI()][Ordinary.get(i).getSnakeTailJ()] += "o" + i;
        }

        for (int j = 0; j < Kind.size(); j++) {
            Kind.get(j).setPosition();
            gameBoard[Kind.get(j).getSnakeHeadI()][Kind.get(j).getSnakeHeadJ()] += "K" + j ;
            gameBoard[Kind.get(j).getSnakeTailI()][Kind.get(j).getSnakeTailJ()] += "k" + j ;
        }

        for (int k = 0; k < Wild.size(); k++) {
            Wild.get(k).setPosition();
            gameBoard[Wild.get(k).getSnakeHeadI()][Wild.get(k).getSnakeHeadJ()] += "W" + k ;
            gameBoard[Wild.get(k).getSnakeTailI()][Wild.get(k).getSnakeTailJ()] += "w" + k ;
        }

    }

}
