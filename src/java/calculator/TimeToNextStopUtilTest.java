package calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TimeToNextStopUtilTest {

    @Test
    public void TestTimeToNextStop() {
        int result = TimeToNextStopUtil.getTimeBottomToDecogas(51, 21);
        assertEquals("time to next stop", 12, result);
    }

    @Test
    public void TestTheIf() {
       int result = TimeToNextStopUtil.getTimeBottomToDecogas(12, 21);
       assertEquals("Test result if no ascent needed", 2, result);
    }
}
