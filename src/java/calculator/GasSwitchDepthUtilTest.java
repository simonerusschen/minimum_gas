package calculator;

import static minimumgasBepalen.Enumerations.Decogas.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GasSwitchDepthUtilTest {

    @Test
    public void ean50ShouldReturn21Meter() {

        int result = GasSwitchDepthUtil.getGasSwitchDepthInMeter(EAN50);
        assertEquals("EAN50 should return 21 meter", 21, result);
    }

    @Test
    public void ean100ShouldReturn6Meter() {

        int result = GasSwitchDepthUtil.getGasSwitchDepthInMeter(EAN100);
        assertEquals("EAN100 should return 6 meter", 6, result);
    }

    @Test
    public void noneShouldReturn0Meter() {

        int result = GasSwitchDepthUtil.getGasSwitchDepthInMeter(NONE);
        assertEquals("NONE should return 0 meter", 0, result);
    }

    @Test
    public void checkDefaultResponseForMeter() {

        int result = GasSwitchDepthUtil.getGasSwitchDepthInMeter(ForTestOnly);
        assertEquals("default returns 0 meter", 0, result);
    }

    @Test
    public void ean50ShouldReturn70Feet() {

        int result = GasSwitchDepthUtil.getGasSwitchDepthInFeet(EAN50);
        assertEquals("EAN50 should return 70 feet", 70, result);
    }

    @Test
    public void ean100ShouldReturn6Feet() {

        int result = GasSwitchDepthUtil.getGasSwitchDepthInFeet(EAN100);
        assertEquals("EAN100 should return 20 feet", 20, result);
    }

    @Test
    public void noneShouldReturn0Feet() {

        int result = GasSwitchDepthUtil.getGasSwitchDepthInFeet(NONE);
        assertEquals("NONE should return 0 feet", 0, result);
    }

    @Test
    public void checkDefaultResponseForFeet() {

        int result = GasSwitchDepthUtil.getGasSwitchDepthInFeet(ForTestOnly);
        assertEquals("default returns 0 meter", 0, result);
    }
}
