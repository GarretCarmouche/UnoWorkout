
package unoworkout;

import java.util.*;

public class Main {

    
    public static void main(String args[]) {
        int numberOfDecks = 1;
        boolean includeActionCards;
        boolean shuffleTogether;
        String t;
        boolean success = true;
        
        Scanner in = new Scanner(System.in);
        
        do{
            System.out.print("Input the number of decks to shuffle: ");
            t = in.next().trim();
            try{
                numberOfDecks = Integer.parseInt(t);
            }catch(Exception ex){
                success = false;
            }
                    
        }while(!success);
        
        do{
            System.out.print("Input whether they should be shuffled together (y/n) ");
            t = in.next().trim().toLowerCase();
            success = (t.equals("y") || t.equals("n"));
            shuffleTogether = t.equals("y");
        }while(!success);
        
        do{
            success = true;
            System.out.print("Input whether action cards should be included (y/n) ");
            t = in.next().trim().toLowerCase();
            success = (t.equals("y") || t.equals("n"));
            includeActionCards = t.equals("y");
        }while(!success);
        
        Deck deck = new Deck(numberOfDecks, includeActionCards, shuffleTogether);
        while(deck.length() > 0){
            Card c = deck.drawCard();
            System.out.println(c.cardType + " " + c.cardColor);
        }
    }
    
}
