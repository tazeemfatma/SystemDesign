package CostExplorer;

import java.util.List;

public class Application {
    public static void main(String[] args){
        PricePlanCalculator pricePlanCalculator=new PricePlanCalculatorImpl();
        String productId="PRODUCT1";
        String planId="BASIC";
        List<Double> monthlyPrice = pricePlanCalculator.getMonthlyPrice(productId, planId);
        System.out.println("Monthly Price "+monthlyPrice);
        Double annualCost = pricePlanCalculator.getAnnualPrice(productId, planId);
        System.out.println("Annual Price "+annualCost);

    }
}
