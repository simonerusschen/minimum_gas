package calculator;

        import minimumgasBepalen.Logging;

final class AverageDepthUtil {

    private final static boolean DEBUGLOGGING = false;

    protected static int getAverageDepthInMeter(int maxdepthInMeter, int switchdepthInMeter) {
        //midden tussen begin en eind dus bijvoorbeeld 45m tot 21m is gemiddelde 33m
        //TODO max depth should be deeper as switch depth or is this cheekn in input?
        int averageDepthInMeter = (maxdepthInMeter + switchdepthInMeter) / 2;
        Logging.printDebug("getAverageDepthInMeter=" + averageDepthInMeter + " meter", DEBUGLOGGING);
        return averageDepthInMeter;
    }
}