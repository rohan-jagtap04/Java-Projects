import java.util.ArrayList;

public class Card {
    public String suit, value; //Represents the suit and value for an instance of card class
    private String[] Suit = {"Clover", "Heart", "Spades", "Diamonds"}; //Choose from the four suits
    private String[] Value = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"}; //Choose from value cards
    private ArrayList<String> Tracker = new ArrayList<String>(); //Array to store past cards so cards arent repeated

    public int RANDOM_SUIT = (int) Math.floor(Math.random() * 4); //Randomly chooses a suit 
    public int RANDOM_VALUE = (int) Math.floor(Math.random() * 14);// Randomly chooses a value

    public Card(Player cardBelongTo, String playerName){
        String CARD_DESCRIPTION = Suit[RANDOM_SUIT].toString() + " - " + Value[RANDOM_VALUE].toString(); // Makes the card description from suit and value of card

        while(Checker(CARD_DESCRIPTION) == true){ //If the checker returns the string then the string runs again to choose random suit and values
            CARD_DESCRIPTION = Suit[((int) Math.floor(Math.random() * 4))].toString() + " - " + Value[((int)Math.floor(Math.random() * 13))].toString();
        }

        this.suit = Suit[RANDOM_SUIT];
            if(Value[RANDOM_VALUE].equals("Jack") || Value[RANDOM_VALUE].equals("Queen") || Value[RANDOM_VALUE].equals("King")) //All face cards are 10
                this.value = "10";
            else if(Value[RANDOM_VALUE].equals("Ace")){ //Ace can either be 1 or 11
                if(cardBelongTo.Name.equals(playerName)){//If ace is added to player hand, it prompts if they want 1 or 11
                    int response = Prompter.aceDrawn();
                    if(response == 1)
                        this.value = "1";
                    else if(response == 11)
                        this.value = "11";
                }else{
                    if(cardBelongTo.hand > 10){ //If the ace is added to computer hand, it depends on their hand value to determine value of Ace
                        this.value = "1";
                    }else if(cardBelongTo.hand > 0 || cardBelongTo.hand <= 10){
                        this.value = "11";
                    }
                }
            }
            else //IF none of those conditions (face cards/Ace), then the value is the randomly chosen
                this.value = Value[RANDOM_VALUE];

        final String CARD_DESCRIPTION2 = this.suit.toString() + " - " + this.value.toString(); //Makes the final card description
        Tracker.add(CARD_DESCRIPTION2); //Adds it to Tracker arrayList for future use
    }

    public String cardChosen(){
        return this.suit.toString() + " - " + this.value.toString(); //gets the card description
    }

    public boolean Checker(String card_description){
            if(Tracker.contains(card_description)) //Checks if card exists in Tracker arrayList, returns true/false based on result
                return true;
            else
                return false;   
    }
    
}
