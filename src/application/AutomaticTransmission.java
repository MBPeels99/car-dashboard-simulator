package application;

public class AutomaticTransmission extends Transmission {
	
	static int currentGear = 1;
	private double[] gearRatios = {3.45, 2.08, 1.41, 1.00, 0.77, 0.63};
	
	public AutomaticTransmission() {
		super();
	}
	
	@Override
	public double getCurrentGearRatio() {
        return gearRatios[currentGear - 1];
    }
	
	@Override
	public void shiftUp() {
		//currentGear = getCurrentGear(); // get the current gear
		if (currentGear < 6) { // if the current gear is less than 6
			setCurrentGear(currentGear + 1); // shift up to the next gear
		} else if(currentGear == 6){
			setCurrentGear(6);
		}
	}
	
	@Override
	public void setCurrentGear(int current_gear) {
		currentGear = current_gear;
	}
	
	@Override
	public void shiftDown() {
		currentGear = getCurrentGear(); // get the current gear
		if (currentGear > 1) { // if the current gear is greater than 1
			setCurrentGear(currentGear - 1); // shift down to the previous gear
		}
	}
	
	@Override
	protected String getType() {
		return "Automatic";
	}

	@Override
	public int getCurrentGear() {
		// TODO Auto-generated method stub
		return currentGear;
	}
}