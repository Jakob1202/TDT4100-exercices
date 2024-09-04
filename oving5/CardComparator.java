package oving5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class CardComparator implements Comparator<Card> {
    private boolean sortByAce;
    private static ArrayList<Character> defaultRankingSuits = new ArrayList<>(Arrays.asList('C', 'D', 'H', 'S'));
    private ArrayList<Character> rankingSuits = new ArrayList<>();

    /**
     * Constructor for this card comparator
     * 
     * @param ace          true if ace is to be consirered gratest card, false
     *                     otherwise
     * @param suit         the card suit which if trumph
     * @param rankingSuits the ranking of the suits to sort by
     */
    public CardComparator(boolean sortByAce, char triumph, ArrayList<Character> rankingSuits) {
        this.rankingSuits = rankingSuits;
        if (this.rankingSuits.contains(triumph)) {
            this.rankingSuits.addLast(rankingSuits.remove(rankingSuits.indexOf(triumph)));
        }
        this.sortByAce = sortByAce;
    }

    /**
     * Default constructor for this card comparator
     * 
     * @param ace  true if ace is to be consirered gratest card, false otherwise
     * @param suit the card suit which if trumph
     */
    public CardComparator(boolean sortByAce, char triumph) {
        this(sortByAce, triumph, defaultRankingSuits);
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
        if (this.rankingSuits.indexOf(card1.getSuit()) > this.rankingSuits.indexOf(card2.getSuit())) {
            return 1;
            // card1 has a smaller suit than card2 -> card1 comes before card2
        } else if (this.rankingSuits.indexOf(card1.getSuit()) < this.rankingSuits.indexOf(card2.getSuit())) {
            return -1;
            // card1 and card2 have the same suit
        } else {
            // From highest to lowest face -> [13, ... , 1]
            if (this.sortByAce) {
                return card2.getFace() - card1.getFace();
                // From lowest to highest face -> [1, ... , 13]
            } else {
                return card1.getFace() - card2.getFace();
            }
        }
    }
}
