package unoworkout;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.*;

/**
 *
 * @author Garret
 */

public class FXMain extends Application {
    public static Deck deck;
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Draw hand");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                drawHand();
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Uno workout");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void drawHand(){
        Card[] hand = new Card[7];
        for(int i = 0; i < 7; i++){
            hand[i] = deck.drawCard();
            System.out.println(hand[i].getCardType() + " " + hand[i].getCardColor() + " " + hand[i].getCardDescription());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
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
        
        deck = new Deck(numberOfDecks, includeActionCards, shuffleTogether);
        
        launch(args);
    }
    
}
