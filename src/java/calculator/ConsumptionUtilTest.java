package calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConsumptionUtilTest {

    @Test
    public void happyFlow() {

        int result = ConsumptionUtil.getConsumption();
        assertEquals("consumption always returns 40", 40, result);
    }
}
