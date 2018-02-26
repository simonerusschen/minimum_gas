package calculator;

import minimumgasBepalen.Conversions;
import minimumgasBepalen.Logging;
import minimumgasBepalen.Enumerations.UnitOfDepth;
import minimumgasBepalen.Enumerations.UnitOfVolume;

final class ConvertInputToMetricUtil {

	private final static boolean DEBUGLOGGING = true;
	private static Conversions conversions = new Conversions();

	protected static int convertInputDepthToMetric(int depth, UnitOfDepth unitOfDepth) {
		int depthInMeter=0;

		switch (unitOfDepth) {
		case METER:
			depthInMeter=depth;
			break;
		case FEET:
			depthInMeter = (int) (depth/conversions.getConversion("meter", "ft").getFactor());
			break;
		default:
			Logging.printError("enum is not implemented yet: " + unitOfDepth);
			//TODO is logging enough?
		}
		Logging.printDebug("convertInputDepthToMetric="+depthInMeter+" meter", DEBUGLOGGING);
		return depthInMeter;
	}

	protected static int convertInputVolumeToMetric(int volume, UnitOfVolume unitOfVolume) {
		int cylinderVolumeInLiter=0;		
		switch (unitOfVolume )  {
		case LITER:
			cylinderVolumeInLiter = volume;
			break;
		case CFT:
			cylinderVolumeInLiter=(int) (volume/conversions.getConversion("liter", "cft").getFactor());
			break;
		default:
			Logging.printError("No valid enum in convertInputVolumeToMetric: "+unitOfVolume);
		}
		Logging.printDebug("convertInputVolumeToMetric="+cylinderVolumeInLiter+" liter", DEBUGLOGGING);
		return cylinderVolumeInLiter;
	}
}