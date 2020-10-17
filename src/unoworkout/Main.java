
package unoworkout;


public class Main {

    
    public static void main(String args[]) {
        Deck d = new Deck(1,true);
        for(int i = 0; i < 107; i++){
            Card c = d.drawCard();
            //System.out.println(c.cardType+" "+c.cardColor);
        }
    }
    
}
