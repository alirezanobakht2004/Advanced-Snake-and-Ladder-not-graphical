package ir.ac.kntu.gamelogic;

public class Dice {
    public static void diceChange() {
        int face = RandomHelper.nextInt(8);
        switch (face) {
            case 0:
                System.out.println("Dice: " + DiceFaces.OneLeft);
                if (Player.getJ() - 1 != -1) {
                    Player.setJ(Player.getJ() - 1);
                }
                break;
            case 1:
                System.out.println("Dice: " + DiceFaces.TwoLeft);
                if (Player.getJ() - 2 != -1) {
                    Player.setJ(Player.getJ() - 2);
                }
                break;
            case 2:
                System.out.println("Dice: " + DiceFaces.OneRight);
                if (Player.getJ() + 1 != Board.getGameBoard().length) {
                    Player.setJ(Player.getJ() + 1);
                }
                break;
            case 3:
                System.out.println("Dice: " + DiceFaces.TwoRight);
                if (Player.getJ() + 2 != Board.getGameBoard().length) {
                    Player.setJ(Player.getJ() + 2);
                }
                break;
            case 4:
                System.out.println("Dice: " + DiceFaces.OneUp);
                if (Player.getI() - 1 != -1) {
                    Player.setI(Player.getI() - 1);
                }
                break;
            case 5:
                System.out.println("Dice: " + DiceFaces.TwoUp);
                if (Player.getI() - 2 != -1) {
                    Player.setI(Player.getI() - 2);
                }
                break;
            case 6:
                System.out.println("Dice: " + DiceFaces.OneDown);
                if (Player.getI() + 1 != Board.getGameBoard().length) {
                    Player.setI(Player.getI() + 1);
                }
                break;
            case 7:
                System.out.println("Dice: " + DiceFaces.TwoDown);
                if (Player.getI() + 2 != Board.getGameBoard().length) {
                    Player.setI(Player.getI() + 2);
                }
                break;
            case 8:
                System.out.println("Dice: " + DiceFaces.ExtraHealth);
                if (Player.getHealth() < 3) {
                    Player.setHealth(Player.getHealth() + 1);
                }
                break;
            default:
                break;
        }
    }
}
