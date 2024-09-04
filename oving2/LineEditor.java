package oving2;

public class LineEditor {
    private String text;
    private int insertionIndex;

    /**
     * Constructor for line editor
     * 
     * @param text           the text
     * @param insertionIndex the insertion index
     */
    public LineEditor(String text, int insertionIndex) {
        if (insertionIndex >= 0 && insertionIndex <= text.length()) {
            this.text = text;
            this.insertionIndex = insertionIndex;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Default constructor for line editor
     */
    public LineEditor() {
        this.text = "";
        this.insertionIndex = 0;
    }

    /**
     * Method to move the insertion index in this text to the left
     */
    public void left() {
        if (this.insertionIndex > 0) {
            this.insertionIndex -= 1;
        }
    }

    /**
     * Method to move the insertion index in this text to the right
     */
    public void right() {
        if (this.insertionIndex < this.text.length()) {
            this.insertionIndex += 1;
        }
    }

    /**
     * Method to insert a new substring in this insertion index
     * 
     * @param newSubString a new substring
     */
    public void insertString(String newSubString) {
        StringBuilder stringBuilder = new StringBuilder(this.text);
        stringBuilder.insert(this.insertionIndex, newSubString);
        this.text = stringBuilder.toString();
        this.insertionIndex += newSubString.length();
    }

    /**
     * Method to remove the char to the left of this insertion index
     */
    public void deleteLeft() {
        if (this.insertionIndex > 0 && this.text.length() > 0) {
            StringBuilder stringBuilder = new StringBuilder(this.text);
            stringBuilder.deleteCharAt(this.insertionIndex - 1);
            this.insertionIndex -= 1;
            this.text = stringBuilder.toString();
        }
    }

    /**
     * Method to remove the char to the right of this insertion index
     */
    public void deleteRight() {
        if (this.insertionIndex < this.text.length() && this.text.length() > 0) {
            StringBuilder stringBuilder = new StringBuilder(this.text);
            stringBuilder.deleteCharAt(this.insertionIndex);
            this.text = stringBuilder.toString();
        }
    }

    /**
     * Method to get this text
     * 
     * @return the text
     */
    public String getText() {
        return this.text;
    }

    /**
     * Method to set this text to a new text
     * 
     * @param newText a new text
     */
    public void setText(String newText) {
        this.text = newText;
        setInsertionIndex(this.text.length());
    }

    /**
     * Method to get this insertion index
     * 
     * @return the insertion index
     */
    public int getInsertionIndex() {
        return this.insertionIndex;
    }

    /**
     * Method to set this insertion index to a new insertion index
     * 
     * @param newInsertionIndex a new insertion index
     */
    public void setInsertionIndex(int newInsertionIndex) {
        if (newInsertionIndex >= 0 && newInsertionIndex <= this.text.length()) {
            this.insertionIndex = newInsertionIndex;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.text);
        stringBuilder.insert(this.insertionIndex, "|");
        String showCursor = stringBuilder.toString();
        return showCursor;
    }

    public static void main(String[] args) {
        LineEditor lineEditor = new LineEditor();

    }
}
