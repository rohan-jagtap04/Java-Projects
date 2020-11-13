public class Blackjack { 
    
    static Player you = new Player(); // Makes two player objects, the actual player and the computer
    static Player computer = new Player();
    public static void main(String[] args) {

        int response = Prompter.startMessage(); //Prompts the user if they want to play Blackjack
        
        if(response == 1){ //If response is yes
                you.Name = Prompter.playerName(); //Asks user for name
                computer.Name = Prompter.computerName(); //Asks user for their preferred dealer name

                while(response == 1){ //using while ensures a continuously running program
                    you.money = Prompter.bettingMoney(); //Asks user for money on them
                    while(you.money > 0){
                        Prompter.moneyRemaining(you); //Shows the amount of money remaining
                        you.moneyBetted = Prompter.moneyToBet(you); //Asks the user for money to bet this round

                        gameStarting game = new gameStarting(you, computer); //Starts the game
                        game.gameStart();

                        gameMiddle gameMid = new gameMiddle(you, computer); //Starts the middle part of game
                        gameMid.gameMid(); 

                        gameEnd endGame = new gameEnd(you, computer); //Starts the end part of game
                        endGame.endGame();

                        Prompter.gamesPlayedResults(you, computer); //Displays the total wins, losses, gamesPlayed

                        Miscellaneous.moneyChecker(you); //Checks if user has no more money after round, if so, program is exited with ending message

                        response = Prompter.startMessage(); //Prompts user if they want to play again

                        Miscellaneous.flushOutPreviousGameData(you, computer); //flush out all values
                    }
                    Prompter.moneyDepleted(); //Exits program and displays ending message
                }
        }else if(response == 2){
            Prompter.endMessage(); //Displays ending message
        }else{
            Prompter.invalidResponse(); //Displays when unexpected values are inputted
        }

    }
}
