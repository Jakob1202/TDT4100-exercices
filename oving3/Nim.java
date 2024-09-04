package oving3;

import java.util.ArrayList;

public class Nim {
    private ArrayList<Integer> piles;

    /**
     * Constructor for nim
     * 
     * @param pileSize the number of pieces in each pile
     */
    public Nim(int pileSize) {
        this.piles = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            this.piles.add(pileSize);
        }
    }

    /**
     * Default constructor for nim
     * Puts 10 pieces in each pile
     */
    public Nim() {
        this(10);
    }

    /**
     * Method to remove n numbers of pieces from the target pile
     * 
     * @param n          n numbers
     * @param targetPile the target pile
     */
    public void removePieces(int n, int targetPile) {
        if (isGameOver()) {
            throw new IllegalStateException("Game is over");
        } else if (!isValidMove(n, targetPile)) {
            throw new IllegalArgumentException(("Not valid move"));
        } else {
            this.piles.set(targetPile, piles.get(targetPile) - n);
        }
    }

    /**
     * Method to validate if a move is valid by checking if you can remove n numbers
     * of pieces from the target pile
     * 
     * @param n          n numbers
     * @param targetPile the target pile
     * @return
     */
    public boolean isValidMove(Integer n, Integer targetPile) {

        // Solves the test
        if (isGameOver()) {
            return false;
        }

        if ((n >= 1) && (targetPile < this.piles.size()) && (targetPile >= 0)) {
            if (this.piles.get(targetPile) - n >= 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Method to check if the game is over; if one of the piles is empty
     * 
     * @return
     */
    public boolean isGameOver() {
        for (int i = 0; i < this.piles.size(); i++) {
            if (this.piles.get(i) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to get the pile with position target pile
     * 
     * @param targetPile the target pile
     * @return the pile
     */
    public int getPile(int targetPile) {
        return this.piles.get(targetPile);
    }

    @Override
    public String toString() {
        return "Nim [heaps=" + piles + "]";
    }
}
