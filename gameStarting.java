public class gameStarting {

    private Player person, computer; //variables to represent the current players

    public gameStarting(Player personPlayer, Player computerPlayer){ //Constructor for initializing the two players
        this.person = personPlayer;
        this.computer = computerPlayer;
    }
   
    public void gameStart(){

            Card playerCard = this.person.drawCard(person, person.Name); //Draws two cards for Player
            Card playerCard2 = this.person.drawCard(person, person.Name);

            Prompter.StarterCard(this.person.Name, playerCard.cardChosen(), playerCard2.cardChosen()); //Displays Player's cards
            Prompter.playerHand(this.person.Name, this.person); //Displays hand value


           Card computerCard = this.computer.drawCard(computer, person.Name); //Draws two cards for Computer
           Card computerCard2 = this.computer.drawCard(computer, person.Name);

            Prompter.StarterCard(this.computer.Name, computerCard.cardChosen(), computerCard2.cardChosen()); //Displays computer's cards
            Prompter.playerHand(this.computer.Name, this.computer); //Displays hand value


            if(person.splitChecker()){ //Checks if player should split deck
                int splitDeck = Prompter.splitDeck(); 

                if(splitDeck == 1)
                    this.person.splitDeck(); //If player can split deck, calls method that splits player's deck
                else if(splitDeck == 2) //If player chooses not to split their deck, it informs player of their choice
                    System.out.println("You have chosen not to split your deck.");        
            }

    }
}
