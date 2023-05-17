package ir.ac.kntu.gamelogic;

public class Dice {
    public static void diceChange() {
        switch (RandomHelper.nextInt(9)) {
            case 0:
                playerChangeZero();
                break;
            case 1:
                playerChangeOne();
                break;
            case 2:
                playerChangeTwo();
                break;
            case 3:
                playerChangeThree();
                break;
            case 4:
                playerChangeFour();
                break;
            case 5:
                playerChangeFive();
                break;
            case 6:
                playerChangeSix();
                break;
            case 7:
                playerChangeSeven();
                break;
            case 8:
                System.out.println("Dice: " + DiceFaces.ExtraHealth);
                if (Player.getHealth() < 3) {
                    Player.setHealth(Player.getHealth() + 1);
                }
                diceChange();
                break;
            default:
                break;
        }
    }

    public static void bite() {
        for (int i = 0; i < Board.getOrdinary().size(); i++) {
            Board.getOrdinary().get(i).bite();
        }

        for (int j = 0; j < Board.getKind().size(); j++) {
            Board.getKind().get(j).bite();
        }

        for (int k = 0; k < Board.getWild().size(); k++) {
            Board.getWild().get(k).bite();
        }
    }

    public static void playerChangeZero() {
        System.out.println("Dice: " + DiceFaces.OneLeft);
        if (Player.getJ() - 1 >= 0) {
            Player.setJ(Player.getJ() - 1);
            bite();
        }

    }

    public static void playerChangeOne() {
        System.out.println("Dice: " + DiceFaces.TwoLeft);
        if (Player.getJ() - 2 >= 0) {
            Player.setJ(Player.getJ() - 2);
            bite();
        }

    }

    public static void playerChangeTwo() {
        System.out.println("Dice: " + DiceFaces.OneRight);
        if (Player.getJ() + 1 < Board.getGameBoard().length) {
            Player.setJ(Player.getJ() + 1);
            bite();
        }

    }

    public static void playerChangeThree() {
        System.out.println("Dice: " + DiceFaces.TwoRight);
        if (Player.getJ() + 2 < Board.getGameBoard().length) {
            Player.setJ(Player.getJ() + 2);
            bite();
        }

    }

    public static void playerChangeFour() {
        System.out.println("Dice: " + DiceFaces.OneUp);
        if (Player.getI() - 1 >= 0) {
            Player.setI(Player.getI() - 1);
            bite();
        }

    }

    public static void playerChangeFive() {
        System.out.println("Dice: " + DiceFaces.TwoUp);
        if (Player.getI() - 2 >= 0) {
            Player.setI(Player.getI() - 2);
            bite();
        }

    }

    public static void playerChangeSix() {
        System.out.println("Dice: " + DiceFaces.OneDown);
        if (Player.getI() + 1 < Board.getGameBoard().length) {
            Player.setI(Player.getI() + 1);
            bite();
        }

    }

    public static void playerChangeSeven() {
        System.out.println("Dice: " + DiceFaces.TwoDown);
        if (Player.getI() + 2 < Board.getGameBoard().length) {
            Player.setI(Player.getI() + 2);
            bite();
        }
    }
}
