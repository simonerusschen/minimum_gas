package calculator;

import java.math.BigDecimal;

import minimumgasBepalen.Conversions;
import minimumgasBepalen.Input;
import minimumgasBepalen.Logging;
import minimumgasBepalen.Result;

/** 
 * @author simone
 *If input is not metric, convert it
 *calculations are done by helperclasses
 */

public class Calculator{

	//	private final static boolean DEBUGLOGGING = true;
	//TODO decogas is 20l/min x 2 ata (op gem 10m) x 1,5 voor je buddy x decotijd dus 30 = 1800l gedeeld door 11 liter voor cft is 163 bar

	public Calculator() {
		//empty constructor
	}

	public static Result calculate (Input input) {

		if(input==null) {
			Logging.printError("calculator: input == null!");
			return null;
		}
		else {
			Logging.printInfo("Calculator calculates");

			//doe mij een nieuwe Conversions
			Conversions conversions = new Conversions();

			//TODO rename helper classes to include "helper" or "util"
			
			int inputDepthInMeter= ConvertInputToMetricUtil.convertInputDepthToMetric(input.getDepth(), input.getUnitOfDepth());
			int inputVolumeInLiter = ConvertInputToMetricUtil.convertInputVolumeToMetric(input.getVolume(), input.getUnitOfVolume());
			int consumption=ConsumptionUtil.getConsumption();
			int switchdepthInMeter = GasSwitchDepthUtil.getGasSwitchDepthInMeter(input.getDecogas());
			int switchDepthInFeet= GasSwitchDepthUtil.getGasSwitchDepthInFeet(input.getDecogas());
			int averageDepthInMeter = AverageDepthUtil.getAverageDepthInMeter(inputDepthInMeter,switchdepthInMeter);

			double pressureInBarAtAverageDepth = PressureAtDepthUtil.getPressureInBarAtDepth(averageDepthInMeter);
			int timeBottomToDeco=TimeToNextStopUtil.getTimeBottomToDecogas(inputDepthInMeter, switchdepthInMeter);	
			//TODO change to int
			int gasNeededInLiter=AmountOfGasRequiredUtil.getTotaalNodigGasInLiter(consumption, pressureInBarAtAverageDepth, timeBottomToDeco);
			int totalVolumeInLiter= CylinderContentUtil.getTotaleCylinderInhoud(input.getTypeOfSet(), inputVolumeInLiter);
			BigDecimal minimumGasInBar = MinimumGasUtil.getMinimumGasInBar(gasNeededInLiter, totalVolumeInLiter);
			BigDecimal minimumGasInPSI=MinimumGasUtil.getMinimumGasInPSI(minimumGasInBar);
			String standardBackGas=CalculateStandardBackGasUtil.getStandardBackGas(inputDepthInMeter);
			Result result = new Result(minimumGasInBar, switchdepthInMeter,timeBottomToDeco,minimumGasInPSI,switchDepthInFeet,standardBackGas,
					inputDepthInMeter, inputVolumeInLiter, consumption, averageDepthInMeter,pressureInBarAtAverageDepth,gasNeededInLiter,totalVolumeInLiter); 

			return result;
		}
	}
}