package ir.ac.kntu.gamelogic;

public class WildSnake {
    private int snakeHeadI;

    private int snakeHeadJ;

    private int snakeTailI;

    private int snakeTailJ;

    public void setPosition() {
        setSnakeHeadI();
        setSnakeHeadJ();
        setSnakeTailI();
        setSnakeTailJ();
    }

    public int getSnakeHeadI() {
        return this.snakeHeadI;
    }

    public void setSnakeHeadI() {
        this.snakeHeadI = RandomHelper.nextInt(Board.getSize() - 1);
    }

    public int getSnakeHeadJ() {
        return this.snakeHeadJ;
    }

    public void setSnakeHeadJ() {
        this.snakeHeadJ = RandomHelper.nextInt(Board.getSize());
        if (this.snakeHeadI == 0 && this.snakeTailJ == Board.getSize() - 1) {
            setPosition();
        }
        for (int i = 0; i < Board.getOrdinary().size(); i++) {
            if (this.snakeHeadI == Board.getOrdinary().get(i).getSnakeHeadI()
                    && this.snakeHeadJ == Board.getOrdinary().get(i).getSnakeHeadJ()) {
                setPosition();
            }
            if (this.snakeHeadI == Board.getOrdinary().get(i).getSnakeTailI()
                    && this.snakeHeadJ == Board.getOrdinary().get(i).getSnakeTailJ()) {
                setPosition();
            }
        }
        for (int j = 0; j < Board.getKind().size(); j++) {
            if (this.snakeHeadI == Board.getKind().get(j).getSnakeHeadI()
                    && this.snakeHeadJ == Board.getKind().get(j).getSnakeHeadJ()) {
                setPosition();
            }

            if (this.snakeHeadI == Board.getKind().get(j).getSnakeTailI()
                    && this.snakeHeadJ == Board.getKind().get(j).getSnakeTailJ()) {
                setPosition();
            }
        }

        if (this.snakeHeadI == Player.getI() && this.snakeHeadJ == Player.getJ()) {
            setPosition();
        }
    }

    public int getSnakeTailI() {
        return this.snakeTailI;
    }

    public void setSnakeTailI() {
        this.snakeTailI = RandomHelper.nextInt((Board.getSize() - 1) - (this.snakeHeadI + 1) + 1)
                + (this.snakeHeadI + 1);
    }

    public int getSnakeTailJ() {
        return this.snakeTailJ;
    }

    public void setSnakeTailJ() {
        if (this.snakeTailI != Board.getSize() - 1) {
            this.snakeTailJ = RandomHelper.nextInt(Board.getSize());
        } else {
            this.snakeTailJ = RandomHelper.nextInt(Board.getSize() - 1) + 1;
        }
        for (int i = 0; i < Board.getOrdinary().size(); i++) {
            if (this.snakeTailI == Board.getOrdinary().get(i).getSnakeHeadI()
                    && this.snakeTailJ == Board.getOrdinary().get(i).getSnakeTailJ()) {
                setPosition();
            }
        }

        for (int j = 0; j < Board.getKind().size(); j++) {
            if (this.snakeTailI == Board.getKind().get(j).getSnakeHeadI()
                    && this.snakeTailJ == Board.getKind().get(j).getSnakeHeadJ()) {
                setPosition();
            }
        }

    }

    public void bite() {
        if (Player.getI() == this.snakeHeadI && Player.getJ() == this.snakeHeadJ) {
            Player.setI(this.snakeTailI);
            Player.setJ(this.snakeTailJ);
            Player.setHealth(Player.getHealth() - 1);
        }
    }

}
