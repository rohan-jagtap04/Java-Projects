public class gameMiddle {
    private Player person, computer; //Variables representing the two players

    public gameMiddle(Player player, Player player2){ //Constructor to initialize the two players
        this.person = player;
        this.computer = player2;
    }

    public void gameMid(){ //The "main" method that contains all the method for this class
        playerTurn(person);
        dealerTurn(computer);
    }


    public void playerTurn(Player player){ //Method that manages the player turns and different events that could occur, accepts a player in the parameter
        if(player.hand >= 21 || computer.hand >= 21){ //Automatically skips turn if either hand is over 21 (meaning either one or both players lost)
            player.nextMove = 5;
        }else{
            do {
                if(player.hasSplit == true){//Checks if player has split deck, provided two different prompts based on outcome
                    player.nextMove = Prompter.splitDeckNextMove();
                }else{
                    player.nextMove = Prompter.nextMove();
                }

                if(player.nextMove == 2){
                    Card playerCard3 = player.drawCard(player, player.Name); //Draws a new card
                    
                    splitter(player); //Gives player the option to split their deck or not if allowed 

                    if(player.isGreaterThan21() || player.hand == 21){ //Automatically skips turn if player loss or won
                        Prompter.playerHand(player.Name, player); //Displays the player's hand w/ value
                        player.nextMove = 5;
                    }else{
                        Prompter.drawnCard(player.Name, playerCard3.cardChosen()); //Informs player that card has been drawn
                        Prompter.playerHand(player.Name, player); //Displays the player's hand w/ value

                        if(player.hasSplit == true)
                            Prompter.playerSplitHand(player.Name, player);
                        
                    }


                }else if(player.nextMove == 4){ //If player has already split their hand, this choice is available
                    Card playerCard3 = player.drawCard(player, player.Name, player.nextMove); //Draws a new card

                    
                    if(player.hand >= 21 || player.splitHand >= 21){//Skips turn if hand or splitHand is greater or equal to 21
                        player.nextMove = 5;
                    }else{
                        Prompter.drawnCard(player.Name, playerCard3.cardChosen()); //Informs player that card has been drawn
                        Prompter.playerHand(player.Name, player); //Displays the player's hand w/ value
                        Prompter.playerSplitHand(player.Name, player); //Displays the player's split hand w/ value
                    }
                }
            } while (player.nextMove == 2 || player.nextMove == 4); //Continues while nextMove are hits on either hand or splitHand
        }
    }
    
    private void splitter(Player player){ //Checks if player has the option to split deck
        if(player.splitChecker()){
            int splitDeck = Prompter.splitDeck(); //Checks if player is allowed to split their deck and asks user
            if(splitDeck == 1){
                player.splitDeck(); //If user chooses to split deck, the program splits their deck
            }
        }
    }

    public void dealerTurn(Player dealer){
        while(dealer.hand < 17){ //Dealer keeps picking up cards until their hand is >= 17
            Card computerCard3 = computer.drawCard(computer, person.Name);
            Prompter.drawnCard(computer.Name, computerCard3.cardChosen());
            Prompter.playerHand(computer.Name, computer); //Displays hand value
        }
    }


}
