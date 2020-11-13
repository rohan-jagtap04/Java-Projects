public class gameEnd {

    private Player person, computer; //Variables representing the two players

    public gameEnd(Player player, Player player2){ //Constructor intializing the two players
        this.person = player;
        this.computer = player2;
    }

    public void endGame(){ //The "main" method for this class containing the methods in order
        if(person.hasSplit == true){
            SplitGameResult(person, computer);
        }else{
            GameResult(person, computer);
        }
    }

    public void GameResult(Player person, Player computer){ //Covers all the different scenarios where player has not split their hand, accepts the two player objects
        //Based on outcome, player_object's wins, losses, and ties are updated as well as their bets are lost or gained
        if(person.hand == 21 || computer.hand == 21){

            if(person.hand == 21){
                Prompter.playerWin(person.Name);
                person.money += person.moneyBetted;
                person.wins++;
                person.gamesPlayed++;

                
            }else if(computer.hand == 21){
                Prompter.playerWin(computer.Name);
                person.money -= person.moneyBetted;
                computer.wins++;
                person.gamesPlayed++;

            }

        }else if(person.hand > 21 || computer.hand > 21){

            if(person.hand > 21){
                Prompter.playerLoss(person.Name, person);
                person.money -= person.moneyBetted;
                computer.wins++;
                person.gamesPlayed++;

            }else if(computer.hand > 21){
                Prompter.playerLoss(computer.Name, computer);
                person.money += person.moneyBetted;
                person.wins++;
                person.gamesPlayed++;

            }

        }else if((21-computer.hand) > (21-person.hand)){
            Prompter.playerWin(person.Name);
            person.money += person.moneyBetted;
            person.wins++;
            person.gamesPlayed++;

        }else if((21-computer.hand) < (21-person.hand)){
            Prompter.playerLoss(person.Name, person);
            person.money -= person.moneyBetted;
            computer.wins++;
            person.gamesPlayed++;

        }else if(computer.hand == person.hand){
            Prompter.playerTied();
            Prompter.moneyRemains();
            person.ties++;
            person.gamesPlayed++;

        }

    }

    public void SplitGameResult(Player person, Player person2){ //Covers all game scenarios where player has split deck, acceptes the two player objects
        //Based on outcome, player_object's wins, losses, and ties are updated as well as their bets are lost or gained
        if(person.splitHand == 21 || person.hand == 21 || person2.hand == 21){

            if(person.splitHand == 21 || person.hand == 21){
                Prompter.playerWin(person.Name);
                person.money += person.moneyBetted;
                person.wins++;
                person.gamesPlayed++;


            }else if(person2.hand == 21){
                Prompter.playerWin(person2.Name);
                person.money -= person.moneyBetted;
                person2.wins++;
                person.gamesPlayed++;
  
            }

        }else if((person.hand > 21 && person.splitHand > 21) || person2.hand > 21){

            if(person.hand > 21 && person.splitHand > 21){
                Prompter.playerLoss(person.Name, person);
                person.money -= person.moneyBetted;
                person2.wins++;
                person.gamesPlayed++;

            }else if(person2.hand > 21){
                Prompter.playerLoss(person2.Name, person2);
                person.money += person.moneyBetted;
                person.wins++;
                person.gamesPlayed++;

            }

        }else if(person.hand < 21 && person.splitHand < 21 && person2.hand < 21){
            if((21-person2.hand) > (21-person.hand) || (21-person2.hand) > (21-person.splitHand)){
                Prompter.playerWin(person.Name);
                person.money += person.moneyBetted;
                person.wins++;
                person.gamesPlayed++;


            }else if((21-person2.hand) < (21-person.hand) || (21-person2.hand) < (21-person.splitHand)){
                Prompter.playerLoss(person.Name, person);
                person.money -= person.moneyBetted;
                person2.wins++;
                person.gamesPlayed++;
            }

        }

    }

    // public void playerTurnResult(Player player){ //Method that checks on individual player after each turn to see if they have automatically won or lost the game
    //     //Based on outcome, player_object's wins, losses, and ties are updated as well as their bets are lost or gained
    //     if(player.hand == 21){
    //         Prompter.playerWin(player.Name);
    //         person.money += person.moneyBetted;
    //         player.wins++;
    //         player.gamesPlayed++;
    //         Player.gameEnded = true;
           
    //     }else if(player.hand > 21 || player.splitHand > 21){
    //         Prompter.playerLoss(player.Name, player);
    //         person.money -= person.moneyBetted;
    //         player.losses++;
    //         player.gamesPlayed++;
    //         Player.gameEnded = true;
           
    //     }
    // }

    // public void playerSplitGameResult(Player player, Player computer){ //If 
    //     if(player.hand == 21 || player.splitHand == 21){
    //         Prompter.playerWin(player.Name);
    //         person.money += person.moneyBetted;
    //         player.wins++;
    //         player.gamesPlayed++;
         
    //     }else if(player.hand > 21 || player.splitHand > 21){
    //         Prompter.playerLoss(player.Name, player);
    //         person.money -= person.moneyBetted;
    //         computer.wins++;
    //         player.gamesPlayed++;
    //     }
    // }
}
