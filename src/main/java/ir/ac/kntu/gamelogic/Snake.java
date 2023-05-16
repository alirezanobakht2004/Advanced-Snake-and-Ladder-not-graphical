package ir.ac.kntu.gamelogic;

public class Snake {
    private int snakeHeadI;
    private int snakeHeadJ;

    private int snakeTailI;
    private int snakeTailJ;

    public Snake(int snakeHeadI, int snakeHeadJ, int snakeTailI, int snakeTailJ) {
        this.snakeHeadI = snakeHeadI;
        this.snakeHeadJ = snakeHeadJ;
        this.snakeTailI = snakeTailI;
        this.snakeTailJ = snakeTailJ;
    }

    public void snakeBite() {
        if (Player.getI() == snakeHeadI && Player.getJ() == snakeHeadJ) {
            Player.setI(snakeTailI);
            Player.setJ(snakeTailJ);
        }
    }
}
