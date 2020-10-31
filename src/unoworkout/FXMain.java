package unoworkout;

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
    public static Deck deck;
    private static boolean includeActionCards = false;
    private static boolean shuffleTogether = false;
    private static int numberOfDecks = 0;
    private static final Text[] cardLabels = new Text[7];
    
    public void updateHand(Text cardsLeft, Card[] hand, Text burpeesLabel, Text situpsLabel, Text squatsLabel, Text pushupsLabel, Text lungesLabel){
        cardsLeft.setText("Cards left: "+deck.length());
                
        int pushups = 0;
        int situps = 0;
        int squats = 0;
        int burpees = 0;
        int lunges = 0;
        int pushupsMultiplier = 1;
        int situpsMultiplier = 1;
        int squatsMultiplier = 1;
        int lungesMultiplier = 1;
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
                            lungesMultiplier += 1;
                            break;
                        case "Reverse":
                        case "Skip":
                            skipLunges = true;
                            break;
                        default:
                            lunges += Integer.parseInt(hand[i].getCardType());
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
                            lungesMultiplier += 3;
                            squatsMultiplier += 3;
                            situpsMultiplier += 3;
                        case "Wild":
                            burpees += 4;
                            break;
                    }
            }
        }
        if(skipPushups){
                pushups = 0;
            }else{
                pushups *= pushupsMultiplier;
            }
            
            if(skipLunges){
                lunges = 0;
            }else{
                lunges *= lungesMultiplier;
            }
            
            if(skipSquats){
                squats = 0;
            }else{
                squats *= squatsMultiplier;
            }
            
            if(skipSitups){
                situps = 0;
            }else{
                situps *= situpsMultiplier;
            }
            
            situpsLabel.setText("Situps: "+situps);
            squatsLabel.setText("Squats: "+squats);
            pushupsLabel.setText("Pushups: "+pushups);
            lungesLabel.setText("Lunges: "+lunges);
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
        Text lungesLabel = new Text();
        Text pushupsLabel = new Text();
        Text situpsLabel = new Text();
        
        Text cardsLeft = new Text();
        cardsLeft.setText("Cards left:");
        
        CheckBox includeActionBox = new CheckBox();
        includeActionBox.setText("Include action cards");
        includeActionBox.setAlignment(Pos.CENTER_LEFT);
        includeActionBox.setLayoutY(50);
        
        includeActionBox.setOnAction((ActionEvent event) -> {
            includeActionCards = includeActionBox.selectedProperty().get(); 
        });
        
        CheckBox shuffleTogetherBox = new CheckBox();
        shuffleTogetherBox.setText("Shuffle decks together");
        shuffleTogetherBox.setLayoutY(70);
        
        shuffleTogetherBox.setOnAction((ActionEvent event) -> {
            shuffleTogether = shuffleTogetherBox.selectedProperty().get();
        });
        
        TextField numberOfDecksField = new TextField("Enter number of decks (1-3)");
        numberOfDecksField.setMinWidth(175);
        
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
            
            Card[] hand = drawHand();
            if(hand != null){
                shuffleTogetherBox.setDisable(true);
                includeActionBox.setDisable(true);
                numberOfDecksField.setEditable(false);
                updateHand(cardsLeft, hand, burpeesLabel, situpsLabel, squatsLabel, pushupsLabel, lungesLabel);
            }
        });
        
        
        GridPane root = new GridPane();
        root.setMinSize(500,500);
        root.setMaxSize(2000,2000);
        
        root.add(btn,2,6);
        root.add(cardsLeft,3,6);
        root.add(includeActionBox,0,2);
        root.add(shuffleTogetherBox,0,3);
        root.add(numberOfDecksField,0,4); 
        root.add(pushupsLabel, 0,6);
        root.add(situpsLabel, 0,7);
        root.add(squatsLabel, 0,8);
        root.add(lungesLabel, 0,9);
        root.add(burpeesLabel, 0,10);
        for(int i = 0; i < cardLabels.length; i++){
            root.add(cardLabels[i],(i%1)+4,(i/1) + 7);
        }
        
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("Uno workout");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    public void reverseCards(String color, Card[] hand){
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
    public Card[] drawHand(){
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
        return hand;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
