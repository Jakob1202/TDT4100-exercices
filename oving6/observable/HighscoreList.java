package oving6.observable;

import java.util.ArrayList;
import java.util.List;

public class HighscoreList {
    private int maxSize;
    private List<Integer> results;
    private List<HighscoreListListener> listeners;

    /**
     * Constructor for high score list
     * 
     * @param maxSize the max size 
     */
    public HighscoreList(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("The size of the list cannot be zero or negative");
        } else {
            this.maxSize = maxSize;
            this.results = new ArrayList<>();
            this.listeners = new ArrayList<>();
        }
    }

    /**
     * Method to get the size of this high score list
     * 
     * @return the size
     */
    public int size() {
        return this.results.size();
    }

    /**
     * Method to get a result from this high score list
     * 
     * @param position the position to the result
     * @return the result
     */
    public int getElement(int position) {
        if (position < 0 || position >= this.results.size()) {
            throw new IllegalArgumentException("The result is not in the list");
        } else {
            return results.get(position);
        }
    }

    /**
     * Method to add a result to this high score list
     * 
     * @param result the result
     */
    public void addResult(int result) {
        // The position to put the new result
        int position = 0;

        // Check if the highscore list is empty
        if (this.size() == 0) {
            this.results.add(result);
            position = 0;
        }
        // Check if the highscore list is not empty
        else {
            // Finds the position in the highscore list to put the new result
            while (position < results.size() && result >= results.get(position)) {
                position++;
            }

            // Puts the new result in the highscore list
            this.results.add(position, result);

            // Check if the size of the highscore list is greater than the maximum size
            if (this.results.size() > this.maxSize) {
                this.results = this.results.subList(0, this.maxSize);
            }

            // Check if the highscore list contains the new result
            if (!this.results.contains(result)) {
                position = -1;
            }
        }

        // Notify the listeners to this highscore list
        fireChangeInHighscoreList(position);

    }

    /**
     * Method to add a listener to this high score list
     * 
     * @param listener the listener
     */
    public void addHighscoreListListener(HighscoreListListener listener) {
        if (this.listeners.contains(listener)) {
            throw new IllegalArgumentException("The listener is already an observer");
        } else {
            this.listeners.add(listener);
        }
    }

    /**
     * Method to remove a listener to this high score list
     * 
     * @param listener the listener
     */
    public void removeHighscoreListListener(HighscoreListListener listener) {
        if (!this.listeners.contains(listener)) {
            throw new IllegalArgumentException("The listener is not an observer");
        } else {
            this.listeners.remove(listener);
        }
    }

    /**
     * Method to notify the listeners to this highscore list
     * 
     * @param position the position which was changed in the highscore list
     */
    public void fireChangeInHighscoreList(int position) {
        this.listeners.stream()
                .forEach(listener -> listener.listChanged(this.results, position));
    }

}