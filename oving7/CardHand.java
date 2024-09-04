package oving7;

public class CardHand extends CardContainerImpl {

    /**
     * Constructor for card hand
     * @param i 
     */
    public CardHand(int i) {
        super(i);
    }

    /**
     * Method to play by removing card number n from this card hand
     * 
     * @param n number n
     * @return card number n
     */
    public Card play(int n) {
        if (n < 0 || n >= super.getCards().size()) {
            throw new IllegalArgumentException("Not valid index");
        } else {
            Card card = super.getCards().get(n);
            super.getCards().remove(n);
            return card;

        }
    }
}
