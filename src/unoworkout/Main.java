
package unoworkout;

import java.util.*;

public class Main {

    
    public static void main(String args[]) {
        int numberOfDecks = 1;
        boolean includeActionCards;
        boolean shuffleTogether;
        String t;
        boolean success;
        
        Scanner in = new Scanner(System.in);
        do{
            System.out.print("Input the number of decks to shuffle (1-3): ");
            t = in.next().trim();
            success = true;
            try{
                numberOfDecks = Integer.parseInt(t);
            }catch(Exception ex){
                success = false;
            }
            if(numberOfDecks < 1 || numberOfDecks > 3)
                success = false;
            if(!success)
                System.out.println("Invalid input");
        }while(!success);
        
        do{
            System.out.print("Input whether they should be shuffled together (y/n) ");
            t = in.next().trim().toLowerCase();
            success = (t.equals("y") || t.equals("n"));
            shuffleTogether = t.equals("y");
            if(!success)
                System.out.println("Invalid input");
        }while(!success);
        
        do{
            System.out.print("Input whether action cards should be included (y/n) ");
            t = in.next().trim().toLowerCase();
            success = (t.equals("y") || t.equals("n"));
            includeActionCards = t.equals("y");
            if(!success)
                System.out.println("Invalid input");
        }while(!success);
        
        Deck deck = new Deck(numberOfDecks, includeActionCards, shuffleTogether);
        System.out.println(deck.length());
        Card[] hand = new Card[7];
        int count = 0;
        while(deck.length() > 0){
            Card c = deck.drawCard();
            //System.out.println(c);
            System.out.println(c.getCardType() + " " + c.getCardColor() + " " + c.getCardDescription());
            hand[count] = c;
            if(count == 6){
                Output.addHand(hand);
                hand = new Card[7];
                count = -1;
            }
            count++;
        }
    }
    
}
