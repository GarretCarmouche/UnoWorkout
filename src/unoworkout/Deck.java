package unoworkout;

public class Deck {
    
    private Card[] actionCards = new Card[31];
    private final Card[] numberCards = new Card[76];
    private Card[] shuffledCards;
    private int cardCount = 0;
    private boolean useActionCards;
    
    private void addCards(){
        
        int count = 0;
        for(int x = 1; x <= 2; x++){
            for(int i = 0; i <= 9; i++){
               if(x > 1 && i == 0)
                   continue;
               
               numberCards[count] = new Card(""+i,"Red");
               count++;
               numberCards[count] = new Card(""+i,"Green");
               count++;
               numberCards[count] = new Card(""+i,"Blue");
               count++;
               numberCards[count] = new Card(""+i,"Yellow");
               count++;
               
            }
        }
        
        if(!useActionCards){
            return;
        }
        
        count = 0;
        for(int j = 0; j < 2; j++){
            actionCards[count++] = new Card("Skip","Red");
            actionCards[count++] = new Card("Skip","Green");
            actionCards[count++] = new Card("Skip","Blue");
            actionCards[count++] = new Card("Skip","Yellow");
            
            actionCards[count++] = new Card("Reverse","Red");
            actionCards[count++] = new Card("Reverse","Green");
            actionCards[count++] = new Card("Reverse","Blue");
            actionCards[count++] = new Card("Reverse","Yellow");
            
            actionCards[count++] = new Card("+2","Red");
            actionCards[count++] = new Card("+2","Green");
            actionCards[count++] = new Card("+2","Blue");
            actionCards[count++] = new Card("+2","Yellow");
        }
        
        
        for(int i = 0; i <4;  i++){
            actionCards[23 + 2 * i] = new Card("Wild","");
            actionCards[24 + 2 * i] = new Card("+4","");
        }
    }
    
    private void shuffle(){
        int numberOfCards = numberCards.length + actionCards.length;
        Card[] allCards = new Card[numberOfCards];
        for(int i = 0; i < numberCards.length; i++){
            allCards[i] = numberCards[i];
        }
        
        if(useActionCards){
            for(int i = 0; i < actionCards.length; i++){
                allCards[numberCards.length + i] = actionCards[i];
            }
        }
        
        for(int i = 0; i < allCards.length; i++){
            int n1 = (int) (Math.random() * allCards.length);
            int n2 = (int) (Math.random() * allCards.length);
            Card temp = allCards[n1];
            allCards[n1] = allCards[n2];
            allCards[n2] = temp;
        }
        
        for(int i = 0; i < allCards.length; i++){
            shuffledCards[cardCount] = allCards[i];
            cardCount++;
        }
    }
    
    public Card drawCard(){
        cardCount--;
        Card c = shuffledCards[cardCount];
        
        return c;
    }
    
    public Deck(int numberOfDecks, boolean useActionCards, boolean shuffleTogether){
        this.useActionCards = useActionCards;
        shuffledCards = new Card[numberOfDecks * 114];
        if(shuffleTogether){
            for(int i = 0; i < numberOfDecks; i++){
                addCards();
            }
            shuffle();
        }
        else{
            for(int i = 0; i < numberOfDecks; i++){
                addCards();
                shuffle();
            }
        }
        
    }
    
    public Deck(int numberOfDecks, boolean useActionCards){
        this(numberOfDecks, useActionCards, false);
    }
}
