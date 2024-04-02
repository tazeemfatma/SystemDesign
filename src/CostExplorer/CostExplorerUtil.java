package CostExplorer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CostExplorerUtil
{
    static Map<String,Map<String,Double>> productIdWithPricePlan;
       static{
           productIdWithPricePlan=new HashMap<>();
           HashMap<String, Double> pricePlan=new HashMap<>();
           pricePlan.put("BASIC",9.99);
           pricePlan.put("STANDARD",49.99);
           pricePlan.put("PREMIUM",99.99);
           productIdWithPricePlan.put("JIRA",pricePlan);
           pricePlan=new HashMap<>();
           pricePlan.put("BASIC",10.0);
           pricePlan.put("STANDARD",50.0);
           pricePlan.put("PREMIUM",250.0);
           productIdWithPricePlan.put("PRODUCT1",pricePlan);

       }
    public static Map<String,Double> getPricePlan(String productId){
           return productIdWithPricePlan.getOrDefault(productId, Collections.EMPTY_MAP);
    }

    public static boolean isValid(String productId, String planId){
           if(productId== null || productId.isEmpty() || planId==null || planId.isEmpty()
           || !productIdWithPricePlan.containsKey(productId) || !productIdWithPricePlan.get(productId).containsKey(planId)){
               System.out.println("Enter Valid Product Id and Plan id");
               return false;
           }
           return true;
    }

}
