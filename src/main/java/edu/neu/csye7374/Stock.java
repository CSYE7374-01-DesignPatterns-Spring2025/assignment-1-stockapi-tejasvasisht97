package edu.neu.csye7374;

public class Stock implements Tradable {
    private String ID;
    protected double price;
    private String description;
    protected double[] bids;
    protected int bidIndex;

    public Stock(String ID, double price, String description) {
        this.ID = ID;
        this.price = price;
        this.description = description;
        this.bids = new double[6];
        this.bidIndex = 0;
    }

    @Override
    public void setBid(double bid) {
        if (bidIndex < 6) {
            bids[bidIndex++] = bid;
            calculatePrice();
        } else {
            System.out.println("Cannot place more than 6 bids for this stock.");
        }
    }

    private void calculatePrice() {

        double sum = 0;
        for (int i = 0; i < bidIndex; i++) {
            sum += bids[i];
        }
        price = sum / bidIndex;
    }

    @Override
    public int getMetric() {

        return price > 100 ? 1 : -1;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double[] getBids() {
        return bids;
    }

    public void setBids(double[] bids) {
        this.bids = bids;
    }

    public int getBidIndex() {
        return bidIndex;
    }

    public void setBidIndex(int bidIndex) {
        this.bidIndex = bidIndex;
    }

    @Override
    public String toString() {
        return "Stock: " + ID + " (" + description + "), Price: $" + price;
    }
}
