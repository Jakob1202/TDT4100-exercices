package oving3;

import java.util.ArrayList;
import java.util.Arrays;

public class CardDeck {
    private ArrayList<Character> validSuits = new ArrayList<>(Arrays.asList('S', 'H', 'D', 'C'));
    private ArrayList<Object> cardDeck;

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
     * Method to shuffle the card deck by the "Faro shuffle" algorithm
     */
    public void shufflePerfectly() {
        Integer n = cardDeck.size();
        Integer shuffles = n / 2;

        ArrayList<Object> shuffledCardDeck = new ArrayList<>();
        for (int j = 0; j < shuffles; j++) {
            shuffledCardDeck.add(this.cardDeck.get(j));
            shuffledCardDeck.add(this.cardDeck.get(j + shuffles));
        }

        this.cardDeck = shuffledCardDeck;
    }

    /**
     * Method to the the numbers of cards in this card deck
     * 
     * @return the numbers of cards
     */
    public int getCardCount() {
        return this.cardDeck.size();
    }

    /**
     * Method to get card number n from this card deck
     * 
     * @param n number n
     * @return card number n
     */
    public Card getCard(int n) {
        if (n >= 0 && n < this.cardDeck.size()) {
            return (Card) this.cardDeck.get(n);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "CardDeck [cardDeck=" + cardDeck + "]";
    }

    public static void main(String[] args) {
        CardDeck deck = new CardDeck(2);
        System.out.println(deck.toString());
        deck.shufflePerfectly();
        System.out.println(deck.toString());
    }
}
