package calculator;

import minimumgasBepalen.Conversions;
import minimumgasBepalen.Enumerations;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConvertInputToMetricUtilTest {

    @Test
    public void depthWithInputMeter() {

        int result = ConvertInputToMetricUtil.convertInputDepthToMetric(33, Enumerations.UnitOfDepth.METER);
        assertEquals("depth in Meter to Metric", 33, result);
    }

    @Test
    public void depthWithInputFeet() {

        int result = ConvertInputToMetricUtil.convertInputDepthToMetric(33, Enumerations.UnitOfDepth.FEET);
        assertEquals("depth in Feet to Metric", 11, result);
    }

    @Test
    public void depthWithInputFeet2() {

        int result = ConvertInputToMetricUtil.convertInputDepthToMetric(100, Enumerations.UnitOfDepth.FEET);
        assertEquals("depth in Feet to Metric", 11, result);
    }

    @Test
    public void depthWithInputFeet3() {

        int result = ConvertInputToMetricUtil.convertInputDepthToMetric(101, Enumerations.UnitOfDepth.FEET);
        assertEquals("depth in Feet to Metric", 11, result);
    }

    @Test
    public void depthWithInputFeet4() {

        int result = ConvertInputToMetricUtil.convertInputDepthToMetric(102, Enumerations.UnitOfDepth.FEET);
        assertEquals("depth in Feet to Metric", 11, result);
    }

    @Test
    public void depthWithDefaultReturn() {

        int result = ConvertInputToMetricUtil.convertInputDepthToMetric(10, Enumerations.UnitOfDepth.ForTestOnly);
        assertEquals("depth in Feet to Metric", 0, result);
    }



    @Test
    public void testVolumeInputLiter() {

        int result = ConvertInputToMetricUtil.convertInputVolumeToMetric(24,Enumerations.UnitOfVolume.LITER);
        assertEquals("volume in Liter to Metric", 24, result);
    }

    @Test
    public void testVolumeInputCFT() {

        int result = ConvertInputToMetricUtil.convertInputVolumeToMetric(80,Enumerations.UnitOfVolume.CFT);
        assertEquals("volume in cft to Metric", 11, result);
        //TODO check waarom er 2265 uitkomt. Welk volume betreft het?
    }

    @Test
    public void volumeWithDefaultReturn() {

        int result = ConvertInputToMetricUtil.convertInputVolumeToMetric(10, Enumerations.UnitOfVolume.ForTestOnly);
        assertEquals("volume in cft to Metric", 0, result);
    }
}
