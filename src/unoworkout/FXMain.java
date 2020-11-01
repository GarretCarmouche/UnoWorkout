package unoworkout;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Garret
 */

public class FXMain extends Application {
    private static Deck deck;
    private static boolean includeActionCards = false;
    private static boolean shuffleTogether = false;
    private static int numberOfDecks = 0;
    private static final Text[] cardLabels = new Text[7];
    private static boolean finalHandDrawn = false;
    
    private static int totalSquats = 0, totalSitups = 0, totalPushups = 0, totalLunges = 0, totalBurpees = 0;
    private static int totalSkippedSquats = 0, totalSkippedSitups = 0, totalSkippedPushups = 0, totalSkippedLunges = 0;
    
    /**
     * Updates the UI for the hand drawn
     * @param cardsLeft Number of cards left in the deck
     * @param hand Array of cards in the hand
     * @param burpeesLabel Text label for the number of burpees in the hand
     * @param situpsLabel Text label for the number of situps in the hand
     * @param squatsLabel Text label for the number of squats in the hand
     * @param pushupsLabel Text label for the number of pushups in the hand
     * @param loungesLabel Text label for the number of lounges in the hand
     */
    public static void updateHand(Text cardsLeft, Card[] hand, Text burpeesLabel, Text situpsLabel, Text squatsLabel, Text pushupsLabel, Text loungesLabel){
        cardsLeft.setText("Cards left: "+deck.length());
                
        int pushups = 0;
        int situps = 0;
        int squats = 0;
        int burpees = 0;
        int lounges = 0;
        int pushupsMultiplier = 1;
        int situpsMultiplier = 1;
        int squatsMultiplier = 1;
        int loungesMultiplier = 1;
        boolean skipPushups = false;
        boolean skipSitups = false;
        boolean skipSquats = false;
        boolean skipLunges = false;
        for(int i = 0; i < hand.length; i++){
            if(hand[i] == null)
                continue;
            String t = hand[i].getCardColor() + " " + hand[i].getCardType() + ": " + hand[i].getCardDescription();
            cardLabels[i].setText(t);

            switch(hand[i].getCardColor()){
                case "Yellow":
                    switch(hand[i].getCardType()){
                        case "+2":
                            squatsMultiplier += 1;
                            break;
                        case "Reverse":
                        case "Skip":
                            skipSquats = true;
                            break;
                        default:
                            squats += Integer.parseInt(hand[i].getCardType());
                    }
                    break;
                case "Red":
                    switch(hand[i].getCardType()){
                        case "+2":
                            situpsMultiplier += 1;
                            break;
                        case "Reverse":
                        case "Skip":
                            skipSitups = true;
                            break;
                        default:
                            situps += Integer.parseInt(hand[i].getCardType());
                    }
                    break;
                case "Green":
                    switch(hand[i].getCardType()){
                        case "+2":
                            loungesMultiplier += 1;
                            break;
                        case "Reverse":
                        case "Skip":
                            skipLunges = true;
                            break;
                        default:
                            lounges += Integer.parseInt(hand[i].getCardType());
                    }
                    break;
                case "Blue":
                    switch(hand[i].getCardType()){
                        case "+2":
                            pushupsMultiplier += 1;
                            break;
                        case "Reverse":
                        case "Skip":
                            skipPushups = true;
                            break;
                        default:
                            pushups += Integer.parseInt(hand[i].getCardType());
                    }
                    break;
                default:
                    switch(hand[i].getCardType()){
                        case "+4":
                            pushupsMultiplier += 3;
                            loungesMultiplier += 3;
                            squatsMultiplier += 3;
                            situpsMultiplier += 3;
                        case "Wild":
                            burpees += 4;
                            break;
                    }
            }
        }
        if(skipPushups){
                totalSkippedPushups += (pushups * pushupsMultiplier);
                pushups = 0;
            }else{
                pushups *= pushupsMultiplier;
            }
            
            if(skipLunges){
                totalSkippedLunges += (lounges * loungesMultiplier);
                lounges = 0;
            }else{
                lounges *= loungesMultiplier;
            }
            
            if(skipSquats){
                totalSkippedSquats += (squats * squatsMultiplier);
                squats = 0;
            }else{
                squats *= squatsMultiplier;
            }
            
            if(skipSitups){
                totalSkippedSitups += (situps * situpsMultiplier);
                situps = 0;
            }else{
                situps *= situpsMultiplier;
            }
            
            totalSitups += situps;
            totalSquats += squats;
            totalPushups += pushups;
            totalLunges += lounges;
            totalBurpees += burpees;
            
            situpsLabel.setText("Situps: "+situps);
            squatsLabel.setText("Squats: "+squats);
            pushupsLabel.setText("Pushups: "+pushups);
            loungesLabel.setText("Lunges: "+lounges);
            burpeesLabel.setText("Burpees: "+burpees);
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        for(int i = 0; i < 7; i++){
            cardLabels[i] = new Text();
            cardLabels[i].setText("Card "+(i+1));
            cardLabels[i].setTextAlignment(TextAlignment.LEFT);
            cardLabels[i].resize(250, 10);
        }
        
        Text burpeesLabel = new Text();
        Text squatsLabel = new Text();
        Text loungesLabel = new Text();
        Text pushupsLabel = new Text();
        Text situpsLabel = new Text();
        
        
        Text numberOfDecksLabel = new Text();
        numberOfDecksLabel.setText("Number of decks: ");
        
        Text filePathLabel = new Text();
        filePathLabel.setText("File path: ");
        filePathLabel.setTextAlignment(TextAlignment.RIGHT);
        
        TextField filePathField = new TextField("Output.html");
        
        Text cardsLeft = new Text();
        cardsLeft.setText("Cards left:");
        
        CheckBox includeActionBox = new CheckBox();
        includeActionBox.setText("Include action cards");
        includeActionBox.setAlignment(Pos.CENTER_LEFT);
        
        includeActionBox.setOnAction((ActionEvent event) -> {
            includeActionCards = includeActionBox.selectedProperty().get(); 
        });
        
        CheckBox shuffleTogetherBox = new CheckBox();
        shuffleTogetherBox.setText("Shuffle decks together");
        shuffleTogetherBox.setLayoutY(70);
        
        shuffleTogetherBox.setOnAction((ActionEvent event) -> {
            shuffleTogether = shuffleTogetherBox.selectedProperty().get();
        });
        
        TextField numberOfDecksField = new TextField("1");
        numberOfDecksField.setMinWidth(30);
        numberOfDecksField.setMaxWidth(30);
        
        Button btn = new Button();
        btn.setText("Draw hand");
        
        btn.setOnAction((ActionEvent event) -> {
            String text = numberOfDecksField.textProperty().get();
            int num = 0;
            try{
                num = Integer.parseInt(text);
            }catch(NumberFormatException ex){
            }
            if(num > 0 && num < 4)
                numberOfDecks = num;
            else
                numberOfDecks = 0;
            
            Card[] hand = drawHand(filePathField.textProperty().get());
            if(hand != null){
                shuffleTogetherBox.setDisable(true);
                includeActionBox.setDisable(true);
                numberOfDecksField.setEditable(false);
                updateHand(cardsLeft, hand, burpeesLabel, situpsLabel, squatsLabel, pushupsLabel, loungesLabel);
            }
        });
        
        
        GridPane root = new GridPane();
        root.setMinSize(500,500);
        root.setMaxSize(2000,2000);
        
        root.add(btn,2,6);
        root.add(cardsLeft,3,6);
        root.add(includeActionBox,0,2);
        root.add(shuffleTogetherBox,0,3);
        root.add(numberOfDecksField,1,4); 
        root.add(numberOfDecksLabel,0,4);
        root.add(pushupsLabel, 0,6);
        root.add(situpsLabel, 0,7);
        root.add(squatsLabel, 0,8);
        root.add(loungesLabel, 0,9);
        root.add(burpeesLabel, 0,10);
        root.add(filePathField,2,7);
        root.add(filePathLabel,1,7);
        for(int i = 0; i < cardLabels.length; i++){
            root.add(cardLabels[i],(i%1)+4,(i/1) + 7);
        }
        
        Scene scene = new Scene(root, 600, 300);
        
        primaryStage.setTitle("Uno workout");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * Returns the cards of the matching color back to the deck
     * @param color Color of cards to be returned to the deck
     * @param hand Hand of cards to be checked to be returned to the deck
     */
    public static void reverseCards(String color, Card[] hand){
        for(int i = 0; i < hand.length; i++){
            if(hand[i] == null)
                break;
            if(hand[i].getCardColor().equals(color) && !hand[i].getCardType().equals("Reverse"))
                deck.addCard(hand[i]);
        }
    }
    
    /**
     * Draws a hand of seven cards from the deck
     * @return Card array of the hand.
     */
    public static Card[] drawHand(String outputFilePath){
        if(numberOfDecks == 0){
            return null;
        }
        if(deck == null){
            deck = new Deck(numberOfDecks, includeActionCards, shuffleTogether);
        }
        Card[] hand = new Card[7];
        for(int i = 0; i < 7; i++){
            if(deck.length() == 0){
                break;
            }
            hand[i] = deck.drawCard();
        }
        
        for(int i = 0; i < 7; i++){
            if(hand[i] == null)
                break;
            if(hand[i].getCardType().equals("Reverse"))
                reverseCards(hand[i].getCardColor(), hand);
        }
        
        if(deck.length() <= 0 && !finalHandDrawn){
            finalHandDrawn = true;
            try{
                Output.constructOutput(totalPushups, totalSitups, totalSquats, totalLunges, totalBurpees, totalSkippedPushups, totalSkippedSitups, totalSkippedSquats, totalSkippedLunges, outputFilePath);
            }catch(IOException ex){}
        }
        return hand;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
