package minimumgasBepalen;

public final class Logging {

	private static boolean systemOutIsOn=true;
	private static boolean DEBUG=true;
	private static boolean INFO=true;
	private static boolean ERROR=true;
	
	//Er bestaan wel standaard van dit soort klassen maar dat zoek ik nog wel eens uit
	
	private Logging()
	{
		//niks: je hebt deze constructor nodig om de klasse direct aan te kunnen roepen 
		//zonder deze te instantieren
	}
	
	public static void print(String string)//omdat ik later pas onderscheid ben gaan maken
	//en nu niet alles gelijk wil wijzigen
	{
		if (systemOutIsOn)
		{
			System.out.println("print:"+string);		
		}
	}
	
	public static void printError(String string)
	{
		if (ERROR)
		{
			System.out.println("Error: "+string);		
		}
	}
	
	public static void printInfo(String string)
	{
		if (INFO)
		{
			System.out.println("Info: "+string);		
		}
	}
	
	public static void printDebug(String string, Boolean Debug) // om dit in methode uit te kunnen zetten
	{	
		if (Debug)
		{
			System.out.println("Debug: "+string);		
		}
	}

	public static void printDebug(String string)
	{
		if (DEBUG)
		{
			System.out.println("Debug: "+string);		
		}
	}

}
