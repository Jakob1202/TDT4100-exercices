package oving5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class CardComparator2 implements Comparator<Card> {
    private boolean sortByAce;
    private ArrayList<Character> sortedSuits = new ArrayList<>(Arrays.asList('C', 'D', 'H', 'S'));

    /**
     * Constructor for this card comparator
     * 
     * @param ace  true if ace is to be consirered gratest card, false otherwise
     * @param suit the card suit which if trumph 
     */
    public CardComparator2(boolean sortByAce, char triumph) {
        if (sortedSuits.contains(triumph)) {
            sortedSuits.addLast(sortedSuits.remove(sortedSuits.indexOf(triumph)));
        }
        this.sortByAce = sortByAce;
    }

    /**
     * Method to compare the cards in this card comparator
     * 
     * @param card1 the first card
     * @param card2 the second card
     */
    @Override
    public int compare(Card card1, Card card2) {
        // card1 has a greater suit than card2 -> card1 comes after card2
        if (sortedSuits.indexOf(card1.getSuit()) > sortedSuits.indexOf(card2.getSuit())) {
            return 1;
        // card1 has a smaller suit than card2 -> card1comes before card2
        } else if (sortedSuits.indexOf(card1.getSuit()) < sortedSuits.indexOf(card2.getSuit())) {
            return -1;
        // card1 and card have the same suit
        } else {
            // From highest to lowest face -> [13, ... , 1]
            if (sortByAce) {
                return card2.getFace() - card1.getFace();
            // From lowest to highest face -> [1, ... , 13]
            } else {
                return card1.getFace() - card2.getFace();
            }
        }
    }
}

