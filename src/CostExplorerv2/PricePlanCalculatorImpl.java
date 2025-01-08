package CostExplorerv2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PricePlanCalculatorImpl implements PricePlanCalculator {

    @Override
    public double getAnnualEstimate(Product productId, Tier tierId) {
        return getMonthlyEstimate(productId,tierId).stream().mapToDouble(m->m).sum();

    }

    @Override
    public List<Double> getMonthlyEstimate(Product productId, Tier tierId) {
        List<Double> monthlyCost=new ArrayList<>();
        LocalDate currentDate= LocalDate.now();
        int currentMonth=currentDate.getMonth().getValue();
        int remainingMonth= 12-currentMonth;
        int totalCurrentMonthDays = currentDate.lengthOfMonth();
        int remainingDaysInCurrentMonth = totalCurrentMonthDays-currentDate.getDayOfMonth();
        double pricePlan= CostUtil.getPrice(productId,tierId);
        double currentMonthCost = (pricePlan/totalCurrentMonthDays) * remainingDaysInCurrentMonth;
        monthlyCost.add(currentMonthCost);
        monthlyCost.addAll(Collections.nCopies(remainingMonth,pricePlan));


        return monthlyCost;
    }


}
