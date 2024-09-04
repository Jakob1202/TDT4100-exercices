package oving5;

import java.util.Iterator;

public class StringGridIterator implements Iterator<String> {

    private StringGridImpl grid;
    private boolean rowMajor;
    private int currentRow;
    private int currentColumn;

    /**
     * Constructor to this string grid iterator
     * 
     * @param grid2    the grid to iterate over
     * @param rowMajor indicated whetether the iteration should upwards (true) or
     *                 downwards (false)
     */
    public StringGridIterator(StringGridImpl grid, boolean rowMajor) {
        this.grid = grid;
        this.rowMajor = rowMajor;
        this.currentRow = 0;
        this.currentColumn = 0;
    }

    @Override
    public boolean hasNext() {
        return currentColumn < grid.getColumnCount() && currentRow < grid.getRowCount();
    }

    @Override
    public String next() {
        String element = grid.getElement(currentRow, currentColumn);
        if (rowMajor) {
            currentColumn++;
            if (currentColumn == grid.getColumnCount()) {
                currentRow++;
                currentColumn = 0;
            }
        } else {
            currentRow++;
            if (currentRow == grid.getRowCount()) {
                currentColumn++;
                currentRow = 0;
            }
        }
        return element;
    }

}
