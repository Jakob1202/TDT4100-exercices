package oving5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

public class CardDeck implements CardContainer, Iterable<Card> {
    private ArrayList<Character> validSuits = new ArrayList<>(Arrays.asList('S', 'H', 'D', 'C'));
    private ArrayList<Card> cardDeck;

    /**
     * Constructor for card deck
     * 
     * @param n the number of cards to add to this card deck
     */
    public CardDeck(int n) {
        this.cardDeck = new ArrayList<>();
        if (n >= 0 && n <= 13) {
            for (int j = 0; j < validSuits.size(); j++) {
                for (int i = 1; i <= n; i++) {
                    this.cardDeck.add(new Card(validSuits.get(j), i));
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Method to move n numbers of cards from top of this card deck to the card hand
     * 
     * @param cardHand the card hand
     * @param n        number n
     */
    public void deal(CardHand cardHand, int n) {
        if (n < 0 || n >= cardDeck.size()) {
            throw new IllegalArgumentException("Not valid amount of cards");
        } else {
            for (int i = 0; i < n; i++) {
                cardHand.addCard(this.cardDeck.removeLast());
            }
        }
    }

    /**
     * Method to shuffle the card deck by the "Faro shuffle" algorithm
     */
    public void shufflePerfectly() {
        int n = cardDeck.size();
        int shuffles = n / 2;

        ArrayList<Card> shuffledCardDeck = new ArrayList<>();
        for (int j = 0; j < shuffles; j++) {
            shuffledCardDeck.add(this.cardDeck.get(j));
            shuffledCardDeck.add(this.cardDeck.get(j + shuffles));
        }

        this.cardDeck = shuffledCardDeck;
    }

    @Override
    public String toString() {
        return "CardDeck [cardDeck=" + cardDeck + "]";
    }

    /**
     * Method to get the numbers of cards in this card deck
     * 
     * @return the numbers of cards
     */
    @Override
    public int getCardCount() {
        return this.cardDeck.size();
    }

    /**
     * Method to get card number n from this card deck
     * 
     * @param n number n
     * @return card number n
     */
    @Override
    public Card getCard(int n) {
        if (n >= 0 && n < this.cardDeck.size()) {
            return (Card) this.cardDeck.get(n);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Method to get the cards to this card deck
     * 
     * @return the cards
     */
    @Override
    public ArrayList<Card> getCards() {
        return this.cardDeck;
    }

    /**
     * Method to check if this card deck contains a card that satisfies the
     * predicate
     * 
     * @param predicate the predicate to check
     * @return true if a card exists, false otherwise
     */
    public boolean hasCard(Predicate<Card> predicate) {
        for (Card card : this.cardDeck) {
            if (predicate.test(card)) {
                return true;
            }
        }
        return false;

        // return cardDeck.stream().anyMatch(predicate);
    }

    /**
     * Method to get the number of cards in this card deck that satisfies the
     * predicate
     * 
     * @param predicate the predicate to check
     * @return the number of cards that satisfies the predicate
     */
    public int getCardCount(Predicate<Card> predicate) {
        int cardCount = 0;
        for (Card card : this.cardDeck) {
            if (predicate.test(card)) {
                cardCount += 1;
            }
        }
        return cardCount;

        // return cardDeck.stream().filter(predicate).toList().size();

    }

    /**
     * Method to get a list of cards in this card deck that satisfies the predicate
     * 
     * @param predicate the predicate to check
     * @return a list of cards
     */
    public ArrayList<Card> getCards(Predicate<Card> predicate) {
        ArrayList<Card> cardList = new ArrayList<>();
        for (Card card : this.cardDeck) {
            if (predicate.test(card)) {
                cardList.add(card);
            }
        }
        return cardList;

        // return cardDeck.stream().filter(predicate).toList()
    }

    /**
     * Method to iterate over the cards in this card deck
     * 
     * @return an iterator over the cards in this card deck
     */
    @Override
    public Iterator<Card> iterator() {
        return this.cardDeck.iterator();
    }

    public static void main(String[] args) {
        CardDeck deck = new CardDeck(3); 
        Iterator<Card> iterator = deck.iterator(); 

        while (iterator.hasNext()) {
            System.out.println(iterator.next()); 
        }
    }
}
