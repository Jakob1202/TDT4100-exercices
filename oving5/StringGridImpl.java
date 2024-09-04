package oving5;

import java.util.ArrayList;
import java.util.Iterator;

public class StringGridImpl implements StringGrid {
    private ArrayList<ArrayList<String>> grid;
    private int rowCount;
    private int columnCount;

    /**
     * Constructor for this string grid
     * 
     * @param rows   the number of rows to this grid
     * @param column the number of colums of this grid
     */
    public StringGridImpl(int rows, int columns) {
        this.grid = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            ArrayList<String> row = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                row.add(null);
            }
            grid.add(row);

        }

        this.rowCount = rows;
        this.columnCount = columns;
    }

    /**
     * Method to get the number of rows to this string grid
     * 
     * @param the the numbers of rows
     */
    @Override
    public int getRowCount() {
        return this.rowCount;
    }

    /**
     * Method to get the number of columns to this string grid
     * 
     * @param the the numbers of columns
     */
    @Override
    public int getColumnCount() {
        return this.columnCount;
    }

    /**
     * Method to get the string at the given row and colum in this string grid
     * 
     * @param row    the row
     * @param column the column
     * @return the string
     */
    @Override
    public String getElement(int row, int column) {
        if(row > this.rowCount || column > this.columnCount) {
            throw new IllegalStateException("The element is not in the grid");
        } else {
            return this.grid.get(row).get(column);
        }
    }

    /**
     * Method to set the string at the given row and column in this strin grid
     * 
     * @param row    the row
     * @param column the column
     */
    @Override
    public void setElement(int row, int column, String element) {
        if(row > this.rowCount || column > this.columnCount) {
            throw new IllegalStateException("The element is not in the grid");
        } else {
            this.grid.get(row).set(column, element);
        }
    }

    @Override
    public Iterator<String> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

}
