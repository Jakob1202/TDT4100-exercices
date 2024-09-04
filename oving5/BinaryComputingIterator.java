package oving5;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.BinaryOperator;

public class BinaryComputingIterator implements Iterator<Double> {

    private Iterator<Double> iterator1;
    private Iterator<Double> iterator2;
    private Double default1;
    private Double default2;
    private BinaryOperator<Double> operator;

    /**
     * Constructor for binary computing iterator
     * 
     * @param iterator1 an iterator
     * @param iterator2 an iterator
     * @param operator  a binary operation
     */
    public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2,
            BinaryOperator<Double> operator) {
        this(iterator1, iterator2, null, null, operator);
    }

    /**
     * Constuctor for binary computing iterator with default values
     * 
     * @param iterator1 an iterator
     * @param iterator2 an iterator
     * @param default1  a default value
     * @param default2  a default value
     * @param operator  a binary operator
     */
    public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, Double default1,
            Double default2,
            BinaryOperator<Double> operator) {
        this.iterator1 = iterator1;
        this.iterator2 = iterator2;
        this.default1 = default1;
        this.default2 = default2;
        this.operator = operator;

    }

    // Begge iteratorene er tomme
    // Iterator 1 er tom, men har default1 og iterator2 er ikke tom
    // Iterator 2 er tom, men har default2 og iterator1 er ikke tom

    @Override
    public boolean hasNext() {
        if (!iterator1.hasNext() && !iterator2.hasNext()) {
            return false;
        }

        if ((iterator1.hasNext() && !iterator2.hasNext()) && default2 == null) {
            return false;
        }

        if ((iterator2.hasNext() && !iterator1.hasNext()) && default1 == null) {
            return false;
        }

        return true;
    }

    @Override
    public Double next() {
        if (hasNext()) {
            Double value1 = iterator1.hasNext() ? iterator1.next() : (default1 != null ? default1 : 0.0);
            Double value2 = iterator2.hasNext() ? iterator2.next() : (default2 != null ? default2 : 0.0);
            return operator.apply(value1, value2);
        } else {
            throw new IllegalStateException("The iterators are empty");
        }
    }

    public static void main(String[] args) {
        Iterator<Double> iterator1 = Arrays.asList(0.5, -2.0).iterator();
        Iterator<Double> iterator2 = Arrays.asList(5.0, 3.0).iterator();
        Iterator<Double> iteratorShort = Arrays.asList(5.0).iterator();
        BinaryComputingIterator binaryIt = new BinaryComputingIterator(iterator1, iteratorShort, null, 2.0,
                (a, b) -> a * b);
        System.out.println(binaryIt.next());
        System.out.println(binaryIt.hasNext());
    }
}
