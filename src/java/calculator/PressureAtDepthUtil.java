package calculator;

import java.math.BigDecimal;

import minimumgasBepalen.Logging;

final class PressureAtDepthUtil {

    private final static boolean DEBUGLOGGING = true;

    protected static double getPressureInBarAtDepth(int depthInMeter) {
//todo not clear that input must be meter
        //(depthInMeter/10)+1;//voor bijvoorbeeld 33m dus 4,3 bar

        double pressureInBarAtDepth = new BigDecimal(depthInMeter)
                .divide(new BigDecimal("10.0"))
                .add(new BigDecimal("1.0"))
                .setScale(1)
                .doubleValue();

        Logging.printDebug("getPressureInBarAtDepth=" + pressureInBarAtDepth + " bar at depth=" + depthInMeter + " meter", DEBUGLOGGING);
        return pressureInBarAtDepth;
    }
}
