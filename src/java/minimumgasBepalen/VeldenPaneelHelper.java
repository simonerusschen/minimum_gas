package minimumgasBepalen;

import calculator.Calculator;
import minimumgasBepalen.Enumerations.Decogas;
import minimumgasBepalen.Enumerations.TypeOfSet;
import minimumgasBepalen.Enumerations.UnitOfDepth;
import minimumgasBepalen.Enumerations.UnitOfPressure;
import minimumgasBepalen.Enumerations.UnitOfVolume;

/* 
 * Deze klasse voert een deel van de taken uit voor VeldenPaneel.
 *  Het ontvangt input en geeft aan paneel de tekst die getoond moet worden
 */

public class VeldenPaneelHelper 
{
	Input input;
	Result result;
	boolean DEBUGLOGGING=false;

	public VeldenPaneelHelper() {
		//lege constructor
	}

	public void calculate(int depth,int volume, UnitOfDepth unitOfDepth, UnitOfPressure unitOfPressure, UnitOfVolume unitOfVolume, TypeOfSet typeOfSet, Decogas decogas) 
	{
		input=createInput(depth, volume, unitOfDepth, unitOfPressure, unitOfVolume, typeOfSet, decogas);
		result= Calculator.calculate(input); //deze roep je niet aan als input niet lukt

		//tonen
		VeldenPaneel.displayWaarschuwing("BEREKENING voor psi, cft en bar klopt niet! \n en bovendien zijn er afrondingsfouten"); 

		VeldenPaneel.displayResultaat("Minimum gas: "+result.getMinimumGasInBar()+" bar"
				+"\nGaswissel op: "+result.getSwitchdepthInMeter()+" meter"
				+"\nTijd van bodem tot gaswissel: "+result.getTimeBottomToDeco()+ " minuten"
				+ "\nBackgas standaard mix: "+result.getStandardBackGas());

		VeldenPaneel.displayAlleDieptes("hier tijdelijk tussenresultaten tonen"
				+ "\n\nomgerekend van imperial naar metric:"
				+ "\ndepthInMeter= " + result.getDepthInMeter()  
				+ "\nvolumeCylindersInLiter= " + result.getVolumeCylindersInLiter()
				+ "\n\nberekend:"
				+ "\ntotalVolumeInLiter= " + result.getTotalVolumeInLiter()  
				+ "\ndiepte Gaswissel in meter= "+result.getSwitchdepthInMeter()
				+ "\nswitchDepthInFeet= " + result.getSwitchDepthInFeet() 		
				+ "\ntijd van bodem tot gaswissel= "+result.getTimeBottomToDeco()
				+ "\naverageDepthInMeter= " + result.getAverageDepthInMeter() 
				+ "\npressureInBarAtAverageDepth= " + result.getPressureInBarAtAverageDepth() 
				+ "\nconsumption (l/min)= " + result.getConsumption()
				+ "\ngasNeededInLiter= " + result.getGasNeededInLiter()
				+ "\nminimum gas in Bar= " +result.getMinimumGasInBar()
				+ "\nminimumGasInPSI= " + result.getMinimumGasInPSI()
				+ "\nbackgas standaard mix= "+result.getStandardBackGas());
	}


	public void createFile(int depth,int volume, UnitOfDepth unitOfDepth, UnitOfPressure unitOfPressure, UnitOfVolume unitOfVolume, TypeOfSet typeOfSet, Decogas decogas) {

		int maxGueT1Depth=0;
		InputAndResults inputAndResults =new InputAndResults();

		VeldenPaneel.displayAlleDieptes("\n\ndeel  van de inhoud van de file:" + "\n"+ "diepte(m)\tmin.gas(bar)\tbodem-gaswissel(min)\tmin.gas(psi)\tgaswissel(ft)");

		switch (unitOfDepth) {
		case METER:
			maxGueT1Depth=51;
			break;
		case FEET:
			maxGueT1Depth = 170; //max GUE T! diepte 
			break;
		default:
			Logging.printError("No valid enum in createFile: " + unitOfDepth);
		}

		try {
			for(int teller =1; teller <=maxGueT1Depth; teller++) {
				depth=teller;
				input=createInput(depth, volume, unitOfDepth, unitOfPressure, unitOfVolume, typeOfSet, decogas);
				Result result =Calculator.calculate(input);//hier kom je dus niet als input is mislukt
				//TODO try catch!!
				InputAndResult inputAndResult =new InputAndResult(input, result);//throws ValidationException
				inputAndResults.putToList(inputAndResult);//throws ValidationException

				VeldenPaneel.displayAlleDieptes("\n"+input.getDepth()+"\t"+result.getMinimumGasInBar()+
						"\t"+result.getTimeBottomToDeco() +"\t\t" + result.getMinimumGasInPSI()+"\t"+ result.getSwitchDepthInFeet());				

				ExportToFile.createFile(inputAndResults);			
			}
		}
		catch (ValidationException e1) {
			//TODO toon tekst van exception
			Logging.printError("validationException in VeldenPaneelHelper bij execute");
		}

	}

	private Input createInput(int depth,int volume, UnitOfDepth unitOfDepth, UnitOfPressure unitOfPressure, 
			UnitOfVolume unitOfVolume, TypeOfSet typeOfSet, Decogas decogas) 
	{
		try
		{
			input = new  Input(depth, volume, unitOfDepth, unitOfPressure, unitOfVolume, typeOfSet, decogas);	
			Logging.printDebug("Veldenpaneelhelper has created input:"+input, DEBUGLOGGING);
		}
		catch (ValidationException e1) {
			//TODO toon tekst van exception
			Logging.printError("validationException in VeldenPaneelHelper bij execute");
		}
		return input;
	}
}

