package oving6.delegation;

import java.util.function.BinaryOperator;

public class Clerk implements Employee {
    private Printer printer;
    private int taskCount;
    private int resourceCount;

    /**
     * Constructor for employee
     * 
     * @param printer
     */
    public Clerk(Printer printer) {
        this.printer = printer;
        this.taskCount = 0;
        this.resourceCount = 1;
    }

    @Override
    public Double doCalculations(BinaryOperator<Double> operation, Double value1, Double value2) {
        this.taskCount++;
        return operation.apply(value1, value2);
    }

    @Override
    public void printDocument(String document) {
        this.taskCount++;
        this.printer.printDocument(document, this);
    }

    @Override
    public int getTaskCount() {
        return this.taskCount;
    }

    @Override
    public int getResourceCount() {
        return this.resourceCount;
    }
}
