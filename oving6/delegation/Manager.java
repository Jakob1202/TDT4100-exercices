package oving6.delegation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BinaryOperator;

public class Manager implements Employee {
    private List<Employee> employees;
    private int taskCount;

    /**
     * Constructor for manager
     * 
     * @param employees the employees to the manager
     */
    public Manager(Collection<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            throw new IllegalArgumentException("A manager must have clerks");
        } else {
            this.employees = new ArrayList<Employee>(employees);
            this.taskCount = 0;
        }
    }

    @Override
    public Double doCalculations(BinaryOperator<Double> operation, Double value1, Double value2) {
        this.taskCount++;
        return this.employees.get(0).doCalculations(operation, value1, value2);
    }

    @Override
    public void printDocument(String document) {
        this.employees.get(0).printDocument(document);
        this.taskCount++;
    }

    @Override
    public int getTaskCount() {
        return this.taskCount;
    }

    @Override
    public int getResourceCount() {
        /*
         * int resourceCount = 0;
         * for (Employee employee : employees) {
         * // Add the resourches to the intermiadate resourmanagers
         * if (employee instanceof Manager) {
         * resourceCount += employee.getResourceCount();
         * } else {
         * resourceCount++;
         * }
         * }
         * // Add the manager as an resource
         * return resourceCount + 1;
         */

        return employees.stream().mapToInt(e -> e.getResourceCount()).sum() + 1;
        // return employees.stream().mapToInt(employees::getResourceCount()).sum + 1;
    }

    public static void main(String[] args) {
        Printer printer = new Printer();
        Clerk clerk = new Clerk(printer);
        Manager manager = new Manager(Arrays.asList(clerk));
        Manager topManager = new Manager(Arrays.asList(manager));

        System.out.println(topManager.getResourceCount());
    }
}
