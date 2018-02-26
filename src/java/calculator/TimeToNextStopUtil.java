package calculator;

import minimumgasBepalen.Logging;

final class TimeToNextStopUtil {
	
	protected static int getTimeBottomToDecogas(int maxdepthInMeter,int switchdepthInMeter) {
		//van 45 naar 21 met 3m per minuut=8 minuten

		final int TIME_FOR_S_DRILL =1;   // 1 min voor s dril 
		final int TIME_FOR_GAS_SWITCH=1; // 1 min voor gaswissel
		final int AVERAGE_ASCENT_RATE=3; // gemiddeld 3 m/min opstijgen
		final boolean DEBUGLOGGING = true;
		
		int ascentTime=(maxdepthInMeter-switchdepthInMeter)/AVERAGE_ASCENT_RATE;
		Logging.printDebug("ascenttime="+ ascentTime);
		int timeRequired=TIME_FOR_S_DRILL + TIME_FOR_GAS_SWITCH + ascentTime ;
		Logging.printDebug("timeRequired="+timeRequired);

        //TODO maxdepth moet dieper zijn dan switchdepth of is dit in input afgedekt of is onderstaamde logisch
		if(maxdepthInMeter<switchdepthInMeter){
			timeRequired=TIME_FOR_S_DRILL + TIME_FOR_GAS_SWITCH;
            System.out.println("maxdepthInMeter<switchdepthInMeter is a bit funny. You should be on deco already");
		}
		Logging.printDebug("getTimeBottomToDecogas="+timeRequired+" minuten tot switchdepth",DEBUGLOGGING);
		return timeRequired;
	}
}
