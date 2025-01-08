package CostExplorerv2;

import java.util.List;

public interface PricePlanCalculator {
    double getAnnualEstimate(Product productId, Tier tierId);
    List<Double> getMonthlyEstimate(Product productId, Tier tierId);
}
