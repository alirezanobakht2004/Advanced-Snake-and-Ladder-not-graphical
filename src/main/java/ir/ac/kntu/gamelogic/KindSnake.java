package ir.ac.kntu.gamelogic;

public class KindSnake {

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
        this.snakeHeadI = RandomHelper.nextInt((Board.getSize() - 1)) + 1;
    }

    public int getSnakeHeadJ() {
        return this.snakeHeadJ;
    }

    public void setSnakeHeadJ() {
        if (snakeHeadJ != Board.getSize() - 1) {
            this.snakeHeadJ = RandomHelper.nextInt(Board.getSize());
        } else {
            this.snakeHeadJ = RandomHelper.nextInt(Board.getSize() - 1) + 1;
        }
        for (int i = 0; i < Board.getOrdinary().size(); i++) {
            if (Board.getOrdinary().get(i).getSnakeHeadI() == this.snakeHeadI
                    && Board.getOrdinary().get(i).getSnakeHeadJ() == this.snakeHeadJ) {
                this.setSnakeHeadI();
                this.setSnakeHeadJ();
            }
        }
        for (int j = 0; j < Board.getKind().indexOf(this); j++) {
            if (this.snakeHeadI == Board.getKind().get(j).getSnakeHeadI()
                    && this.snakeHeadJ == Board.getKind().get(j).getSnakeHeadJ()) {
                this.setSnakeHeadI();
                this.setSnakeHeadJ();
            }
        }

    }

    public int getSnakeTailI() {
        return this.snakeTailI;
    }

    public void setSnakeTailI() {
        this.snakeTailI = RandomHelper.nextInt((this.snakeHeadI));
    }

    public int getSnakeTailJ() {
        return this.snakeTailJ;
    }

    public void setSnakeTailJ() {
        if (this.snakeTailI != 0) {
            this.snakeTailJ = RandomHelper.nextInt(Board.getSize());
        } else {
            this.snakeTailJ = RandomHelper.nextInt(Board.getSize() - 1);
        }
        for (int i = 0; i < Board.getOrdinary().size(); i++) {
            if (Board.getOrdinary().get(i).getSnakeHeadI() == this.snakeTailI
                    && Board.getOrdinary().get(i).getSnakeHeadJ() == this.snakeTailJ) {
                setSnakeHeadJ();
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
