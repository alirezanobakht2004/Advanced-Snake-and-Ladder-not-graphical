package ir.ac.kntu.gamelogic;

public class OrdinarySnake {

    private int snakeHeadI;

    private int snakeHeadJ;

    private int snakeTailI;

    private int snakeTailJ;

    public void setPosition() {
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
        if (this.snakeHeadI == 0 && this.snakeHeadJ == Board.getSize() - 1) {
            this.setSnakeHeadI();
            this.setSnakeHeadJ();
        }
        for (int i = 0; i < Board.getOrdinary().indexOf(this); i++) {
            if (this.snakeHeadI == Board.getOrdinary().get(i).getSnakeHeadI()
                    && this.snakeHeadJ == Board.getOrdinary().get(i).getSnakeHeadJ()) {
                this.setSnakeHeadI();
                this.setSnakeHeadJ();
            }
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
        for (int i = 0; i < Board.getKind().size(); i++) {
            if (Board.getKind().get(i).getSnakeHeadI() == this.snakeTailI
                    && Board.getKind().get(i).getSnakeHeadJ() == this.snakeTailJ) {
                this.setPosition();
            }
        }
        for (int j = 0; j < Board.getOrdinary().size(); j++) {
            if (this.snakeTailI == Board.getOrdinary().get(j).getSnakeHeadI()
                    && this.snakeTailJ == Board.getOrdinary().get(j).getSnakeHeadJ()) {
                this.setPosition();
            }
        }

    }

    public void bite() {
        if (Player.getI() == this.snakeHeadI && Player.getJ() == this.snakeHeadJ) {
            Player.setI(this.snakeTailI);
            Player.setJ(this.snakeTailJ);
        }
    }
}
