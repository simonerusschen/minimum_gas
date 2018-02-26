package calculator;

import java.math.BigDecimal;
import java.math.MathContext;

import minimumgasBepalen.Conversion;
import minimumgasBepalen.Conversions;
import minimumgasBepalen.Logging;

final class MinimumGasUtil {

	private final static boolean DEBUGLOGGING = true;
    private Conversions conversions = new Conversions();

	//TODO is BigDecimal nodig?
	protected static BigDecimal getMinimumGasInBar(int gasNeededInLiter, int totalVolumeInLiter) {
		BigDecimal minimumGasInBar = new BigDecimal(gasNeededInLiter).divide(new BigDecimal(totalVolumeInLiter),1,BigDecimal.ROUND_CEILING);
		Logging.printDebug("minimumGasInBar="+minimumGasInBar+" bar");
		//TODO afronden naar boven op hele tiental

		//methode compareTo returns 1 als minGas < 40 en 0 als equal en -1 als groter

		if( minimumGasInBar.compareTo(new BigDecimal(40)) < 0) {
			minimumGasInBar=new BigDecimal(40);
			Logging.printDebug(" maar minimumGasInBar moet altijd 40 zijn dus overruled",DEBUGLOGGING);
		}
		return minimumGasInBar;
	}

	protected static BigDecimal getMinimumGasInPSI(BigDecimal minimumGasInBar) {
//TODO waarom alleen een druk?
		BigDecimal factor = new BigDecimal(4);//TODO onzin new BigDecimal(conversions.getConversion("bar", "psi").getFactor());
		MathContext MATH_CTX=new MathContext(4);//dit is het aantal getallen TODO check

		BigDecimal minimumGasInPSI = minimumGasInBar.multiply(factor,MATH_CTX);

		//TODO afronden naar boven op hele tiental 
		//TODO CHECK of de uitkomst correct is (er komt nu vaak 580.2 uit als laagste dus ergens klopt iets niet
		Logging.printDebug("getMinimumGasInPSI="+minimumGasInPSI+" PSI", DEBUGLOGGING);
		if(minimumGasInPSI .compareTo(new BigDecimal(500)) < 0){
			minimumGasInPSI=new BigDecimal(500);//35 bar (uit fundamentals manual)
			Logging.printInfo(" maar minimumGasInPSI moet altijd 500PSI zijn dus overruled");
		}
		return minimumGasInPSI;
	}	
}