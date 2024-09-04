package oving5;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BinaryOperator;

public class RPNCalc {

    private Stack<Double> stack;
    private Map<Character, BinaryOperator<Double>> operations;

    /**
     * Constructor for RNPCalc
     */
    public RPNCalc() {
        this.stack = new Stack<>();
        this.operations = new HashMap<>();
    }

    /**
     * Method to put the number on top of this stack
     * 
     * @param i the number
     */
    public void push(double i) {
        this.stack.push((double) i);
    }

    /**
     * Method to remove the number on top of this stack
     * 
     * @return the number
     */
    public Double pop() {
        if (this.stack.size() == 0) {
            return Double.NaN;
        } else {
            return this.stack.removeFirst();
        }
    }

    /**
     * Method to return element n to this stack
     * 
     * @param number the number
     * @return number n
     */
    public Double peek(Integer n) {
        if (this.stack.size() == 0) {
            return Double.NaN;
        } else if (n >= 0 && n < this.stack.size()) {
            return this.stack.get(n);
        } else {
            throw new IllegalArgumentException("Not valid index");
        }
    }

    /**
     * Method get the size to this stack
     * 
     * @return
     */
    public Integer getSize() {
        return this.stack.size();
    }

    /**
     * Method to add a binary operation
     * 
     * @param name      the name to the binary operation
     * @param operation the operation to the binary operation
     * @return
     */
    public boolean addOperator(char name, BinaryOperator<Double> operation) {
        if (!operations.containsKey(name)) {
            this.operations.put(name, operation);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method to perform a binary operation
     * 
     * @param name the name to the binary operation
     */
    public void performOperation(char name) {
        if (!operations.containsKey(name)) {
            throw new UnsupportedOperationException("Not implementet operation");
        }

        Double firstNumber = this.pop(); // Andre element blir lagt på toppen i stacken
        Double secondNumber = this.pop(); // Første element blir dyttet ned i stacken
        Double newNumber = operations.get(name).apply(firstNumber, secondNumber);
        this.push(newNumber);

    }

    /**
     * Method to remove a binary operation
     * 
     * @param name the name to the binary operation
     */
    public void removeOperator(char name) {
        this.operations.remove(name);
    }

    @Override
    public String toString() {
        return "RPNCalc [stack=" + stack + "]";
    }
}
