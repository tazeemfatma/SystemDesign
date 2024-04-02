package CostExplorer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PricePlanCalculatorImplTest {
    PricePlanCalculatorImpl calculator;
    @Before
    public void setup(){
        calculator=new PricePlanCalculatorImpl();
    }
    @Test
    public void getAnnualPriceInvalidTest(){
        Double annualPrice = calculator.getAnnualPrice(null, "BASIC");
        assertEquals(0.0,(double)annualPrice,0.0);
         annualPrice = calculator.getAnnualPrice(null, null);
        assertEquals(0.0,(double)annualPrice,0.0);
         annualPrice = calculator.getAnnualPrice("Product 2", "BASIC");
        assertEquals(0.0,(double)annualPrice,0.0);
        annualPrice = calculator.getAnnualPrice("Product 1", "BRONZE");
        assertEquals(0.0,(double)annualPrice,0.0);
     }
    @Test
    public void getAnnualPriceValidTest() {
        Double annualPrice = calculator.getAnnualPrice("JIRA", "BASIC");
        assertNotNull(annualPrice);
    }
}
