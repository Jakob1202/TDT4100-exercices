package oving5;

import java.util.ArrayList;
import java.util.Iterator;

public class CardHand implements CardContainer, Iterable<Card> {
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
    @Override
    public int getCardCount() {
        return this.cardHand.size();
    }

    /**
     * Method to get card number to this card hand
     * 
     * @param n number n
     * @return the card
     */
    @Override
    public Card getCard(int n) {
        return this.cardHand.get(n);
    }

    /**
     * Method to get the cards to this card hand
     * 
     * @return the cards
     */
    @Override
    public ArrayList<Card> getCards() {
        return this.cardHand;
    }

    /**
     * Method to iterate over the cards in this card hand
     * 
     * @return an iterator over the cards in this card hand
     */
    @Override
    public Iterator<Card> iterator() {
        return this.cardHand.iterator();
    }
}
