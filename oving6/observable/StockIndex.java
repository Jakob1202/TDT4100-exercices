package oving6.observable;

import java.util.ArrayList;
import java.util.Arrays;

public class StockIndex implements StockListener {
    private String ticker;
    private double index;
    private ArrayList<Stock> stocks;

    /**
     * Constructor to the stock index
     * 
     * @param name  the name to this stock index
     * @param stock the stocks to this stock index
     */
    public StockIndex(String ticker, Stock... stock) {
        this.ticker = ticker;
        this.index = 0;
        this.stocks = new ArrayList<>();

        Arrays.stream(stock).forEach(s -> {
            this.stocks.add(s);
            this.index += s.getPrice();
            s.addStockListener(this);
        });

    }

    /**
     * Method to add a stock to this stock index
     * 
     * @param stock the stock to be added
     */
    public void addStock(Stock stock) {
        if (this.stocks.contains(stock)) {
            // throw new IllegalArgumentException("The stock is already in the index");
        } else {
            this.stocks.add(stock);
        }
    }

    /**
     * Method to remove a stock to this stock index
     * 
     * @param stock the stock to be removed
     */
    public void removeStock(Stock stock) {
        if (!this.stocks.contains(stock)) {
            // throw new IllegalArgumentException("The stock is not in the index");
        } else {
            this.stocks.remove(stock);
        }
    }

    /**
     * Method to get the index to this stock
     * 
     * @return the index
     */
    public double getIndex() {
        return stocks.stream().mapToDouble(Stock::getPrice).sum();
    }

    @Override
    public void stockPriceChanged(Stock stock, double oldValue, double newValue) {
        // TODO
    }

}
