package minimumgasBepalen;
import java.util.Hashtable;

public class Conversions 
{
	//TODO uitzoeken of en hoe ik hier een singleton van kan maken. Advanced. Prio laag
	
	Hashtable<String,Conversion> conversions ;
	boolean DEBUG=false;
	
	public  Conversions()	{
		Conversion conversion1 = new Conversion("bar","psi",14.5037738);// 1 bar=14,5psi
		Conversion conversion2 = new Conversion("cft","liter",28.31685);//1 cft = 28,3 liter //TODO met methode al gemaakt
		//dit is letterlijk, fles moet 11 zijn
		Conversion conversion3 = new Conversion("ft","cm",30.48);//1ft=30,48 cm
		Conversion conversion4 = new Conversion("meter","ft",3.2808399);//1 meter is 3,28 feet TODO met methode
		Conversion conversion5 = new Conversion("liter", "cft", 0.03531); // 1liter = 0,03531 cft //TODO methode
		
		Logging.printDebug(conversion1.toString(), DEBUG);
		Logging.printDebug(conversion2.toString(), DEBUG);
		Logging.printDebug(conversion3.toString(), DEBUG);
		Logging.printDebug(conversion4.toString(), DEBUG);
		Logging.printDebug(conversion5.toString(), DEBUG);
		
		//Create a Hashtable
		conversions = new Hashtable<String,Conversion>();

		//Adding Key and Value pairs to Hashtable
		conversions.put (conversion1.getKey(),conversion1);// 1 bar=14,5psi
		conversions.put (conversion2.getKey(),conversion2);//1 cft = 28,3 liter
		conversions.put (conversion3.getKey(),conversion3);//1ft=30,48 cm
		conversions.put (conversion4.getKey(),conversion4);//1meter=3,28 ft
		conversions.put (conversion5.getKey(),conversion5);
		
		//LOOP die alles print dit is een endless loop!!! //TODOD
/*
		while(conversions.keys().hasMoreElements())
		{
			key = (String) conversions.keys().nextElement();
			Logging.printDebug("Key: " + key+ " & object: " + conversions.get(key),DEBUG);
		}
*/
	}

	public Conversion getConversion(String vanEenheid, String naarEenheid)
	{	
		Conversion conversion =conversions.get(vanEenheid+"-"+naarEenheid);
		return conversion;
	}

	/*
	private double getCftToLiter() {
		double cftToLiter=(30.48*30.48*30.48)/1000 ;// want 1 ft=30,48 cm
		System.out.println("cftToLiter="+cftToLiter);
		return cftToLiter;
	}
*/
}