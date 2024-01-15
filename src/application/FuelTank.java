package application;

public class FuelTank extends FuelSystem {
	
	private double fuelConsumptionRate;
    private double fuelLevel;

    public FuelTank(double capacity, double fuelConsumptionRate) {
        super(capacity, fuelConsumptionRate);
        this.fuelLevel = capacity;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    @Override
    public void consumeFuel(double amount) {
        if (fuelLevel >= amount) {
            fuelLevel -= amount;
        } else {
            fuelLevel = 0;
        }
    }

	@Override
	public void setConsumptionRate(double rate) {
		this.fuelConsumptionRate = rate;
		
	}

	@Override
	protected double getConsumptionRate(double speed) {
		if (speed <= 60) {
            fuelConsumptionRate += 0.0000005; // Increase fuel consumption rate by 0.05 L/km if speed <= 60 km/h
        } else if (speed > 60 && speed <= 100) {
            fuelConsumptionRate += 0.0000008; // Increase fuel consumption rate by 0.08 L/km if speed <= 100 km/h
        } else if(speed > 100){
            fuelConsumptionRate += 0.000001; // Increase fuel consumption rate by 0.1 L/km if speed > 100 km/h
        }
        
        return fuelConsumptionRate;
	}

	@Override
	protected String getType() {
		return "Fuel";
	}

	@Override
	protected FuelSystem getFuelSystem() {
		return this;
	}
}
