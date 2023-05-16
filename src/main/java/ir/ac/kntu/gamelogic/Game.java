package ir.ac.kntu.gamelogic;

import java.util.Scanner;

public class Game {

    public static void gameStart() {
        Scanner input = new Scanner(System.in);
        System.out.println("Write DICE and enter to see your chance:");
        String dice = input.nextLine();
        if (dice.equals("DICE")) {
            Dice.diceChange();
            System.out.println("Health: " + Player.getHealth());
            Board.boardDraw();
            gameStart();
        }
    }

}
