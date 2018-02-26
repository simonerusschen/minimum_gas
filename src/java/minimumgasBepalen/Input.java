package minimumgasBepalen;

import minimumgasBepalen.Enumerations.*;

public class Input {

	private int depth;
	private int volume;
	UnitOfDepth unitOfDepth;
	UnitOfPressure unitOfPressure;
	UnitOfVolume unitOfVolume;
	TypeOfSet typeOfSet;
	Decogas decogas;
	
	private boolean DEBUGLOGGING=false;

	public Input(int depth,int volume, UnitOfDepth unitOfDepth, UnitOfPressure unitOfPressure, 
			UnitOfVolume unitOfVolume, TypeOfSet typeOfSet, Decogas decogas) throws ValidationException
			{
		Logging.printDebug("setInput received: depth="+depth +", volume="+volume + ", UnitofDepth="+unitOfDepth + 
				", UnitOfPressure="+ unitOfPressure+ ", UnitOfVolume="+ unitOfVolume+
				", TypeOfSet="+typeOfSet +", Decogas="+decogas,DEBUGLOGGING);

		//for each field call the setter
		setVolume(volume); //moet voor setDepth ivm validate()
		setDepth(depth);

		Logging.printDebug("in de Input na setting: volume="+volume, DEBUGLOGGING);
		setTypeOfSet(typeOfSet);
		setUnitOfVolume(unitOfVolume);
		setUnitOfDepth(unitOfDepth);
		setDecogas(decogas);
		setUnitOfPressure(unitOfPressure);

		//validate the input
		validate(); //Exception wordt doorgethrowd 
			}

	private void validate() throws ValidationException {
		/* test voor elke input "if <niet goed> throw exception".
		Hij klapt dus bij de eerste fout, dus je weet dan niet of er meer fout is.
		Maar dit is de noodrem, zou bij scherm al goed moeten zijn. 
		het enum type is al goed want dat dwing je af doordat het type staat in wat je meekrijgt	
		int is afgedekt door type en kan dus niet leeg zijn */
		Logging.printDebug("validate Input: volume="+volume+", depth="+depth, DEBUGLOGGING);
		if (getDepth() <1||getDepth() >170) //TODO 51 is voor meter
			throw new ValidationException("Input incorrect: depth must be >=1 and <=51m");
		if (getVolume()<1||getVolume()>100) //TODO 30 is voor volume
			throw new ValidationException("Input incorrect volume must be >=1 and <=30");			
	}
	/*
	switch (unitOfDepth) {
	case METER: 
		if (getDepth() <1||getDepth() >51)
		throw new ValidationException("Input incorrect: depth must be >=1 and <=51 METER");
	break;
	case FEET:
	if (getDepth() <1||getDepth() >155) //TODO CHECK 51M met GUE
		throw new ValidationException("Input incorrect: depth must be >=1 and <=155 FEET");
	default: Logging.printError("No valid enum in validate input maar dat kan helemaal niet voorkomen");
	}
		*/
	
	
	public int getDepth() {
		return depth;
	}

	//public method dus moet valideren aanroepen, werpt validation exception door
	private void setDepth(int depth) {
		this.depth = depth;
	}

	public int getVolume() {
		return volume;
	}

	private void setVolume(int volume) {
		this.volume = volume;
	}

	public UnitOfDepth getUnitOfDepth() {
		return unitOfDepth;
	}

	private void setUnitOfDepth(UnitOfDepth unitOfDepth) {
		this.unitOfDepth = unitOfDepth;
	}

	public UnitOfPressure getUnitOfPressure() {
		return unitOfPressure;
	}

	private void setUnitOfPressure(UnitOfPressure unitOfPressure) {
		this.unitOfPressure = unitOfPressure;
	}

	public UnitOfVolume getUnitOfVolume() {
		return unitOfVolume;
	}

	private void setUnitOfVolume(UnitOfVolume unitOfVolume) {
		this.unitOfVolume = unitOfVolume;
	}

	public TypeOfSet getTypeOfSet() {
		return typeOfSet;
	}

	private void setTypeOfSet(TypeOfSet typeOfSet) {
		this.typeOfSet = typeOfSet;
	}

	public Decogas getDecogas() {
		return decogas;
	}

	private void setDecogas(Decogas decogas) {
		this.decogas = decogas;
	}
}

