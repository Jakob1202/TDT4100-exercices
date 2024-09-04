package oving7;

import java.util.ArrayList;
import java.util.Arrays;

public class CardDeck extends CardContainerImpl {
    private ArrayList<Character> validSuits = new ArrayList<>(Arrays.asList('S', 'H', 'D', 'C'));

    /**
     * Constructor for card deck
     * 
     * @param n the number of cards to add to this card deck
     */
    public CardDeck(int n) {
        super(52);
        ArrayList<Card> cardDeck = new ArrayList<>();
        if (n >= 0 && n <= 13) {
            for (int j = 0; j < validSuits.size(); j++) {
                for (int i = 1; i <= n; i++) {
                    cardDeck.add(new Card(validSuits.get(j), i));
                }
            }
            super.setCards(cardDeck);
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
        if (n < 0 || n >= super.getCards().size()) {
            throw new IllegalArgumentException("Not valid amount of cards");
        } else {
            for (int i = 0; i < n; i++) {
                cardHand.addCard((Card) super.getCards().removeLast());
            }
        }
    }

    /**
     * Method to shuffle the card deck by the "Faro shuffle" algorithm
     */
    public void shufflePerfectly() {
        int n = super.getCards().size();
        int shuffles = n / 2;

        ArrayList<Card> shuffledCardDeck = new ArrayList<>();
        for (int j = 0; j < shuffles; j++) {
            shuffledCardDeck.add(super.getCards().get(j));
            shuffledCardDeck.add(super.getCards().get(j + shuffles));
        }

        super.setCards(shuffledCardDeck);
    }

    @Override
    public String toString() {
        return "CardDeck [cardDeck=" + super.getCards() + "]";
    }

}
