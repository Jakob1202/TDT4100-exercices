package oving6.observable;

import java.util.List;

public interface HighscoreListListener {
    /**
     * Method to alert the listeners to a high score list
     * @param results the high score list
     * @param position the result which is changed
     */
    public void listChanged(List<Integer> results, int position);
}
