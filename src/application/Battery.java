package application;

public class Battery extends FuelSystem {

    private static double chargeLevel;
    private static double batteryConsumptionRate;

    public Battery(double capacity, double consumptionRate) {
        super(capacity, consumptionRate);
        //batteryConsumptionRate = consumptionRate;
        chargeLevel = capacity;
    }

    @Override
    public void consumeFuel(double amount) {
        if (chargeLevel >= amount) {
            chargeLevel -= amount;
        } else {
            chargeLevel = 0;
        }
    }

    @Override
    public void setFuelLevel(double charge_Level) {
        chargeLevel = charge_Level;
    }

    @Override
    public double getFuelLevel() {
        return chargeLevel;
    }

    @Override
    public double getConsumptionRate(double speed) {        
        if (speed <= 60) {
        	batteryConsumptionRate = batteryConsumptionRate + 0.0000005; // Increase fuel consumption rate by 0.06 L/km if speed <= 60 km/h
        } else if (speed > 60 && speed <= 100) {
        	batteryConsumptionRate = batteryConsumptionRate + 0.0000008; // Increase fuel consumption rate by 0.085 L/km if speed <= 100 km/h
        } else if(speed > 100){
        	batteryConsumptionRate = batteryConsumptionRate + 0.000001; // Increase fuel consumption rate by 0.15 L/km if speed > 100 km/h
        }

        return batteryConsumptionRate;
    }

    @Override
	public void setConsumptionRate(double rate) {
        batteryConsumptionRate = rate;
    }

    @Override
    public String getType() {
        return "Battery";
    }

	@Override
	protected FuelSystem getFuelSystem() {
		return this;
	}
}