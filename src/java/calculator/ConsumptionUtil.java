package calculator;

import minimumgasBepalen.Logging;

final class ConsumptionUtil {

	private final static boolean DEBUGLOGGING = false;
	private final static int BREATHING_VOLUME_DURING_ASCENT=20; // in l/min


	//TODO dit lijkt een beetje overdreven. Returns altijd 40
	protected static int getConsumption() {
		//C=20l/min x 2 duikers 
		int consumption = BREATHING_VOLUME_DURING_ASCENT*2;
		Logging.printDebug("getConsumption="+consumption + " l/min",DEBUGLOGGING);
		return consumption;
	}
}
