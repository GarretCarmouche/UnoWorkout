package unoworkout;

/**
 * 
 * @author Garret
 */
public class Deck {
    
    private Card[] actionCards = new Card[31];
    private final Card[] numberCards = new Card[76];
    private Card[] shuffledCards;
    private int cardCount = 0;
    private boolean useActionCards;
    
    /**
     * Initializes actionCards and numberCards to contain the respective cards from an uno deck
     */
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
    
    /**
     * Shuffles the array of cards given
     * @param allCards array of cards to shuffle
     * @return allCards in random order
     */
    private Card[] shuffle(Card[] allCards){
        Card[] cards = new Card[allCards.length];
        for(int i = 0; i < allCards.length; i++){
            cards[i] = allCards[i];
        }
        
        for(int i = 0; i < cards.length; i++){
            int n1 = (int) (Math.random() * cards.length);
            int n2 = (int) (Math.random() * cards.length);
            Card temp = cards[n1];
            cards[n1] = cards[n2];
            cards[n2] = temp;
        }
        
        return cards;
    }
    
    /**
     * Overload for {@link #shuffle(Card[])} above. Generates an array before invoking.
     * @return Shuffled array of cards
     */
    private Card[] shuffle(){
        int numberOfCards;
        if(useActionCards)
            numberOfCards = numberCards.length + actionCards.length;
        else
            numberOfCards = numberCards.length;
        Card[] cards = new Card[numberOfCards];
        for(int i = 0; i < numberCards.length; i++){
            cards[i] = numberCards[i];
        }
        
        if(useActionCards){
            for(int i = 0; i < actionCards.length; i++){
                cards[numberCards.length + i] = actionCards[i];
            }
        }
        return shuffle(cards);
    }
    
    /**
     * 
     * @return the next card in the deck to be drawn
     */
    public Card drawCard(){
        cardCount--;
        Card c = shuffledCards[cardCount];
        
        return c;
    }
    
    /**
     * 
     * @return current number of cards in the deck
     */
    public int length(){
        return cardCount;
    }
    
    /**
     * Constructor for a new deck. Adds and shuffles cards accordingly.
     * @param numberOfDecks the number of uno decks (1-3) to be included
     * @param useActionCards whether or not action cards will be put into the deck
     * @param shuffleTogether whether the uno decks will be shuffled together, or individually
     */
    public Deck(int numberOfDecks, boolean useActionCards, boolean shuffleTogether){
        int numberOfCards;
        if(useActionCards)
            numberOfCards = numberCards.length + actionCards.length;
        else
            numberOfCards = numberCards.length;
        
        this.useActionCards = useActionCards;
        shuffledCards = new Card[numberOfDecks * numberOfCards];
        if(shuffleTogether){
            addCards();
            for(int i = 0; i < numberOfDecks; i++){
                int count = 0;
                Card[] cards = new Card[numberOfCards];
                for(int x = 0; x < numberCards.length; x++){
                    cards[count] = numberCards[x];
                    count++;
                }
                
                if(useActionCards){
                    for(int x = 0; x < actionCards.length; x++){
                        cards[count] = actionCards[x];
                        count++;
                    }
                }
                
                for(int x = 0; x < cards.length; x++){
                    shuffledCards[cardCount] = cards[x];
                    cardCount++;
                }
            }
        }
        else{
            addCards();
            for(int i = 0; i < numberOfDecks; i++){
                
                Card[] cards = shuffle();
                for(int x = 0; x < cards.length; x++){
                    shuffledCards[cardCount] = cards[x];
                    cardCount++;
                }
            }
        }
        
    }
    /**
     * Overload for {@link #Deck(int, boolean, boolean)}
     * @param numberOfDecks number of uno decks to be added
     * @param useActionCards boolean to use action cards or not
     */
    public Deck(int numberOfDecks, boolean useActionCards){
        this(numberOfDecks, useActionCards, false);
    }
}
