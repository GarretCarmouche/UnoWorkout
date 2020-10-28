
package unoworkout;

public class Output {
    // Create an array of Card object 
    static Card[][] hands = new Card[16*3][7] ;
    static int counter = 0;
    public static void addHand(Card[] hand){
        hands[counter] = hand;
        counter++;
    }
    
    public static void constructOutput(){
        //Create new output file
            
        //Create printWriter to the output file
        
        //Write initial formatting (open tags (html, body, title, etc.)
        
        //Iterate through each hand, add tags for the data (p1, h1, etc.) add a hand output to the file.
        
        //Add close tags for the data (/p1, /h1, etc.)
        
        //Calculate final statistics
        
        //Add tags final statistics to the file
        
        //Close statistics tags
        
        //Close main file tags (/html, /body, etc.)
        
        //Close file
    }
    /*
    Card : Red 7
    type - "7"
    color - "Red"
    description - "7 push ups"
    
    public static void printCard(Card c){
        System.out.println(c.getCardType() + c.getCardColor() + "-" + c.getCardDescription());
        //"7 Red-7 push ups
    }
    */
    
}
