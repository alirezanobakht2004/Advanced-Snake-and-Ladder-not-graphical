package ir.ac.kntu.gamelogic;

public class KindSnake {

    private static int snakeHeadI;

    private static int snakeHeadJ;

    private static int snakeTailI;

    private static int snakeTailJ;

    public static void setPosition() {
        setSnakeTailI();
        setSnakeTailJ();
    }

    public static int getSnakeHeadI() {
        return snakeHeadI;
    }

    public static void setSnakeHeadI() {
        KindSnake.snakeHeadI = RandomHelper.nextInt((Board.getSize() - 1)) + 1;
    }

    public static int getSnakeHeadJ() {
        return snakeHeadJ;
    }

    public static void setSnakeHeadJ() {
        if (snakeHeadJ != Board.getSize() - 1) {
            KindSnake.snakeHeadJ = RandomHelper.nextInt(Board.getSize());

        } else {
            KindSnake.snakeHeadJ = RandomHelper.nextInt(Board.getSize() - 1) + 1;
        }
    }

    public static int getSnakeTailI() {
        return snakeTailI;
    }

    public static void setSnakeTailI() {
        KindSnake.snakeTailI = RandomHelper.nextInt((KindSnake.snakeHeadI));
    }

    public static int getSnakeTailJ() {
        return snakeTailJ;
    }

    public static void setSnakeTailJ() {
        if (KindSnake.snakeTailI != 0) {
            KindSnake.snakeTailJ = RandomHelper.nextInt(Board.getSize()-1);
        } else {
            KindSnake.snakeTailJ = RandomHelper.nextInt(Board.getSize());
        }
    }

    public static void bite() {
        if (Player.getI() == snakeHeadI && Player.getJ() == snakeHeadJ) {
            Player.setI(snakeTailI);
            Player.setJ(snakeTailJ);
        }
    }

}
