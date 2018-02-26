package calculator;

import java.math.BigDecimal;

import minimumgasBepalen.Logging;

final class AmountOfGasRequiredUtil {

	private final static boolean DEBUGLOGGING = false;

	protected static int getTotaalNodigGasInLiter(int consumption, double averagePressureInBar,int timeRequiredBottomToDeco) {
		//CAT: Consumption, Average Depth (as pressure), Time
		//for example 45 - 21m : 40 * 4,3 * 10 = 1720
		Logging.printDebug("consumption="+consumption,DEBUGLOGGING);
		Logging.printDebug("averagePressureInBar="+averagePressureInBar,DEBUGLOGGING);
		Logging.printDebug("timeRequiredBottomToDeco="+timeRequiredBottomToDeco,DEBUGLOGGING);
		int totaalNodigGas = (int) (consumption * averagePressureInBar * timeRequiredBottomToDeco)  ;
		Logging.printDebug("total liter gas needed="+totaalNodigGas+" liter",DEBUGLOGGING);
		return totaalNodigGas;
	}
}