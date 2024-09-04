package oving4;

import java.util.ArrayList;

public class CardHand {
    private ArrayList<Card> cardHand;

    /**
     * Constructor for card hand
     */
    public CardHand() {
        this.cardHand = new ArrayList<>();
    }

    /**
     * Method to add a card to this hand
     * 
     * @param card a card
     */
    public void addCard(Card card) {
        this.cardHand.add(card);
    }

    /**
     * Method to play by removing card number n from this card hand
     * 
     * @param n number n
     * @return card number n
     */
    public Card play(int n) {
        if (n < 0 || n >= this.cardHand.size()) {
            throw new IllegalArgumentException("Not valid index");
        } else {
            Card card = this.cardHand.get(n);
            this.cardHand.remove(n);
            return card;

        }
    }

    /**
     * Method to get the numbers of cards to this card hand
     * 
     * @return the numbers of cards
     */
    public int getCardCount() {
        return this.cardHand.size();
    }

    /**
     * Method to get card number to this card hand
     * 
     * @param n number n
     * @return the card
     */
    public Card getCard(int n) {
        return (Card) this.cardHand.get(n);
    }

}
