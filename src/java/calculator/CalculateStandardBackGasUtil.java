package calculator;

import minimumgasBepalen.Logging;

final class CalculateStandardBackGasUtil {

	private final static boolean DEBUGLOGGING = false;

	protected static String getStandardBackGas(int depth){
	    //TODO 0 is gek
		String backgas=null;
		if(depth<=30){
			backgas="nitrox EAN32 (of trimix 30/30)";
		}
		if(depth>30 && depth<45){
			backgas="trimix 21/35";
		}
		if(depth==45){
			backgas="trimix 21/35 of 18/45 (met 5 min kortere bodemtijd)";
		}
		if(depth>45 && depth<=60){
			backgas="trimix 18/45";
		}
		if(depth>51){
			backgas="dit is geen T1 duik";
		}
		//63-75m = 15/55 en 78-121m = 10/70
		//ft: 1-100ft=ean32, 110-150=21/35, 160-200=18/45, 210-250=15/55, 260-400=10/70
		//TODO dit zal in de file niet precies kloppen
		Logging.printDebug("standard backgas="+backgas,DEBUGLOGGING);	
		return backgas;
	}
}