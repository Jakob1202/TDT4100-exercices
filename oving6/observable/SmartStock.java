package oving6.observable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartStock extends Stock {

    private Map<StockListener, List<Double>> listenersPriceRange;
    private Map<StockListener, List<Double>> listenersPriceDifference;

    /**
     * Constructot ot this smart stock
     * 
     * @param ticker the stock code
     * @param price  the price to the stock
     */
    public SmartStock(String ticker, double price) {
        super(ticker, price);
        this.listenersPriceRange = new HashMap<>();
        this.listenersPriceDifference = new HashMap<>();
    }

    @Override
    public void setPrice(double newPrice) {
        double oldPrice = this.getPrice();
        super.setPrice(newPrice);

        this.fireStockPriceRangeChange(newPrice, oldPrice);
        this.fireStockPriceDifferenceChange(newPrice);

    }

    /**
     * Method to notify the price range listeners to this smart stock
     * 
     * @param newPrice the new price to a stock
     * @param oldPrice the old price to a stock
     */
    public void fireStockPriceRangeChange(double newPrice, double oldPrice) {
        this.listenersPriceRange.entrySet().stream()
                .filter(entry -> newPrice < entry.getValue().get(0) || newPrice > entry.getValue().get(1))
                .forEach(listener -> listener.getKey().stockPriceChanged(this, oldPrice, newPrice));

    }

    /**
     * Method to notify the price difference listeners to this smart stock
     * 
     * @param newPrice the new price to a stock
     */
    public void fireStockPriceDifferenceChange(double newPrice) {
        this.listenersPriceDifference.entrySet().stream()
                .filter(entry -> Math.abs(newPrice - entry.getValue().get(0)) > entry.getValue().get(1))
                .forEach(listener -> listener.getKey().stockPriceChanged(this, listener.getValue().get(0), newPrice));
    }

    /**
     * Method to add a listener to this smart stock who observe a price interval
     * The listener will be notified when the price to this stock is set outside a
     * given interval
     * 
     * @param listener the listener
     * @param min      the minimum value to the interval
     * @param max      the maximum value to the interval
     */
    public void addStockListener(StockListener listener, double min, double max) {
        if (this.listenersPriceRange.containsKey(listener)) {
            throw new IllegalArgumentException("The listener is already an observer");
        } else if (min < 0 || min == 0) {
            throw new IllegalArgumentException("The minimum value cannot be negative or zero");
        } else if (max < 0 || max == 0) {
            throw new IllegalArgumentException("The maximum value cannot be negative or zero");
        } else if (min > max) {
            throw new IllegalArgumentException("The miminum value cannot be greater than the maximum value");
        } else {
            this.listenersPriceRange.put(listener, List.of(min, max));
        }
    }

    /**
     * Method to add a listener to this smart stock who observe a price difference
     * THe listener will be notified when a change to this stock price is greater
     * than a given differance
     * 
     * @param listener
     * @param difference
     */
    public void addStockListener(StockListener listener, double difference) {
        if (this.listenersPriceDifference.containsKey(listener)) {
            throw new IllegalArgumentException("The listener is already an observer");
        } else if (difference <= 0) {
            throw new IllegalArgumentException("The differaence cannot be negative or zero");
        } else {
            this.listenersPriceDifference.put(listener, List.of(this.getPrice(), difference));
        }
    }
}
