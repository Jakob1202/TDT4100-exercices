package oving6.delegation;

import java.util.function.BinaryOperator;

public interface Employee {
    /**
     * Method to perform an binary operation
     * 
     * @param operation the operation to be performed
     * @param value1    the first value
     * @param value2    the second value
     * @return the result of the operation
     */
    public Double doCalculations(BinaryOperator<Double> operation, Double value1, Double value2);

    /**
     * Method to print a document
     * 
     * @param document the document
     */
    public void printDocument(String document);

    /**
     * Method to get the number of tasks this employee has performed
     * 
     * @return the number of tasks
     */
    public int getTaskCount();

    /**
     * Method to get the number of employees available
     * 
     * @return the number of employees
     */
    public int getResourceCount();

}
