package CostExplorerv2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CostUtil {
    static Map<Product,List<PricePlan>> productPlanList = new HashMap<>();
    static{
        PricePlan basicPlan= new PricePlan(Tier.BASIC,9.99);
        PricePlan standardPlan= new PricePlan(Tier.STANDARD,19.99);
        PricePlan premiumPlan= new PricePlan(Tier.PREMIUM,29.99);

        List<PricePlan> jiraPlanList = Arrays.asList(basicPlan,standardPlan,premiumPlan);
        List<PricePlan> confluencePlanList = Arrays.asList(standardPlan,premiumPlan);
        productPlanList.put(Product.JIRA,jiraPlanList);
        productPlanList.put(Product.CONFLUENCE,confluencePlanList);
    }
   /* public static boolean validateProductAndPlan(String product, String tier){
        if(product==null || product.isEmpty() || product.isBlank() ||
            tier==null || tier.isEmpty() || tier.isBlank() || Product.valueOf(product)==)
    }*/
    public static double getPrice(Product product,Tier tier){

        if(product == null || tier == null)
            return 0;
        PricePlan pricePlan = productPlanList.get(product).stream()
                .filter(plan -> plan.getTier() == tier)
                .findFirst().orElse(null);

        if(pricePlan==null)
            return 0;
        return pricePlan.getPrice();
    }
}
