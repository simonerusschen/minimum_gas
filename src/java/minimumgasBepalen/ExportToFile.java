package minimumgasBepalen;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.swing.JOptionPane;

public final class ExportToFile {
	private static PrintWriter file;
	private static boolean DEBUGLOGGING=false;
	private static InputAndResult inputAndResult;
	private static String filename;
	private ExportToFile() {
		//constructor
	}

	public static void createFile(InputAndResults inputAndResults) {
		Logging.printDebug("ExportToFile received inputAndResults:"+inputAndResults, DEBUGLOGGING);
		filename=getFileName(inputAndResults); //TODO waarom komt het hier voor elke regel
		try {
			file = new PrintWriter(new FileWriter(filename, false));//false = overschijf file
			file.print(new Timestamp(System.currentTimeMillis()));	//TODO zonder millisec

			if (inputAndResults==null ||inputAndResults.getLength()==0){
				//een lege file omdat de oude er nog kan staan en de gebruiker dan kan denken dat het goed is gegaan
				file.println("sorry, er is iets foutgegaan. De programmeur is een prutser");
			}
			else {
				file.println("\ninputdiepte(m);inputUnitOfDepth;calc depthInMeter;" +
						"inputVolume;inputUnitOfVolume;calc volumeCylindersInLiter;inputSet;totalVolumeInLiter;" +
						"decogas;gaswissel(m);gaswissel(ft);" +
						"tijd bodem tot wissel(min);averageDepthInMeter;pressureInBarAtAverageDepth;"+
						"consumption;gasNeededInLiter;"+
						"min.gas(bar);min.gas(psi);" +
						"standaard backgas");

				for (int position = 0; position < inputAndResults.getLength(); position ++) {
					inputAndResult=inputAndResults.getInputAndResultByPosition(position);	

					file.println(
							inputAndResult.getInput().getDepth() +";"+
									inputAndResult.getInput().getUnitOfDepth() +";"+
									inputAndResult.getResult().getDepthInMeter()+";"+ 
									inputAndResult.getInput().getVolume() +";"+
									inputAndResult.getInput().getUnitOfVolume() +";"+
									inputAndResult.getResult().getVolumeCylindersInLiter()+";"+
									inputAndResult.getInput().getTypeOfSet() +";"+
									inputAndResult.getResult().getTotalVolumeInLiter()+";"+  
									inputAndResult.getInput().getDecogas() +";"+
									inputAndResult.getResult().getSwitchdepthInMeter()+";"+
									inputAndResult.getResult().getSwitchDepthInFeet()+";"+
									inputAndResult.getResult().getTimeBottomToDeco()+";"+
									inputAndResult.getResult().getAverageDepthInMeter()+";"+ 
									inputAndResult.getResult().getPressureInBarAtAverageDepth()+";"+ 
									inputAndResult.getResult().getConsumption()+";"+
									inputAndResult.getResult().getGasNeededInLiter() +";"+
									inputAndResult.getResult().getMinimumGasInBar()+";"+
									inputAndResult.getResult().getMinimumGasInPSI()+";"+
									inputAndResult.getResult().getStandardBackGas());
				}
			}
			file.close();//TODO question: is it enough when it is in finally?
		}
		catch (IOException ex) {
			//TODO als de folder er niet is mislukt het. Dus helpen met folder maken
			JOptionPane.showMessageDialog(
					null,
					"Er is een fout opgetreden bij het maken.",
					"Maken van het bestand is mislukt",
					JOptionPane.WARNING_MESSAGE);
		}	
		finally {
			file.close();//avoid lock
		}		
	}

	private static String getFileName(InputAndResults inputAndResults) {
		//Todo error als path niet bestaat
		filename = "/Users/Gebruiker/Documents/Minimum Gas output files/minimumgas_"+"_"+
				inputAndResults.getInputAndResultByPosition(0).getInput().getUnitOfDepth()  +"_"+
				inputAndResults.getInputAndResultByPosition(0).getInput().getUnitOfVolume() +"_"+
				inputAndResults.getInputAndResultByPosition(0).getInput().getDecogas() +
				".csv";

		Logging.printInfo("filename= "+filename);
		return filename;
	}
}