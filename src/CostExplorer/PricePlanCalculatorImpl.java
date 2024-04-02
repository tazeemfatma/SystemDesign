package CostExplorer;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PricePlanCalculatorImpl implements PricePlanCalculator {
 private final int months = 12;
    @Override
    public List<Double> getMonthlyPrice(String productId, String planId) {
        List<Double> monthlyPricePlan=new ArrayList<>();
        if(!CostExplorerUtil.isValid(productId,planId))
            return Collections.EMPTY_LIST;

        Double pricePlan= CostExplorerUtil.getPricePlan(productId).get(planId);
        LocalDate currentDate=LocalDate.now();
        int totalDays=getMonthlyDays(currentDate);

        int billingDays=totalDays-currentDate.getDayOfMonth();
        int billingMonth=months-currentDate.getMonth().getValue();
       // billingDays=16;
        Double currentMonthCost=calculateCurrentMonthCost(totalDays,billingDays,pricePlan);
        monthlyPricePlan.addAll(Collections.nCopies(currentDate.getMonth().getValue()-1,0.0));
        monthlyPricePlan.add(currentMonthCost);
        monthlyPricePlan.addAll(Collections.nCopies(billingMonth,pricePlan));

        return monthlyPricePlan;
    }

    private Double calculateCurrentMonthCost(int totalDays, int billingDays, Double pricePlan) {
        return billingDays*(pricePlan/totalDays);
    }

    @Override
    public Double getAnnualPrice(String productId, String planId) {
        List<Double> monthlyPricePlan = getMonthlyPrice(productId, planId);
        if(!monthlyPricePlan.isEmpty())
            return monthlyPricePlan.stream().mapToDouble(m->m).sum();
        return 0.0;
    }

    private static int getMonthlyDays(LocalDate currentDate){
        YearMonth yearMonth=YearMonth.from(currentDate);
        return yearMonth.lengthOfMonth();
    }
}
