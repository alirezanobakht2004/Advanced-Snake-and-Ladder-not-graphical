package ir.ac.kntu.gamelogic;

public class Snake {
   
    public static void snakeBite(int snakeHeadI, int snakeHeadJ, int snakeTailI, int snakeTailJ) {
        if (Player.getI() == snakeHeadI && Player.getJ() == snakeHeadJ) {
            Player.setI(snakeTailI);
            Player.setJ(snakeTailJ);
        }
    }
}
