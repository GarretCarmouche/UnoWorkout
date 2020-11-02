 // Import the IOException class to handle errors
package unoworkout;

import java.io.IOException;
import java.io.File;  
//import java.io.PrintWriter;
import java.io.FileWriter;

public class Output {
    // Create an array of Card object 
    static Card[][] hands = new Card[60][7] ;
    static int counter = 0;
    
    /**
     * Adds a hand to the array of hands drawn
     * @param hand Hand to be added to the array
     */
    public static void addHand(Card[] hand){
        hands[counter] = hand;
        counter++;
    }
    
    /**
     * Creates an HTML file for the output and writes the data for each hand and final statistics
     * @param totalPushups
     * @param totalSitups
     * @param totalSquats
     * @param totalLunges
     * @param totalBurpees
     * @param skippedPushups
     * @param skippedSitups
     * @param skippedSquats
     * @param skippedLunges
     * @param filePath Path of the file to be written
     * @throws IOException 
     */
    public static void constructOutput(int totalPushups, int totalSitups, int totalSquats, int totalLunges, int totalBurpees, int skippedPushups, int skippedSitups, int skippedSquats, int skippedLunges, String filePath) throws IOException{
        //Create new output file
        System.out.println("OUT");
        try {
      File myObj = new File(filePath);
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
    }
        FileWriter myWriter;
     //Create printWriter to the output file
     //Write initial formatting (open tags (html, body, title, etc.)
     try {
      myWriter = new FileWriter(filePath);
      myWriter.write("<html><title>Project 2 </title><body>");
      //myWriter.close();
      System.out.println("Successfully wrote to the file.\n");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      return;
        }
     //Iterate through each hand, add tags for the data (p1, h1, etc.) add a hand output to the file.
     
     for(int i = 0; i < hands.length; i++){
         Card[] hand = hands[i];
         if(hand[0] == null)
            break;
         myWriter.write("<h3>");
         myWriter.write("Hand "+i);
         myWriter.write("</h3>");
         myWriter.write("<p>");
         for(int x = 0; x < hand.length; x++){
             myWriter.write("<br>");
             if(hand[x] == null){
                 break;
             }
             for(int c = 0; c < 6; c++){
                 switch(c){
                     case 0:
                             if(hand[x].getCardColor().equals("Yellow"))
                             {
                                 for(int t = 0; t < 13; t++){
                                     switch(t){
                                         case 0:
                                         case 1:
                                         case 2:
                                         case 3:
                                         case 4:
                                         case 5:
                                         case 6:
                                         case 7:
                                         case 8:
                                         case 9:
                                             if(hand[x].getCardType().equals(""+t)){
                                                 myWriter.write(hand[x].getCardColor() + " " +hand[x].getCardType() + ": "+hand[x].getCardDescription());
                                             }
                                             break;
                                         case 10:
                                             if(hand[x].getCardType().equals("Skip")){
                                                 myWriter.write(hand[x].getCardColor() + " " +hand[x].getCardType() + ": "+hand[x].getCardDescription());
                                             }
                                             break;
                                         case 11:
                                             if(hand[x].getCardType().equals("+2")){
                                                 myWriter.write(hand[x].getCardColor() + " " +hand[x].getCardType() + ": "+hand[x].getCardDescription());
                                             }
                                             break;
                                         case 12:
                                             if(hand[x].getCardType().equals("Reverse")){
                                                 myWriter.write(hand[x].getCardColor() + " " +hand[x].getCardType() + ": "+hand[x].getCardDescription());
                                             }
                                             break;
                                     }
                                 }
                             }
                             break;
                     case 1:
                         if(hand[x].getCardColor().equals("Green")){
                             for(int t = 0; t < 13; t++){
                                     switch(t){
                                         case 0:
                                         case 1:
                                         case 2:
                                         case 3:
                                         case 4:
                                         case 5:
                                         case 6:
                                         case 7:
                                         case 8:
                                         case 9:
                                             if(hand[x].getCardType().equals(""+t)){
                                                 myWriter.write(hand[x].getCardColor() + " " +hand[x].getCardType() + ": "+hand[x].getCardDescription());
                                             }
                                             break;
                                         case 10:
                                             if(hand[x].getCardType().equals("Skip")){
                                                 myWriter.write(hand[x].getCardColor() + " " +hand[x].getCardType() + ": "+hand[x].getCardDescription());
                                             }
                                             break;
                                         case 11:
                                             if(hand[x].getCardType().equals("+2")){
                                                 myWriter.write(hand[x].getCardColor() + " " +hand[x].getCardType() + ": "+hand[x].getCardDescription());
                                             }
                                             break;
                                         case 12:
                                             if(hand[x].getCardType().equals("Reverse")){
                                                 myWriter.write(hand[x].getCardColor() + " " +hand[x].getCardType() + ": "+hand[x].getCardDescription());
                                             }
                                             break;
                                     }
                                 }
                             }
                         break;
                     case 2:
                         if(hand[x].getCardColor().equals("Red")){
                             for(int t = 0; t < 13; t++){
                                     switch(t){
                                         case 0:
                                         case 1:
                                         case 2:
                                         case 3:
                                         case 4:
                                         case 5:
                                         case 6:
                                         case 7:
                                         case 8:
                                         case 9:
                                             if(hand[x].getCardType().equals(""+t)){
                                                 myWriter.write(hand[x].getCardColor() + " " +hand[x].getCardType() + ": "+hand[x].getCardDescription());
                                             }
                                             break;
                                         case 10:
                                             if(hand[x].getCardType().equals("Skip")){
                                                 myWriter.write(hand[x].getCardColor() + " " +hand[x].getCardType() + ": "+hand[x].getCardDescription());
                                             }
                                             break;
                                         case 11:
                                             if(hand[x].getCardType().equals("+2")){
                                                 myWriter.write(hand[x].getCardColor() + " " +hand[x].getCardType() + ": "+hand[x].getCardDescription());
                                             }
                                             break;
                                         case 12:
                                             if(hand[x].getCardType().equals("Reverse")){
                                                 myWriter.write(hand[x].getCardColor() + " " +hand[x].getCardType() + ": "+hand[x].getCardDescription());
                                             }
                                             break;
                                     }
                                 }
                             }
                         break;
                     case 3:
                         if(hand[x].getCardColor().equals("Blue")){
                             for(int t = 0; t < 13; t++){
                                     switch(t){
                                         case 0:
                                         case 1:
                                         case 2:
                                         case 3:
                                         case 4:
                                         case 5:
                                         case 6:
                                         case 7:
                                         case 8:
                                         case 9:
                                             if(hand[x].getCardType().equals(""+t)){
                                                 myWriter.write(hand[x].getCardColor() + " " +hand[x].getCardType() + ": "+hand[x].getCardDescription());
                                             }
                                             break;
                                         case 10:
                                             if(hand[x].getCardType().equals("Skip")){
                                                 myWriter.write(hand[x].getCardColor() + " " +hand[x].getCardType() + ": "+hand[x].getCardDescription());
                                             }
                                             break;
                                         case 11:
                                             if(hand[x].getCardType().equals("+2")){
                                                 myWriter.write(hand[x].getCardColor() + " " +hand[x].getCardType() + ": "+hand[x].getCardDescription());
                                             }
                                             break;
                                         case 12:
                                             if(hand[x].getCardType().equals("Reverse")){
                                                 myWriter.write(hand[x].getCardColor() + " " +hand[x].getCardType() + ": "+hand[x].getCardDescription());
                                             }
                                             break;
                                     }
                                 }
                             }
                         break;
                     case 4:
                         if(hand[x].getCardType().equals("+4")){
                             myWriter.write(hand[x].getCardColor() + " " +hand[x].getCardType() + ": "+hand[x].getCardDescription());
                         }
                         break;
                     case 5:
                         if(hand[x].getCardType().equals("Wild")){
                             myWriter.write(hand[x].getCardColor() + " " +hand[x].getCardType() + ": "+hand[x].getCardDescription());
                         }
                         break;
                         
                 }
             }
         }
         myWriter.write("</p>");
     }
     //myWriter.close();
     /*for (int i = 0; i < hands.length; i++){
         Card[] hand = hands[i];
         try {
      FileWriter myWriter = new FileWriter(filePath);
      myWriter.write("<h3>");
      
      
      myWriter.close();
      System.out.println("Successfully added hands to the file.\n");
    } catch (IOException e) {
      System.out.println("An error occurred.");
        }
    } */
     
    //Add close tags for the data (/p1, /h1, etc.)
    /*try {
      //FileWriter myWriter = new FileWriter(filePath);
      myWriter.write("</h3>");
      myWriter.close();
      System.out.println("Successfully added closing tags to the html file.\n");
    } catch (IOException e) {
      System.out.println("An error occurred.");
        }*/
    
    //FileWriter myWriter = new FileWriter(filePath);
    myWriter.write("Total pushups: "+totalPushups + "<br>" );
    myWriter.write("Total situps: "+totalSitups + "<br>" );
    myWriter.write("Total Squats: "+totalSquats + "<br>" );
    myWriter.write("Total Lunges: "+totalLunges + "<br>" );
    myWriter.write("Total Burpees: "+totalBurpees + "<br>");
    myWriter.write("Total skippedPushups: "+skippedPushups + "<br>" );
    myWriter.write("Total skippedSitups: "+skippedSitups + "<br>");
    myWriter.write("Total skippedSquats: "+skippedSquats+ "<br>" );
    myWriter.write("Total skippedLunges: "+skippedLunges+ "<br>" );
    
       for (int i = 0; i < hands.length; i++){
         Card[] hand = hands[i];
         for(int x = 0; x < hand.length; x++){
             if(hand[x] == null)
                 break;
             System.out.println(hand[x].getCardDescription());
         }
       }
       
    /*//Add tags final statistics to the file
    
         try {
      //FileWriter myWriter = new FileWriter("Homework3.html");
      myWriter.write("<h4>");
      myWriter.close();
      System.out.println("Successfully added statistics to the .\n");
    } catch (IOException e) {
      System.out.println("An error occurred.");
        }
    
    //Close statistics tags
    
         try {
      //FileWriter myWriter = new FileWriter("Homework3.html");
      myWriter.write("</h4>");
      myWriter.close();
      System.out.println("Successfully closed the file.\n");
    } catch (IOException e) {
      System.out.println("An error occurred.");
        }
     */
        
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

