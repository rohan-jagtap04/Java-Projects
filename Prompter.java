import java.util.Scanner;
public class Prompter {
    static Scanner scan = new Scanner(System.in); //Intializes scanner object to be used

    public static int startMessage(){ //Displays starts message as well as handles errors by mischevious users and returns the response
        int x = 1, response = 0;
        System.out.println("Welcome to Blackjack, would you like to play?: Yes(1), Quit(2)");
        do{
            try{
                response = scan.nextInt();
                if(response != 1 && response != 2){
                    System.out.println("Invalid input received, please enter Yes(1) or Quit(2): ");
                    x = 1;
                }else if(response == 1){
                    x = 2;
                }else if(response == 2){
                    endMessage();
                    System.exit(0);
                }
            }catch(Exception e){
                System.out.println("Invalid input received, please enter Yes(1) or Quit(2): ");
                scan.next();
            }
        }while(x == 1);
        
        return response;
    }

    public static String playerName(){ //Prompts user for their name and returns response
        scan.nextLine();
        System.out.println("What is your name: ");
        return scan.nextLine();
    }

    public static String computerName(){ //Prompts user for computer name and returns response
        System.out.println("What should the name of the computer be: ");
        return scan.nextLine();
    }

    public static int bettingMoney(){ //Prompts user for money that they can bet for their game, handles errors by mischevious users, and returns response
        int x = 1, response = 0;
        System.out.println("How much money do you have?");
        do {
            try{
                response = scan.nextInt();
                if(response < 0 && response > 1000000){
                    System.out.println("You either have way too much money, or not enough. Enter a value between (1) and (1,000,000) inclusive.");
                    x = 1;
                }else if(response == 0){
                    moneyDepleted();
                }else if(response > 0 && response < 1000000){
                    x = 2;
                }
            }catch(Exception e){
                System.out.println("Invalid input received. Enter a value between (1) and (1,000,000) inclusive.");
                scan.next();
            }     
        } while (x == 1);

        return response;
    }

    public static int moneyToBet(Player player){ //Prompts user for money that they can bet for their round, handles errors by mischevious users, and returns response
        int x = 1, response = 0;
        System.out.println("How much money would you like to bet?");
        do {
            try{
                response = scan.nextInt();
                if(response < 0 || response > player.money){
                    System.out.println("You either bet way too much money, or not enough. Enter a value between (1) and your available money.");
                    x = 1;
                }else if(response > 0 && response <= player.money){
                    x = 2;
                }
            }catch(Exception e){
                System.out.println("Invalid input received. Enter a value between (1) and your money available.");
                scan.next();
            }
        } while (x == 1);
        return response;
    }

    public static void moneyDepleted(){ //Shows message explaining that their money has run out, then exits the program
        System.out.println("You ran out of money, please come back when you have more.");
        System.exit(0);
    }

    public static void moneyRemaining(Player player){ //Shows the money remaining in player's account after each round
        System.out.println("The money remaining is: " + player.money);
    }

    public static void moneyRemains(){ //Displays message that money remains the same when game outcome is tied
        System.out.println("Since game is tied, money remains the same.");
    }

    public static void endMessage(){ //Displays end message 
        System.out.println("Thank you so much for playing, see you soon!");
    }

    public static void invalidResponse(){ //Called when invalid response is received, tells user to try entering again
        System.out.println("Invalid reponse received, please close program and try again.");
    }

    public static int nextMove(){ //Prompts user for their next move, handles errors from mischevious users, and returns inputted response
        int x = 1, response = 0;

        System.out.println("Will you Stand(1) or Hit(2)?");
        do{
            try{
                response = scan.nextInt();

                if(response != 1 && response != 2){
                    System.out.println("Invalid input received, please enter Stand(1) or Hit(2): ");
                    x = 1;  
                }else if(response == 1 || response == 2){
                    x = 2;
                }
            }catch(Exception e){
                System.out.println("Invalid input received, will you Stand(1) or Hit(2): ");
                scan.next();
            }
        }while(x == 1);

        return response;
    }

    public static void drawnCard(String who_drew, String card_description){ // Accepts a two parameters showing the player_name and the card drawn description
        System.out.println(who_drew + " drew: " + card_description);
    }

    public static int aceDrawn(){ //When ace is drawn, asks user what value they want it to be (1 or 11), handles erros from mischevious users, and returns choice
        int x = 1, response = 0;

        System.out.println("You drew an Ace, would you like it to equal (1) or (11)");
        do{
            try{
                response = scan.nextInt();
                if(response != 1 && response != 11){
                    System.out.println("Invalid input received, please enter to equal (1) or (11): ");
                    x = 1;
                }else if(response == 1 || response == 11){
                    x = 2;
                }
            }catch(Exception e){
                System.out.println("Invalid input received, please enter to equal (1) or (11): ");
                scan.next();
            }
        }while(x == 1);
        
        return response;
    }

    public static void StarterCard(String who_drew, String card_description, String card2_description){ //During the start of the game, shows the starting cards of both player and dealer
        System.out.println(who_drew + " drew: " + card_description + " and " + card2_description);
    } 

    public static void playerLoss(String player, Player player_object){ //Accepts the playerName and player object to show formatted lose message
        System.out.println(player + " lost, hand valued at: " + player_object.hand);
    }

    public static void playerWin(String player){//Accepts the player object to show formatted win message
        System.out.println(player + " won!");
    }

    public static void playerTied(){ //Displays messages that game is tied
        System.out.println("Game is tied.");
    }

    public static void playerHand(String player_Name, Player player_object){ //Accepts the playerName and player object to show formatted player's hand 
        System.out.println(player_Name +" hand is: " + player_object.hand);
    }

    public static void playerSplitHand(String player_Name, Player player_object){ //Accepts the playerName and player object to show formatted player's split hand 
        System.out.println(player_Name +" split hand is: " + player_object.splitHand);
    }

    public static void playerSplit(Player player){ //Accepts the player object to display that player has split their hand
        System.out.println(player.Name + " has split their deck!");
    }

    public static int splitDeck(){ //Prompts user to split their deck, handles errors from mischevious users, returns response
        int x = 1, response = 0;

        System.out.println("You have drawn two same-value cards, do you want to split? Yes(1) or No(2)?");
        do{
            try{
                response = scan.nextInt();
                if(response != 1 && response != 2){
                    System.out.println("You have drawn two same-value cards, do you want to split? Yes(1) or No(2)?");
                    x = 1;
                }else if(response == 1 || response == 2){
                    x = 2;
                }
            }catch(Exception e){
                System.out.println("Invalid response received, do you want to split? Yes(1) or No(2)?");
                scan.next();
            }
        }while(x == 1);
        
        return response;        
    }

    public static int splitDeckNextMove(){ //Prompts user for their next move, handles errors from mischevious users, returns response
        int x = 1, response = 0;
        System.out.println("Will you stand(1) or hit(2) your current deck or stand(3) or hit(4) your split deck?");
        do{
            try{
                response = scan.nextInt();
                if(response != 1 && response != 2 && response != 3 && response != 4){
                    System.out.println("Will you stand(1) or hit(2) your current deck or stand(3) or hit(4) your split deck?");
                    x = 1;
                }else if(response == 1 || response == 2 || response == 3 || response == 4){
                    x = 2;
                }
            }catch(Exception e){
                System.out.println("Invalid input received, Will you stand(1) or hit(2) your current deck or stand(3) or hit(4) your split deck: ");
                scan.next();
            }
        }while(x == 1);
        
        return response;
        
    }

    public static void gamesPlayedResults(Player player, Player computer){ //Shows the player money, player and computer wins, losses, and games_Played
        System.out.println("\n\n Player Money: " + player.money + ", Games Played: " + player.gamesPlayed + ", Player wins: " + player.wins + ", Player losses: " + player.losses + ", Computer wins: " + computer.wins + ", Computer losses: " + computer.losses + ".\n\n");
    }
}
