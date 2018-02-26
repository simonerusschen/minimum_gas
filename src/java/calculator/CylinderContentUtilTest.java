package calculator;

import org.junit.Test;

import static minimumgasBepalen.Enumerations.TypeOfSet.*;
import static org.junit.Assert.*;

public class CylinderContentUtilTest {

    @Test
    public void single12ShouldReturn12() {

            int result = CylinderContentUtil.getTotaleCylinderInhoud(SINGLE, 12);
            assertEquals("SINGLE 12 should return 12", 12, result);
        }

    @Test
    public void double12ShouldReturn24() {

        int result = CylinderContentUtil.getTotaleCylinderInhoud(DOUBLE, 12);
        assertEquals("DOUBLE 12 should return 24", 24, result);
    }

    //Volume=0 does not need to be tested. Valid input is resonsibility of class Input

    @Test
    public void checkDefaultResponse() {

        int result = CylinderContentUtil.getTotaleCylinderInhoud(ForTestOnly, 0);
        assertEquals("shit in shit out, volume is 0", 0, result);
    }
}