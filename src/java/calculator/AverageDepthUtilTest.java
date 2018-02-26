package calculator;

import org.junit.Test;

import static org.junit.Assert.*;


public class AverageDepthUtilTest {

    @Test
    public void happyFlow() {

        int result = AverageDepthUtil.getAverageDepthInMeter(45, 21);
        assertEquals("from 45 to 21 meter is avg 33", 33, result);
    }

    @Test
    public void maxDepthShouldBeDeepest() {

        int result = AverageDepthUtil.getAverageDepthInMeter(5, 21);
        //TODO expect error
        assertEquals("max depth < switch depth", 33, result);
    }
}

