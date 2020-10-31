 // Import the IOException class to handle errors
package unoworkout;

import java.io.IOException;
import java.io.File;  
//import java.io.PrintWriter;
import java.io.FileWriter;

public class Output {
    // Create an array of Card object 
    static Card[][] hands = new Card[16][7] ;
    static int counter = 0;
    public static void addHand(Card[] hand){
        hands[counter] = hand;
        counter++;
    }
    
    public static void constructOutput(){
        //Create new output file
        
        try {
      File myObj = new File("Homework3.html");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
        }
   
     //Create printWriter to the output file
     
     try {
      FileWriter myWriter = new FileWriter("Homework3.html");
      myWriter.write("Files in Java might be tricky, but it is fun enough!");
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
        }
     
    }  
    //Write initial formatting (open tags (html, body, title, etc.)
    
}  

       
           
        
       
        
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
