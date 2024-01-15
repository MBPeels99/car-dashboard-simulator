package application;

public abstract class FuelSystem{

    private double capacity;
    @SuppressWarnings("unused")
	private double consumptionRate;

    public FuelSystem(double capacity, double consumptionRate) {
        this.capacity = capacity;
        this.consumptionRate = consumptionRate;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public void setConsumptionRate(double consumptionRate) {
        this.consumptionRate = consumptionRate;
    }

    public abstract void consumeFuel(double fuelConsumptionRate);
    
    protected abstract FuelSystem getFuelSystem();

	protected abstract void setFuelLevel(double d);

	protected abstract double getFuelLevel();
	
	protected abstract double getConsumptionRate(double speed);
	
	protected abstract String getType();
}