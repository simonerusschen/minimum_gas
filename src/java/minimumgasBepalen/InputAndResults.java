package minimumgasBepalen;

import java.util.ArrayList;
//TODO class InputAndResult an inner class of this one maken

public class InputAndResults {
	boolean DEBUGLOGGING=false;
	private ArrayList<InputAndResult> myList  = new ArrayList<InputAndResult>();	

	public void putToList(InputAndResult inputAndResult) throws ValidationException
	{
		if (inputAndResult == null){
			Logging.printError("InputAndResults heeft en object gekregen die null is");
			throw new ValidationException("Sorry, interne fout door programmeur (3)");
		}
		else {
			Logging.printDebug("InputAndResults received inputAndResult:" + inputAndResult, DEBUGLOGGING);
			Logging.printDebug("InputAndResults received inputAndResult:" + inputAndResult,DEBUGLOGGING);
			myList.add(inputAndResult);
			Logging.printDebug("InputAndResults-aantal in myList = " + myList.size(),DEBUGLOGGING); 
			//	printInhoudArrayLijst(); //TODO werkt maar geeft veel output. bovendien is het alleen codes, nog TOSTRING maken
		}
	}

	public int getLength() {
		return myList.size();	
	}

	public InputAndResult getInputAndResultByPosition(int position) {
		return myList.get(position);
	}

	public InputAndResult getInputAndResultByDepth(int depth) {
		InputAndResult inputAndResult=null; 	
		// met diepte gegevens opzoeken
		for (int position = 0; position < myList.size(); position ++) {
			//zoek inputobject waar diepte depth in staat
			if (depth==myList.get(position).getInput().getDepth() ) {
				Logging.printDebug("getInputByDepth finds input= " +myList.get(position).getInput() , DEBUGLOGGING );//TODO
				inputAndResult= myList.get(position);
			}	
			//Logging.printError("Error Input niet gevonden in InputAndResults"); //TODO 
		}	
		return inputAndResult;
	}

	public void printInhoudArrayLijst() 
	{
		System.out.println("InputAndResults geeft myList weer (input-result)");

		for (int position = 0; position < myList.size(); position ++)
		{
			System.out.println("position="+myList.get(position) + ", input="+ myList.get(position).getInput() +" ,result="+myList.get(position).getResult() );
		}
	}
}

