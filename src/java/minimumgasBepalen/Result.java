package minimumgasBepalen;

import java.math.BigDecimal;

public class Result {

	private BigDecimal minimumGasInBar;
	private int switchdepthInMeter;
	private int timeBottomToDeco;
	private BigDecimal minimumGasInPSI;
	private int switchDepthInFeet;
	private String standardBackGas;
	private int depthInMeter;
	private int volumeCylindersInLiter;
	private int consumption;
	private int averageDepthInMeter;
	private double pressureInBarAtAverageDepth;
	private int gasNeededInLiter;
	private int totalVolumeInLiter;
	
	boolean DEBUGLOGGING=true;

	public Result(BigDecimal minimumGasInBar, int switchdepthInMeter, int timeBottomToDeco, BigDecimal minimumGasInPSI, int switchDepthInFeet, String standardBackGas, 
					int depthInMeter, int volumeCylindersInLiter, int consumption, int averageDepthInMeter, 
					double pressureInBarAtAverageDepth, int gasNeededInLiter, int totalVolumeInLiter) {
		
		Logging.printDebug("Result ontvangt: minimumGasInBar=" + minimumGasInBar + ", switchdepthInMeter=" + switchdepthInMeter
				+ ", timeBottomToDeco=" + timeBottomToDeco + ", minimumGasInPSI=" + minimumGasInPSI
				+ ", switchDepthInFeet=" + switchDepthInFeet + ", standardBackGas=" + standardBackGas 
				+ ", depthInMeter=" + depthInMeter + ", volumeCylindersInLiter=" + volumeCylindersInLiter
				+ ", consumption=" + consumption + ", averageDepthInMeter=" + averageDepthInMeter 
				+ ", pressureInBarAtAverageDepth=" + pressureInBarAtAverageDepth 
				+ ", gasNeededInLiter=" + gasNeededInLiter + ", totalVolumeInLiter=" + totalVolumeInLiter, DEBUGLOGGING);
		
		setMinimumGasInBar(minimumGasInBar);
		setSwitchdepthInMeter(switchdepthInMeter);
		setTimeBottomToDeco(timeBottomToDeco);
		setMinimumGasInPSI(minimumGasInPSI);
		setSwitchDepthInFeet(switchDepthInFeet);
		setStandardBackGas(standardBackGas);
		setDepthInMeter(depthInMeter);
		setVolumeCylindersInLiter(volumeCylindersInLiter);
		setConsumption(consumption);
		setAverageDepthInMeter(averageDepthInMeter);
		setPressureInBarAtAverageDepth(pressureInBarAtAverageDepth);
		setGasNeededInLiter(gasNeededInLiter);
		setTotalVolumeInLiter(totalVolumeInLiter);
	}

	public BigDecimal getMinimumGasInBar() {
		return minimumGasInBar;
	}

	private void setMinimumGasInBar(BigDecimal minimumGasInBar) {
		this.minimumGasInBar = minimumGasInBar;
	}

	public int getSwitchdepthInMeter() {
		return switchdepthInMeter;
	}

	private void setSwitchdepthInMeter(int switchdepthInMeter) {
		this.switchdepthInMeter = switchdepthInMeter;
	}

	public int getTimeBottomToDeco() {
		return timeBottomToDeco;
	}

	private void setTimeBottomToDeco(int timeBottomToDeco) {
		this.timeBottomToDeco = timeBottomToDeco;
	}

	public BigDecimal getMinimumGasInPSI() {
		return minimumGasInPSI;
	}

	private void setMinimumGasInPSI(BigDecimal minimumGasInPSI) {
		this.minimumGasInPSI = minimumGasInPSI;
	}

	public int getSwitchDepthInFeet() {
		return switchDepthInFeet;
	}

	private void setSwitchDepthInFeet(int switchDepthInFeet) {
		this.switchDepthInFeet = switchDepthInFeet;
	}

	public String getStandardBackGas() {
		return standardBackGas;
	}

	private void setStandardBackGas(String standardBackGas) {
		this.standardBackGas = standardBackGas;
	}

	public int getDepthInMeter() {
		return depthInMeter;
	}

	private void setDepthInMeter(int depthInMeter) {
		this.depthInMeter = depthInMeter;
	}

	public int getVolumeCylindersInLiter() {
		return volumeCylindersInLiter;
	}
	
	private void setVolumeCylindersInLiter(int volumeCylindersInLiter) {
		this.volumeCylindersInLiter = volumeCylindersInLiter;
	}

	public int getConsumption() {
		return consumption;
	}

	private void setConsumption(int consumption) {
		this.consumption = consumption;
	}

	public int getAverageDepthInMeter() {
		return averageDepthInMeter;
	}

	private void setAverageDepthInMeter(int averageDepthInMeter) {
		this.averageDepthInMeter = averageDepthInMeter;
	}

	public double getPressureInBarAtAverageDepth() {
		return pressureInBarAtAverageDepth;
	}

	private void setPressureInBarAtAverageDepth(double pressureInBarAtAverageDepth) {
		this.pressureInBarAtAverageDepth = pressureInBarAtAverageDepth;
	}

	public int getGasNeededInLiter() {
		return gasNeededInLiter;
	}

	private void setGasNeededInLiter(int gasNeededInLiter) {
		this.gasNeededInLiter = gasNeededInLiter;
	}

	public int getTotalVolumeInLiter() {
		return totalVolumeInLiter;
	}

	private void setTotalVolumeInLiter(int totalVolumeInLiter) {
		this.totalVolumeInLiter = totalVolumeInLiter;
	}	
}
