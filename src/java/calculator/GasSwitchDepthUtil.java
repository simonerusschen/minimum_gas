package calculator;

import minimumgasBepalen.Conversions;
import minimumgasBepalen.Logging;
import minimumgasBepalen.Enumerations.Decogas;

final class GasSwitchDepthUtil {

	private final static boolean DEBUGLOGGING = false;

	protected static int getGasSwitchDepthInMeter(Decogas decogas)	{
		int switchdepth=0;
		switch(decogas) {
		case EAN100:
			switchdepth=6;
			break;
		case EAN50:
			switchdepth=21;
			break;
			//TODO 35%=36m, 21%=57m	
		case NONE:
			switchdepth=0;
			break;
		default:
			System.out.println("geef een standaard mix op in GUE T1 bereik: EAN50, EAN100 of NONE");
			//TODO dit moet op scherm oid, error afhadeling?
		}
		Logging.printDebug("getGasSwitchDepthInMeter="+switchdepth+" meter",DEBUGLOGGING);  
		return switchdepth;
	}

	//protected static int getGasSwitchDepthInFeet(Decogas decogas, Conversions conversions) {
        protected static int getGasSwitchDepthInFeet(Decogas decogas) {
		int switchdepth=0;
		switch(decogas) {
		case EAN100:
			switchdepth=20;
			break;
		case EAN50:
			switchdepth=70;
			break;
			//TODO 35%=120, 21%=190	
		case NONE:
			switchdepth=0;
			break;
		default:
			System.out.println("oeps in de getGasSwitchDepthInFeet");
		}
		Logging.printDebug("getGasSwitchDepthInFeet="+switchdepth+" feet",DEBUGLOGGING);  //TODO wat is std
		return switchdepth;
	}
}
