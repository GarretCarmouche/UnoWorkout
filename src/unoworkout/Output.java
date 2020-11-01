 // Import the IOException class to handle errors
package unoworkout;

import java.io.IOException;
import java.io.File;  
//import java.io.PrintWriter;
import java.io.FileWriter;

public class Output {
    // Create an array of Card object 
    static Card[][] hands = new Card[16*3][7] ;
    static int counter = 0;
    public static void addHand(Card[] hand){
        hands[counter] = hand;
        counter++;
    }
    
    public static void constructOutput(int totalPushups, int totalSitups, int totalSquats, int totalLunges, int totalBurpees, int skippedPushups, int skippedSitups, int skippedSquats, int skippedLunges) throws IOException{
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
     //Write initial formatting (open tags (html, body, title, etc.)
     try {
      FileWriter myWriter = new FileWriter("Homework3.html");
      myWriter.write("<html><title>Project 2 </title><body>");
      myWriter.close();
      System.out.println("Successfully wrote to the file.\n");
    } catch (IOException e) {
      System.out.println("An error occurred.");
        }
     //Iterate through each hand, add tags for the data (p1, h1, etc.) add a hand output to the file.
     
     for (int i = 0; i < hands.length; i++){
         Card[] hand = hands[i];
         try {
      FileWriter myWriter = new FileWriter("Homework3.html");
      myWriter.write("<h3>");
      myWriter.close();
      System.out.println("Successfully added hands to the file.\n");
    } catch (IOException e) {
      System.out.println("An error occurred.");
        }
    } 
     
    //Add close tags for the data (/p1, /h1, etc.)
    try {
      FileWriter myWriter = new FileWriter("Homework3.html");
      myWriter.write("</h3>");
      myWriter.close();
      System.out.println("Successfully added closing tags to the html file.\n");
    } catch (IOException e) {
      System.out.println("An error occurred.");
        }
    
    //Calculate final statistics
    FileWriter myWriter = new FileWriter("Homework3.html");
    myWriter.write("Total pushups: "+totalPushups);
    myWriter.write("Total situps: "+totalSitups);
    myWriter.write("Total Squats: "+totalSquats);
    myWriter.write("Total Lunges: "+totalLunges);
    myWriter.write("Total Burpees: "+totalBurpees);
    myWriter.write("Total skippedPushups: "+skippedPushups);
    myWriter.write("Total skippedSitups: "+skippedSitups);
    myWriter.write("Total skippedSquats: "+skippedSquats);
    myWriter.write("Total skippedLunges: "+skippedLunges);
    
       for (int i = 0; i < hands.length; i++){
         Card[] hand = hands[i];
         for(int x = 0; x < hand.length; x++){
             if(hand[x] == null)
                 break;
             System.out.println(hand[x].getCardDescription());
         }
       }
       
    //Add tags final statistics to the file
         try {
      //FileWriter myWriter = new FileWriter("Homework3.html");
      myWriter.write("<h4>");
      myWriter.close();
      System.out.println("Successfully wrote to the file.\n");
    } catch (IOException e) {
      System.out.println("An error occurred.");
        }
    
    //Close statistics tags
     
        
        //Close main file tags (/html, /body, etc.)
       try {
     // FileWriter myWriter = new FileWriter("Homework3.html");
      myWriter.write("</body></html>");
      myWriter.close();
      System.out.println("Successfully closed the tags.\n");
    } catch (IOException e) {
      System.out.println("An error occurred.");
        }
    
        }

    }

