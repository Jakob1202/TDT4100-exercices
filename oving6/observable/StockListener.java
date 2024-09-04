package oving6.observable;

public interface StockListener {
    /**
     * Method to keep the listener updated on the stock price
     * @param stock the stock
     * @param oldValue the old price to this stock
     * @param newValue the new price to this stock
     */
    public void stockPriceChanged(Stock stock, double oldValue, double newValue);
}
