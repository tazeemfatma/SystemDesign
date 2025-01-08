package CostExplorerv2;

public class PricePlan {
    private Tier tier;
    private double price;

    public PricePlan(Tier tier, double price) {
        this.tier = tier;
        this.price = price;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PricePlan{" +
                "tier=" + tier +
                ", price=" + price +
                '}';
    }
}
