package ir.ac.kntu.gamelogic;

public class Player {

    private static int Health = 3;

    private static int i=Board.getSize()-1;

    private static int j=0;

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        Player.i = i;
    }

    public static int getJ() {
        return j;
    }

    public static void setJ(int j) {
        Player.j = j;
    }

    public static int getHealth() {
        return Health;
    }

    public static void setHealth(int health) {
        Health = health;
    }
}
