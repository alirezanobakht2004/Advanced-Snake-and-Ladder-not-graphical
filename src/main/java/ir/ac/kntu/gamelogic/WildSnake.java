package ir.ac.kntu.gamelogic;

public class WildSnake {
    private static int snakeHeadI;

    private static int snakeHeadJ;

    private static int snakeTailI;

    private static int snakeTailJ;

    public static void setPosition() {
        setSnakeHeadI();
        setSnakeHeadJ();
        if(snakeHeadI==OrdinarySnake.getSnakeHeadI() && snakeHeadJ == OrdinarySnake.getSnakeHeadJ())
        {
            setPosition();
        }
        setSnakeTailI();
        setSnakeTailJ();
    }

    public static int getSnakeHeadI() {
        return snakeHeadI;
    }

    public static void setSnakeHeadI() {
        WildSnake.snakeHeadI = RandomHelper.nextInt(Board.getSize() - 2);
    }

    public static int getSnakeHeadJ() {
        return snakeHeadJ;
    }

    public static void setSnakeHeadJ() {
        WildSnake.snakeHeadJ = RandomHelper.nextInt(Board.getSize() - 1);
    }

    public static int getSnakeTailI() {
        return snakeTailI;
    }

    public static void setSnakeTailI() {
        WildSnake.snakeTailI = RandomHelper.nextInt((Board.getSize() - 1) - (WildSnake.snakeHeadI + 1) + 1)
                + (WildSnake.snakeHeadI + 1);
    }

    public static int getSnakeTailJ() {
        return snakeTailJ;
    }

    public static void setSnakeTailJ() {
        if (WildSnake.snakeTailI != Board.getSize() - 1) {
            WildSnake.snakeTailJ = RandomHelper.nextInt(Board.getSize());
        } else {
            WildSnake.snakeTailJ = RandomHelper.nextInt(Board.getSize() - 1) + 1;
        }
    }

    public static void bite() {
        if (Player.getI() == snakeHeadI && Player.getJ() == snakeHeadJ) {
            Player.setI(snakeTailI);
            Player.setJ(snakeTailJ);
            Player.setHealth(Player.getHealth() - 1);
        }
    }

}
