package ir.ac.kntu.gamelogic;

import java.util.Scanner;

public class Game {

    public void gameStart() {
        Scanner input = new Scanner(System.in);
        System.out.println("Write DICE and enter to see your chance:");
        String dice = input.nextLine();
        if (dice.equals("DICE")) {
            Dice.diceChange();
            System.out.println("Health: " + Player.getHealth());
            Board x =new Board();
            x.boardDraw();
            //Board.boardDraw();
            gameStart();
        }
    }

}
