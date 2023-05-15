package ir.ac.kntu.gamelogic;

public class Dice {
    public void diceChange() {
        int face = RandomHelper.nextInt(8);
        switch (face) {
            case 0:
                System.out.println(DiceFaces.OneLeft);
                break;
            case 1:
                System.out.println(DiceFaces.TwoLeft);
                break;
            case 2:
                System.out.println(DiceFaces.OneRight);
                break;
            case 3:
                System.out.println(DiceFaces.TwoRight);
                break;
            case 5:
                System.out.println(DiceFaces.OneUp);
                break;
            case 6:
                System.out.println(DiceFaces.TwoUp);
                break;
            case 7:
                System.out.println(DiceFaces.OneDown);
                break;
            case 8:
                System.out.println(DiceFaces.TwoDown);
                break;
            default:
                break;
        }
    }
}
