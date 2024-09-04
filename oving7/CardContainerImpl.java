package oving7;

import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings("rawtypes")
public class CardContainerImpl implements CardContainer, Iterable {
    private ArrayList<Card> cards;
    private int maxCardCount;

    /**
     * Constructor for cardContainerImpl
     * 
     * @param maxCardCount the maximum numbers of cards to this cards
     */
    public CardContainerImpl(int maxCardCount) {
        this.cards = new ArrayList<>();
        this.maxCardCount = maxCardCount;
    }

    /**
     * Method to get the numbers of cards to this cards
     * 
     * @return the numbers of cards
     */
    @Override
    public int getCardCount() {
        return this.cards.size();
    }

    /**
     * Method to get card number to this cards
     * 
     * @param n number n
     * @return the card
     */
    @Override
    public Card getCard(int n) {
        return this.cards.get(n);
    }

    /**
     * Method to add a card to this cards
     * 
     * @param card a card
     */
    public void addCard(Card card) {
        if (this.getCardCount() == this.maxCardCount) {
            throw new IllegalStateException("Reached the maximum amount of cards");
        } else {
            this.cards.add(card);
        }
    }

    /**
     * Method to get the numbers maximum card count to this cards
     * 
     * @return the maximum numbers of cards
     */
    public int getMaxCardCount() {
        return this.maxCardCount;
    }

    /**
     * Method to get the cards to this card container
     * 
     * @return the cards
     */
    public ArrayList<Card> getCards() {
        return this.cards;
    }

    /**
     * Method to get the cards to this card container
     * 
     * @return the cards
     */
    public void setCards(ArrayList<Card> newCards) {
        this.cards = newCards;
    }

    @Override
    public Iterator iterator() {
        return this.cards.iterator();
    }

}
