package ir.ac.kntu.gamelogic;

public class WildSnake {
    private static int snakeHeadI;

    private static int snakeHeadJ;

    private static int snakeTailI;

    private static int snakeTailJ;

    public static void setPosition() {
        setSnakeHeadI();
        setSnakeHeadJ();
        setSnakeTailI();
        setSnakeTailJ();
    }

    public static int getSnakeHeadI() {
        return snakeHeadI;
    }

    public static void setSnakeHeadI() {
        WildSnake.snakeHeadI = RandomHelper.nextInt(Board.getSize() - 1);
    }

    public static int getSnakeHeadJ() {
        return snakeHeadJ;
    }

    public static void setSnakeHeadJ() {
        WildSnake.snakeHeadJ = RandomHelper.nextInt(Board.getSize());
        if (snakeHeadI == 0 && snakeTailJ == Board.getSize() - 1) {
            setPosition();
        }
        if (snakeHeadI == OrdinarySnake.getSnakeHeadI() && snakeHeadJ == OrdinarySnake.getSnakeHeadJ()) {
            setPosition();
        }
        if (snakeHeadI == KindSnake.getSnakeHeadI() && snakeHeadJ == KindSnake.getSnakeHeadJ()) {
            setPosition();
        }
        if (snakeHeadI == OrdinarySnake.getSnakeTailI() && snakeHeadJ == OrdinarySnake.getSnakeTailJ()) {
            setPosition();
        }
        if (snakeHeadI == KindSnake.getSnakeTailI() && snakeHeadJ == KindSnake.getSnakeTailJ()) {
            setPosition();
        }
        if (snakeHeadI == Player.getI() && snakeHeadJ == Player.getJ()) {
            setPosition();
        }
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
        if (snakeTailI == OrdinarySnake.getSnakeHeadI() && snakeTailJ == OrdinarySnake.getSnakeTailJ()) {
            setPosition();
        }
        if (snakeTailI == KindSnake.getSnakeHeadI() && snakeTailJ == KindSnake.getSnakeHeadJ()) {
            setPosition();
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
