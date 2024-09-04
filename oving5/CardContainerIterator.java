package oving5;

import java.util.Iterator;

public class CardContainerIterator implements Iterator<Card> {
    private CardContainer cardContainer;
    private int currentIndex;

    public CardContainerIterator(CardContainer container) {
        this.currentIndex = 0;
        this.cardContainer = container;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < cardContainer.getCardCount();

    }

    @Override
    public Card next() {
        return cardContainer.getCard(currentIndex++);
    }
}
