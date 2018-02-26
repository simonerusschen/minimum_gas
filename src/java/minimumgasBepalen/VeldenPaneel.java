package minimumgasBepalen;
import javax.swing.*;

import minimumgasBepalen.Enumerations.*;

import java.awt.event.*;

/* 
 * Deze klasse maakt een paneel met invoervelden
 * en reageert op de knop door waardes te valideren en door te geven aan helper
 */

public class VeldenPaneel extends JPanel implements ActionListener, FocusListener
{
	private JTextField diepteveld;
	private JTextField inhoudveld;
	private JRadioButton enkelset, dubbelset;
	private JRadioButton liter,cft;	
	private JRadioButton unitinmeter,unitinfeet;	
	private JRadioButton decogas50,decogas100, decogasgeen;	
	private JRadioButton unitinbar,unitinpsi;
	private JButton calculateButton, createFileButton;
	private static JTextArea waarschuwingVeld;
	private static JTextArea resultaatVeld;
	private static JTextArea alleDieptesVeld;
	
	private UnitOfDepth unitOfDepth = null;
	private UnitOfPressure unitOfPressure=null;
	private UnitOfVolume unitOfVolume=null;
	private TypeOfSet typeOfSet=null;
	private Decogas decogas=null;
	private int depth=0;
	private int volume=0;
	
	VeldenPaneelHelper veldenPaneelHelper = new VeldenPaneelHelper();	
	boolean DEBUGLOGGING=false;
	
	public VeldenPaneel() {
		createAndAddFieldsAndButtons();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO disable knop tot alles goed is
		if (e.getSource()==calculateButton) {	
			actionOnCalculateButton();
		}

		//TODO refcator met OR in if statement
		if (e.getSource()==createFileButton) {
			actionOnCalculateButton();
			veldenPaneelHelper.createFile(depth,volume,unitOfDepth,unitOfPressure,unitOfVolume,typeOfSet,decogas);
		}

		//default wijzigen bij andere selectie
		if (e.getSource()==unitinfeet) {
			diepteveld.setText("148");//45 meter is 148ft
		}
		if (e.getSource()==unitinmeter) {
			diepteveld.setText("45");
		}
		if (e.getSource()==liter) {
			inhoudveld.setText("12");
		}
		if (e.getSource()==cft) {
			inhoudveld.setText("80");
		}
	}	
	
	private void actionOnCalculateButton()
	{
	//TODO check validaties omdat dit dan dus is zonder loss of focus
	clearResultFields(); //to avoid previous results stay displayed
	readFieldsData();	
	veldenPaneelHelper.calculate(depth,volume,unitOfDepth,unitOfPressure,unitOfVolume,typeOfSet,decogas);	
	}
	
	private void readFieldsData() {
		depth =Integer.parseInt(diepteveld.getText());
		volume =Integer.parseInt(inhoudveld.getText());

		if(enkelset.isSelected()) {
			typeOfSet=TypeOfSet.SINGLE;
		}
		if(dubbelset.isSelected()) {
			typeOfSet=TypeOfSet.DOUBLE;
		}
		if(liter.isSelected()) {
			unitOfVolume=UnitOfVolume.LITER;
		}
		if(cft.isSelected()) {
			unitOfVolume=UnitOfVolume.CFT;
		}
		if(unitinmeter.isSelected()) {
			unitOfDepth=UnitOfDepth.METER;
		}
		if(unitinfeet.isSelected()) {
			unitOfDepth=UnitOfDepth.FEET;
		}
		if(decogas50.isSelected()) {
			decogas=Decogas.EAN50;
		}
		if(decogas100.isSelected()) {
			decogas=Decogas.EAN100;
		}
		if(decogasgeen.isSelected()) {
			decogas=Decogas.NONE;
		}		
		if(unitinbar.isSelected()) {
			unitOfPressure=UnitOfPressure.BAR;
		}
		if(unitinpsi.isSelected()) {
			unitOfPressure=UnitOfPressure.PSI;
		}
		
		Logging.printDebug("uitgelezen: depth="+depth +", volume="+volume + ", UnitofDepth="+unitOfDepth + 
				", UnitOfPressure="+ unitOfPressure+ ", UnitOfVolume="+ unitOfVolume+
				", TypeOfSet="+typeOfSet +", Decogas="+decogas,DEBUGLOGGING);
	}

	private void clearResultFields() {
		waarschuwingVeld.setText("");
		resultaatVeld.setText("");
		alleDieptesVeld.setText("");
	}

	@Override
	public void focusGained(FocusEvent e) {
		//niks
	}

	@Override
	public void focusLost(FocusEvent e) {
		//TODO wat hieronder staat
	}
	/*	
		if (e.getSource()==diepteveld) {

			boolean validation=validateDepthInput();
			if (!validation) {
			showWarning("foute waarde","diepte voor T1 is groter dan 0 en kleiner dan 52"); //TODO afhankelijk of meter of feet
					diepteveld.setForeground(Color.RED); //TODO maar na correctie moet het weer zwart worden als t goed is
			}
		//diepteveld. //TODO hoe de focus er weer opzetten?
	}

if (e.getSource()==inhoudveld) {
	if(Integer.parseInt(inhoudveld.getText()) <1)//TODO try catch de NumberFormatException
		{
		showWarning("foute waarde","volume moet een geheel getal zijn en groter dan 0");
		inhoudveld.setForeground(Color.RED);
	}
}
}


private boolean validateDepthInput () {
	boolean validation=true;
	try {
		if(Integer.parseInt(diepteveld.getText()) <1 ||Integer.parseInt(diepteveld.getText()) >51) {
validation=false;
			}
	}
	catch (NumberFormatException e1) {
				showWarning("foute waarde","Vul een geheel getal van 1 tot 51 in");
	}	

	return validation;
}
	 */

	public static void displayResultaat(String tekst)
	{
		resultaatVeld.setText(tekst);
	}
	
	public static void displayWaarschuwing(String tekst)
	{
		waarschuwingVeld.setText(tekst);
	}
	
	public static void displayAlleDieptes(String tekst)
	{
		alleDieptesVeld.append(tekst);
		alleDieptesVeld.setCaretPosition(0);//show top of list
	}
	
	
	public void showWarningDialog(String warningTitle, String warningText) {
		JOptionPane.showMessageDialog(
				null,
				warningTitle,
				warningText,
				JOptionPane.WARNING_MESSAGE);
	}

	private void createAndAddFieldsAndButtons()	{
		String uitlijnspaties="                                   "; //TODO ander soort layoutmanager proberen

		add(new JLabel("Diepte       "));
		diepteveld = new JTextField("42",2); //niet dieper dan 999m //TODO 45
		diepteveld.setToolTipText("vul een geheel getal van 1-51 voor meter en 1-170 voor feet");
		diepteveld.addFocusListener(this);
		add(diepteveld);
		ButtonGroup meterOfFeet=new ButtonGroup();
		unitinmeter = new JRadioButton("meter    ");
		unitinmeter.setSelected(true);
		unitinmeter.addActionListener(this);
		meterOfFeet.add(unitinmeter);
		add(unitinmeter);
		unitinfeet = new JRadioButton("feet"+uitlijnspaties+uitlijnspaties);
		unitinfeet.setSelected(false);
		unitinfeet.addActionListener(this);
		meterOfFeet.add(unitinfeet);
		add(unitinfeet);

		//spaties om het een beetje uit te lijnen
		add(new JLabel(uitlijnspaties));

		add(new JLabel("Flesinhoud"));
		inhoudveld = new JTextField("12",2); //bijv 12 liter
		inhoudveld.setToolTipText("vul een geheel getal in van 1-30");
		inhoudveld.addFocusListener(this);
		add(inhoudveld);
		ButtonGroup enkelOfDubbel=new ButtonGroup();
		enkelset = new JRadioButton("enkelset");
		enkelset.setSelected(false);
		enkelOfDubbel.add(enkelset);
		add(enkelset);
		dubbelset = new JRadioButton("dubbelset"+uitlijnspaties);
		dubbelset.setSelected(true);		
		enkelOfDubbel.add(dubbelset);
		add(dubbelset);

		//spaties om het een beetje uit te lijnen
		add(new JLabel(uitlijnspaties));

		add(new JLabel("Volume eenheid   "));
		ButtonGroup eenheidInhoud=new ButtonGroup();
		liter = new JRadioButton("liter      ");
		liter.setSelected(true);
		liter.addActionListener(this);
		eenheidInhoud.add(liter);
		add(liter);
		cft = new JRadioButton("cft"+uitlijnspaties+uitlijnspaties);
		cft.setSelected(false);
		cft.addActionListener(this);
		eenheidInhoud.add(cft);
		add(cft);

		//spaties om het een beetje uit te lijnen
		add(new JLabel(uitlijnspaties));

		add(new JLabel("Decogas              "));		
		ButtonGroup decogas=new ButtonGroup();
		decogas50 = new JRadioButton("50%");
		decogas50.setSelected(true);
		decogas.add(decogas50);
		add(decogas50);
		decogas100 = new JRadioButton("100%");
		decogas100.setSelected(false);
		decogas.add(decogas100);
		add(decogas100);
		decogasgeen = new JRadioButton("geen"+uitlijnspaties);
		decogasgeen.setSelected(false);
		decogas.add(decogasgeen);
		add(decogasgeen);

		//spaties om het een beetje uit te lijnen
		add(new JLabel(uitlijnspaties));

		add(new JLabel("druk in bar of psi?"));
		ButtonGroup drukeenheid=new ButtonGroup();
		unitinbar = new JRadioButton("bar       ");
		unitinbar.setSelected(true);
		drukeenheid.add(unitinbar);
		add(unitinbar);
		unitinpsi = new JRadioButton("psi"+uitlijnspaties+uitlijnspaties);
		unitinpsi.setSelected(false);
		drukeenheid.add(unitinpsi);
		add(unitinpsi);

		//spaties om het een beetje uit te lijnen
		add(new JLabel(uitlijnspaties));

		calculateButton = new JButton("Bereken");
		calculateButton.addActionListener(this);
		add(calculateButton);
		createFileButton = new JButton("Maak file");
		createFileButton.addActionListener(this);
		add(createFileButton);

		//spaties om het een beetje uit te lijnen
		add(new JLabel(uitlijnspaties));

		waarschuwingVeld = new JTextArea(5,48); // resultaat kan niet meer zijn dan 300 bar
		add(waarschuwingVeld);
		resultaatVeld = new JTextArea(5,48); // resultaat kan niet meer zijn dan 300 bar
		add(resultaatVeld);
		add(new JLabel("Minimum gas voor elke diepte (dit komt ook in file)"));
		alleDieptesVeld = new JTextArea(21,55); // resultaat kan niet meer zijn dan 300 bar
		JScrollPane scrollarea= new JScrollPane(alleDieptesVeld);
		add(scrollarea);
	}
}