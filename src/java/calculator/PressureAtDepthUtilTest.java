package calculator;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PressureAtDepthUtilTest {

    @Test
    public void testPressureAtDepth() {
        double result = PressureAtDepthUtil.getPressureInBarAtDepth(51);
        assertEquals("pressure at depth", 6.1, result, 0.01);
        //delta is needed as it concerns double values
    }

    @Test
    public void testDepthIsZero() {
        double result = PressureAtDepthUtil.getPressureInBarAtDepth(0);
        assertEquals("pressure at depth", 1.0, result, 0.01);
        }
}
