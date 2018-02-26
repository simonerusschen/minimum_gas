package minimumgasBepalen;

//deze klasse maakt een object van input en result die bij elkaar horen
public class InputAndResult {
	Input input;
	Result result;
	boolean DEBUGLOGGING=false;

	public InputAndResult(Input input, Result result) throws ValidationException {

		if (input == null) {
			Logging.printError("InputAndResult: input == null");
			throw new ValidationException("Sorry, interne fout door programmeur (1)");
		}
		if (result == null) {
			Logging.printError("InputAndResult: result == null");
			throw new ValidationException("Sorry, interne fout door programmeur (2)");//TODO hoe weet je welke nummer waar staat	
		}
		else {
			setInput(input);
			setResult(result);
			Logging.printDebug("InputAndResult received input: "+input+", and result: "+result, DEBUGLOGGING);
		}
	}

	public Input getInput() {
		return input;
	}

	private void setInput(Input input) {
		this.input = input;
	}

	public Result getResult() {
		return result;
	}

	private void setResult(Result result) {
		this.result = result;
	}
}
