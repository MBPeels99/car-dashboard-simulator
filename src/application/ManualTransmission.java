package application;

public class ManualTransmission extends Transmission {
	static int currentGear = 1;
	private double[] gearRatios = {3.45, 2.08, 1.41, 1.00, 0.77, 0.63};
   
    public ManualTransmission() {
        super();
        currentGear = 1;
    }
    
    public double getCurrentGearRatio() {
        return gearRatios[currentGear - 1];
    }

    @Override
    public void shiftUp() {
        if (currentGear < 6) {
        	currentGear = currentGear + 1;
        }
    }

    @Override
    public void shiftDown() {
        if (currentGear > 1) {
            currentGear = currentGear - 1;
        } 
    }

	@Override
	protected String getType() {
		return "Manual";
	}

	@Override
	public int getCurrentGear() {
		// TODO Auto-generated method stub
		return currentGear;
	}
}