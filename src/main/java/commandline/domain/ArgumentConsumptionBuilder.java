package commandline.domain;

public class ArgumentConsumptionBuilder {
	private boolean no_arguments = false;
	private boolean toggle_value = false;
	private boolean single_argument = false;
	private boolean until_delimiter = false;
	private boolean all_available = false;
	private boolean sub_set = false;
	private String delimiter = null;
	private Class<? extends Object> subsetClass = null; 
	
	public void addNoArgs(boolean value) {
		no_arguments = true;
		this.toggle_value = value;
	}
	
	public void addSingleArgument() {
		single_argument = true;
	}
	
	public void addUntilDelimiter(String delimiter) {
		until_delimiter = true;
	}
	
	public void addAllAvailable() {
		all_available = true;
	}
	
	public void addSubSet(Class subsetClass) {
		this.subsetClass = subsetClass;
	}
	
	public ArgumentConsumption getArgumentConsumption() {
		int argumentConsumptionTypeCounter = 0;
		if (single_argument) argumentConsumptionTypeCounter++;
		if (until_delimiter) argumentConsumptionTypeCounter++;
		if (all_available) argumentConsumptionTypeCounter++;
		if (sub_set) argumentConsumptionTypeCounter++;
		if (argumentConsumptionTypeCounter == 0) {
			throw new InvalidOptionSpecificationException("No argument consumption type specified");
		}
		if (argumentConsumptionTypeCounter > 1) {
			throw new InvalidOptionSpecificationException("Multiple argument consumption types specified");
		}
		
		if (no_arguments) {
			return new ArgumentConsumption(ArgumentConsumptionType.NO_ARGS, toggle_value);
		}
		if (single_argument) {
			return new ArgumentConsumption(ArgumentConsumptionType.SINGLE_ARGUMENT);
		}
		if (until_delimiter) {
			return new ArgumentConsumption(ArgumentConsumptionType.UNTIL_DELIMITER, delimiter);
		}
		if (all_available) {
			return new ArgumentConsumption(ArgumentConsumptionType.ALL_AVAILABLE);
		}
		if (sub_set) {
			return new ArgumentConsumption(ArgumentConsumptionType.SUB_SET,subsetClass);
		}
		throw new RuntimeException("Internal error: no matching argument consumption types");
	}
	
}
