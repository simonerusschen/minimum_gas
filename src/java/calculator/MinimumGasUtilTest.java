package calculator;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class MinimumGasUtilTest {

    @Test
    public void testMinumumGasinBar() {
        BigDecimal result = MinimumGasUtil.getMinimumGasInBar(1720, 24);
        assertEquals("minumum gas in bar", 90, result);
    }
    //TODO check answers and add more tests

    @Test
    public void testMinumumGasinPSI() {
        BigDecimal result = MinimumGasUtil.getMinimumGasInPSI(new BigDecimal(51));
        assertEquals("minumum gas in psi", 90, result);
    }
    //TODO check answers and add more tests
}

