package unoworkout;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 *
 * @author Garret
 */

public class FXMain extends Application {
    public static Deck deck;
    private static boolean includeActionCards = false;
    private static boolean shuffleTogether = false;
    private static int numberOfDecks = 0;
    
    @Override
    public void start(Stage primaryStage) {
        
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
            
            boolean createdDeck = drawHand();
            if(createdDeck){
                shuffleTogetherBox.setDisable(true);
                includeActionBox.setDisable(true);
                numberOfDecksField.setEditable(false);
            }
        });
        
        
        GridPane root = new GridPane();
        root.setMinSize(500,500);
        root.setMaxSize(2000,2000);
        
        root.add(btn,2,6);
        root.add(includeActionBox,0,2);
        root.add(shuffleTogetherBox,0,3);
        root.add(numberOfDecksField,0,4);        
        
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("Uno workout");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public boolean drawHand(){
        boolean createdDeck = false;
        if(numberOfDecks == 0){
            return false;
        }
        if(deck == null){
            deck = new Deck(numberOfDecks, includeActionCards, shuffleTogether);
            createdDeck = true;
        }
        Card[] hand = new Card[7];
        for(int i = 0; i < 7; i++){
            hand[i] = deck.drawCard();
            System.out.println(hand[i].getCardType() + " " + hand[i].getCardColor() + " " + hand[i].getCardDescription());
        }
        return createdDeck;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*Scanner in = new Scanner(System.in);
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
        }while(!success);*/
        
        launch(args);
    }
    
}
