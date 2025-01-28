package edu.neu.csye7374;

public class StockSubclass1 extends Stock {
    public StockSubclass1(String ID, double price, String description) {
        super(ID, price, description);
    }

    @Override
    public int getMetric() {

        double performanceIndex = calculatePerformanceIndex();

        if (performanceIndex > 0) {
            return (int) performanceIndex;
        } else {
            return (int) performanceIndex;
        }
    }

    private double calculatePerformanceIndex() {
        if (bidIndex < 2) {
            return 0;
        }

        double initialPrice = bids[0];
        double finalPrice = bids[bidIndex - 1];
        double priceChangePercentage = ((finalPrice - initialPrice) / initialPrice) * 100;

        return priceChangePercentage;
    }
}