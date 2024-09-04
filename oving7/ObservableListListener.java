package oving7;

import java.util.List;

public interface ObservableListListener {
    /**
     * Method to alert the listeners to a high score list
     * @param results the high score list
     * @param position the result which is changed
     */
    public void listChanged(List ObservableList, int position);
}
