package oving3; 

import java.util.ArrayList;
import java.util.Arrays;

public class Card {
    private char suit;
    private int face;
    private ArrayList<Character> validSuits = new ArrayList<>(Arrays.asList('S', 'H', 'D', 'C'));

     /***
     * Constructor for card
     * 
     * @param suit the suit to this card
     * @param face the face to this card
     */
    public Card(char suit, int face) {
        if(validCard(suit, face)) {
            this.suit = suit;
            this.face = face;
        } else {
            throw new IllegalArgumentException("Not valid card");
        }
    }

     /**
     * Method to validate suit and face to a card
     * 
     * @param suit the suit to the card
     * @param face the face to the card
     * @return true if suit and face is valid, false otwerwise
     */
    public boolean validCard(char suit, int face) {
        if (face >= 1 && face <= 13 && validSuits.contains(suit)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method to get the suit of this card
     * 
     * @return the suit
     */
    public char getSuit() {
        return this.suit;
    }

     /**
     * Method to get the face of this card
     * 
     * @return the face
     */
    public int getFace() {
        return this.face;
    }

    @Override
    public String toString() {
        return this.suit + Integer.toString(face);
    }

    public static void main(String[] args) {
        
    }

    
}
