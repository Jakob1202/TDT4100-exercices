package oving3;

import java.util.Stack;

public class RPNCalc {

    private Stack<Double> stack = new Stack<>();

    /**
     * Constructor for RNPCalc
     */
    public RPNCalc() {
        this.stack = new Stack<>();
    }

    /**
     * Method to put the number on top of this stack
     * 
     * @param number the number
     */
    public void push(Double number) {
        this.stack.addFirst(number);
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
     * Method to return number n to this stack
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
     * Method get the numbers of number in this stack
     * 
     * @return
     */
    public Integer getSize() {
        return this.stack.size();
    }

    /**
     * Method to do an operation on the top two numbers in this stack
     * 
     * @param operation the operation
     */
    public void performOperation(char operation) {
        if (this.stack.size() >= 2 && (operation == '+' || operation == '-' || operation == '*' || operation == '/')) {
            Double secondNumber = this.pop(); // Andre element blir lagt på toppen i stacken
            Double firstNumber = this.pop(); // Første element blir dyttet ned i stacken
            Double newNumber;

            if (operation == '+') {
                newNumber = firstNumber + secondNumber;
            } else if (operation == '-') {
                newNumber = firstNumber - secondNumber;
            } else if (operation == '*') {
                newNumber = firstNumber * secondNumber;
            } else {
                newNumber = firstNumber / secondNumber;
            }

            this.push(newNumber);
        } else if (operation == '~' && this.stack.size() >= 2) {
            Double firstElement = this.pop();
            Double secondElement = this.pop();

            this.push(firstElement);
            this.push(secondElement);

        } else if (operation == 'π' || operation == 'p') {
            this.push(Math.PI);
        } else if (operation == '|') {
            // TODO: Absolutt verdi?
        } else {
            throw new IllegalArgumentException("Not valid operation");
        }

    }

    @Override
    public String toString() {
        return "RPNCalc [stack=" + stack + "]";
    }

    public static void main(String[] args) {
        RPNCalc calculator = new RPNCalc();
        calculator.push(10.0);
		calculator.push(4.0);
        System.out.println(calculator.toString());
		calculator.performOperation('/');
        System.out.println(calculator.toString());

    }
}
