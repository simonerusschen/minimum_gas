package minimumgasBepalen;

public class Conversion
{
	private String van, naar;
	private double factor;
	private final boolean DEBUGLOGGING = false;

	public Conversion(String van, String naar, double factor)
	{
		this.van=van;
		this.naar=naar;
		this.factor=factor;
		Logging.printDebug("nieuweConversion: van="+van+", naar="+naar+", factor="+factor,DEBUGLOGGING); 
	}

	public String getKey()
	{
		return van+"-"+naar;
	}

	public String getVan()
	{
		return van;	
	}

	public String getNaar()
	{
		return naar;	
	}

	public double getFactor()
	{
		return factor;	
	}
	
	@Override
	public String toString() //overrides de standaard toString methode die object ID bevat in dit geval
	{
		return "conversion: "+getVan()+"-"+getNaar()+"-"+getFactor();
	}
}
