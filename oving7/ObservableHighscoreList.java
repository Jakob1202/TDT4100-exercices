package oving7;



public class ObservableHighscoreList extends ObservableList {
    private int maxSize;

    /**
     * Constructor for high score list
     * 
     * @param maxSize
     */
    public ObservableHighscoreList(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("The size of the list cannot be zero or negative");
        } else {
            this.maxSize = maxSize;
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
        if (super.getList().size() == 0) {
            addElement(result);
        }
        // Check if the highscore list is not empty
        else {
            // Finds the position in the highscore list to put the new result
            while (position < super.getList().size() && (Integer) result >= ((Integer) super.getList().get(position)).intValue()) {
                position++;
            }

            // Puts the new result in the highscore list
            this.addElement(position, result);
            

            // Check if the size of the highscore list is greater than the maximum size
            if (super.getList().size() > this.maxSize) {
                super.setList(super.getList().subList(0, this.maxSize));
                //this.list = this.list.subList(0, this.maxSize);
            }

            // Check if the highscore list contains the new result
            if (!super.getList().contains(result)) {
                position = -1;
            }
        }

        // Notify the listeners to this highscore list
        this.notifyListeners(position);

    }

    @Override
    public boolean acceptsElement(Object element) {
        return element instanceof Integer;
    }
}