package ir.ac.kntu.gamelogic;

public class Dice {
    public static void diceChange() {
        int face = RandomHelper.nextInt(8);
        switch (face) {
            case 0:
                System.out.println("Dice: " + DiceFaces.OneLeft);
                break;
            case 1:
                System.out.println("Dice: " + DiceFaces.TwoLeft);
                break;
            case 2:
                System.out.println("Dice: " + DiceFaces.OneRight);
                break;
            case 3:
                System.out.println("Dice: " + DiceFaces.TwoRight);
                break;
            case 4:
                System.out.println("Dice: " + DiceFaces.OneUp);
                break;
            case 5:
                System.out.println("Dice: " + DiceFaces.TwoUp);
                break;
            case 6:
                System.out.println("Dice: " + DiceFaces.OneDown);
                break;
            case 7:
                System.out.println("Dice: " + DiceFaces.TwoDown);
                break;
            case 8:
                System.out.println("Dice: " + DiceFaces.ExtraHealth);
                break;
            default:
                break;
        }
    }
}
