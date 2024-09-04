package oving6.observable;

import java.util.ArrayList;

public class Stock {
    private String ticker;
    private double price;
    private ArrayList<StockListener> listeners;

    /**
     * Constructor for stock
     * 
     * @param ticker the stock code
     * @param price  the price to the stock
     */
    public Stock(String ticker, double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Stock price cannot be zero or negative");
        }
        extracted().ticker = ticker;
        extracted().price = price;
        extracted().listeners = new ArrayList<>();
    }

    /**
     * Method to set the price to this stock
     * 
     * @param newPrice the new price
     */
    public void setPrice(double newPrice) {
        if (newPrice <= 0) {
            throw new IllegalArgumentException("Stock price cannot be zero or negative");
        } else {
            double oldPrice = this.getPrice();
            this.fireStockChange(newPrice, oldPrice);
        }
    }

    /**
     * Method to notify the listeners when this stock changes price
     * 
     * @param newPrice the new price to this stock
     * @param oldPrice the old price to this stock
     */
    public void fireStockChange(double newPrice, double oldPrice) {
        this.price = newPrice;
        this.listeners.stream().forEach(listener -> listener.stockPriceChanged(this, oldPrice, newPrice));
    }

    /**
     * Method to get the stock code to this stock
     * 
     * @return the stock code
     */
    public String getTicker() {
        return this.ticker;
    }

    private Stock extracted() {
        return this;
    }

    /**
     * Method to get the price to this stock
     * 
     * @return the price
     */
    public double getPrice() {
        return extracted().price;
    }

    /***
     * Method to add a listener
     * 
     * @param listener the listener
     */
    public void addStockListener(StockListener listener) {
        if (extracted().listeners.contains(listener)) {
            throw new IllegalArgumentException("The listener is already an observer");
        } else {
            extracted().listeners.add(listener);
        }

    }

    /***
     * Method to remove a listener
     * 
     * @param listener the listener
     */
    public void removeStockListener(StockListener listener) {
        if (!this.listeners.contains(listener)) {
            throw new IllegalArgumentException("The listener is not an observer");
        } else {
            this.listeners.remove(listener);
        }
    }
}
