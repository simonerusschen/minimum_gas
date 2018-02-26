package minimumgasBepalen;
import java.awt.FlowLayout;
import javax.swing.*;

/*
 * Een venster heeft een paneel met:
 * - moglijkheid voor gegevens invoer;
 * - knop voor berekening  berekent minimum gas en toont deze;
 * - knoppen voor maken van een file
 */

//TODO JAVADOC maken

public class Opstart extends JFrame
{
	// maak een venster en stel enkele eigenschappen ervan in
	// geef het venster een paneel als inhoud

	public Opstart() {
		JFrame venster = new JFrame();
		venster.setSize(700,750);//breedte,hoogte
		venster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		venster.setTitle("bepaal minimum gas");
		venster.setLocation(50,50); //niet helemaal linksboven
		JPanel veldenpaneel = new VeldenPaneel();
		veldenpaneel.setLayout(new FlowLayout(FlowLayout.LEFT));
		venster.add(veldenpaneel);
		venster.setVisible(true);
	}

	public static void main( String[ ] args) {

		new Opstart();
	}
}
