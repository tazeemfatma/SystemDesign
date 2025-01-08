package CostExplorerv2;

import java.util.List;

public class Application {
    public static void main(String[] args){
        PricePlanCalculator planCalculator=new PricePlanCalculatorImpl();
        List<Double> jiraBasicMonthly = planCalculator.getMonthlyEstimate(Product.JIRA, Tier.BASIC);
        System.out.println(jiraBasicMonthly);
        double confluencePremiumAnnually=planCalculator.getAnnualEstimate(Product.CONFLUENCE, Tier.PREMIUM);
        System.out.println(confluencePremiumAnnually);
        double confluenceBasicAnnually=planCalculator.getAnnualEstimate(Product.CONFLUENCE, Tier.BASIC);
        System.out.println(confluenceBasicAnnually);


    }
}
