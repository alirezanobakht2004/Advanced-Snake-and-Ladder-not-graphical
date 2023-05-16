package ir.ac.kntu.gamelogic;

public class OrdinarySnake {

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
        OrdinarySnake.snakeHeadI = RandomHelper.nextInt(Board.getSize() - 2);
    }

    public static int getSnakeHeadJ() {
        return snakeHeadJ;
    }

    public static void setSnakeHeadJ() {
        OrdinarySnake.snakeHeadJ = RandomHelper.nextInt(Board.getSize() - 1);
    }

    public static int getSnakeTailI() {
        return snakeTailI;
    }

    public static void setSnakeTailI() {
        OrdinarySnake.snakeTailI = RandomHelper.nextInt((Board.getSize() - 1) - (OrdinarySnake.snakeHeadI + 1) + 1)
                + (OrdinarySnake.snakeHeadI + 1);
    }

    public static int getSnakeTailJ() {
        return snakeTailJ;
    }

    public static void setSnakeTailJ() {
        if (OrdinarySnake.snakeTailI != Board.getSize() - 1) {
            OrdinarySnake.snakeTailJ = RandomHelper.nextInt(Board.getSize());
        } else {
            OrdinarySnake.snakeTailJ = RandomHelper.nextInt(Board.getSize() - 1) + 1;
        }
    }

    public static void bite() {
        if (Player.getI() == snakeHeadI && Player.getJ() == snakeHeadJ) {
            Player.setI(snakeTailI);
            Player.setJ(snakeTailJ);
        }
    }
}
