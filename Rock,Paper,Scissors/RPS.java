import java.util.Scanner; 
import java.util.Random; 
/* 

Plays Rock Paper Scissors against one player. 

*/ 
public class RPS {

    static int gamesPlayed, playerWins, computerWins;
    
    public static int tryParse(String toBeParsed){
        try {
            return Integer.parseInt(toBeParsed); //Parse the entered String
        } catch (Exception e) { 
            return 5; //If wrong input is detected, 5 is returned
        }
    }

    public static String choiceDescriptor(int choice){//Takes in integer
        switch (choice) {  //Depending on integer the choice is returned
            case 1: 
                return "ROCK."; 
            case 2:
                return "PAPER.";  
            case 3:  
                return "SCISSORS.";  
            default:
                return "Invalid Choice Entered. Please try again!";
        } 
    }

    public static void winSelector(int playerThrow, int computerThrow){
        if((computerThrow - playerThrow == 1) || (playerThrow - computerThrow == 2 )){ //Conditions for computer win
            System.out.println("Computer Wins!"); //Displays computer wins
            computerWins++; //Adds +1 to computer wins
        } else if((computerThrow - playerThrow == -1) || (computerThrow - playerThrow == 2)){ //Conditions for player win
            System.out.println("Player Wins!"); //Displays player wins
            playerWins++; //Adds +1 to player wins
        } else if(computerThrow - playerThrow == 0){ //Condition for tie
            System.out.println("It was a tie!"); //Displays tie
        } else{
            System.out.println("Invalid Outcome. Please try again!"); //Displays error message when invalid case occurs
        }
    }
    public static void main(String[] args) { 

        final int ROCK = 1, PAPER = 2, SCISSORS = 3; 

        String playerThrow;
        int computerThrow, playerThrowValue; 
        Scanner input = new Scanner(System.in); 
        Random rand = new Random(); 

        /* prompt player for throw and read number typed */ 
        do{
            System.out.println("Enter your throw (1=Rock, 2=Paper, 3=Scissors, 4=Quit): ");  
            playerThrow = input.next(); //Reads user input

            if(tryParse(playerThrow) >= 1 && tryParse(playerThrow) < 4){ //If input is not satisfying conditions, program will not run
                gamesPlayed++; //Adds one more game played
                playerThrowValue = tryParse(playerThrow); // Value of player's throw
                computerThrow = rand.nextInt(3) + 1;   /* random integer between 1 and 3 */ 

                System.out.println("Player throws: " + choiceDescriptor(playerThrowValue)); /* Inform player choice */
                
                if(choiceDescriptor(playerThrowValue).equals("Invalid Choice Entered. Please try again!")){ // If wrong choice is entered - does not execute compute
                    System.out.println("TERMINATING PROGRAM.");
                } else {
                    System.out.println("Computer throws: " + choiceDescriptor(computerThrow)); /* Informs computer choice */
                    winSelector(playerThrowValue, computerThrow); // Determines who wins
                }

                System.out.println("Games Played: " + gamesPlayed);
                System.out.println("Player Wins: " + playerWins);
                System.out.println("Computer Wins: " + computerWins);
            }else if(tryParse(playerThrow) == 4){//4 is killer switch for the program 
                System.out.println("Quit Program."); //Displays text for wrong input
            }else{
                System.out.println("Wrong Input Entered. Please try again."); //If returned value of tryParse method is not 4 or not between 1 or 3 inclusive
            }
        }while(tryParse(playerThrow) != 4 && tryParse(playerThrow) != 5); //Repeat while the killer switch is not selected (4) and while not 5 (wrong value is entered)
    }




} 

