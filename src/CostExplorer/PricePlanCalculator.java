package CostExplorer;

import java.util.List;

public interface PricePlanCalculator {

    List<Double> getMonthlyPrice(String productId, String planId);
    Double getAnnualPrice(String productId, String planId);

}
