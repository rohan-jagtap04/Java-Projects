public class Miscellaneous {
    public static void flushOutPreviousGameData(Player player, Player player2){ //Accepts two player objects
        player.hand = 0; //Clears all previous player data 
        player.splitHand = 0;
        player.hasSplit = false;
        player2.hand = 0;
    }

    public static void moneyChecker(Player player){ //Accepts a player object
        if(player.money <= 0){ //If player money if below or equal to zero, program exits with a ending message
            Prompter.moneyDepleted(); // Ending message
            System.exit(0);
        }
    }
}
