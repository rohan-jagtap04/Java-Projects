import java.util.ArrayList; //Import arrayList to add elements dynamically

public class Player {
    //All the Player fields for use throughout the program
    public static int player_Name; 
    public int hand, splitHand, nextMove, wins, ties, losses, gamesPlayed, money, moneyBetted;
    public boolean hasSplit;
    public static boolean gameEnded = false;
    public String Name;


    public ArrayList<String> cards = new ArrayList<String>(); //all the cards_descriptions stored in cards
    public ArrayList<Integer> values = new ArrayList<Integer>(); //All the values of cards stored in values

    public void addToHand(int card_number, String card_description) { //Accepts card_number and card_description and adds to player fields
        this.hand += card_number;
        this.values.add(card_number);
        this.cards.add(card_description);
    }

    public void addToSplitHand(int card_number, String card_description){ //Accepts the card_number and card_description and adds to player's splitHand
        this.splitHand += card_number;
    }

    public boolean isGreaterThan21(){ //Checks if player's hand is greater than 21, returns outcome as true/false
            if(this.hand > 21)
                return true;
            else if(this.hand == 21)
                return false;
        return false;
    }

    public boolean isLessThan21(){ //Checks if player's hand is less than 21, returns outcome as true/false
        if(this.hand < 21)
            return true;

        return false;
    }

    public boolean splitHandIsLessThan21(){// Checks if player's splitHand is less than 21, returns outcome as true/false
        if(this.splitHand < 21)
            return true;

        return false;
    }

    public boolean splitChecker(){// Checks if player's hand can split, returns the outcome as true/false
        boolean result = false;
        if(this.hasSplit){
            result = false;
        }else{
            if(this.values.get(this.values.size()-2) == this.values.get(this.values.size()-1)){
                result = true;
            }
        }
        return result;
    }

    public void splitDeck(){ //The method that splits the deck, makes split deck equal to the last card drawn, subtracts that value from the hand
        //Removes that value from ArrayList values, makes hasSplit true and informs player that they have split and both hand and splitHand values
        splitHand = this.values.get(this.values.size()-1);
        hand -= splitHand;
        this.values.remove(this.values.size()-1);
        this.hasSplit = true;
        Prompter.playerSplit(this);
        Prompter.playerHand(this.Name, this);
        Prompter.playerSplitHand(this.Name, this);
    }

    public Card drawCard(Player player, String playerName){//Method that draws the card and adds it to the Player's hand
        Card playerCard = new Card(player, playerName);

        this.addToHand(Integer.parseInt(playerCard.value), playerCard.cardChosen());

        return playerCard;
    }

    public Card drawCard(Player player, String playerName, int nextMove){ //Method that draws card, and under special conditions, add to players splitHand
        //If conditions are not met, card is added to player's hand
        Card playerCard = new Card(player, playerName);

        if(this.hasSplit == true && nextMove == 4){ //Add more cases
            this.addToSplitHand(Integer.parseInt(playerCard.value), playerCard.cardChosen());
        }else if(nextMove == 2){
            this.addToHand(Integer.parseInt(playerCard.value), playerCard.cardChosen());
        }

        return playerCard;
    }
}
