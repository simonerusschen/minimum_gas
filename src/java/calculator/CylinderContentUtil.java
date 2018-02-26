package calculator;

import minimumgasBepalen.Logging;
import minimumgasBepalen.Enumerations.TypeOfSet;

final class CylinderContentUtil {

	private final static boolean DEBUGLOGGING = true;

	protected static int getTotaleCylinderInhoud(TypeOfSet typeOfSet, int volumeSetInLiter) {
		int totaleCylinderInhoud=0;
		switch (typeOfSet ) {
		case DOUBLE:
			totaleCylinderInhoud=volumeSetInLiter*2;
			break;
		case SINGLE:
			totaleCylinderInhoud=volumeSetInLiter;
			break;
		default:
			Logging.printError("no valid typeOfSet in GetTotalCylinderInhoud");
			//TODO afdoende?
		}
		Logging.printDebug("totaleCylinderInhoud="+totaleCylinderInhoud+" liter",DEBUGLOGGING);  
		return totaleCylinderInhoud;
	}
}