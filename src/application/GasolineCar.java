package application;

public class GasolineCar extends Car {
    public FuelSystem fuelTank;
	private Engine engine;
	private Speed speed;
	private Transmission transmission;
	private boolean isOn = false;

    public GasolineCar(Transmission transmission, int horsepower, int torque, int top_speed, double weight, double width, double height, double tire_diameter, int capacity, double consumption_rate) {
        super(horsepower, torque, top_speed, weight, width, height, tire_diameter, capacity, consumption_rate);
        this.engine = new InternalCombustionEngine(horsepower);
        this.fuelTank = new FuelTank(capacity, consumption_rate);
        this.setSpeed(new Speed(top_speed));
        this.transmission = transmission;
    }
    
    public void refuel(double amount) {
        double capacity = this.fuelTank.getCapacity();
        double currentFuelLevel = this.fuelTank.getFuelLevel();
        if ((currentFuelLevel + amount) > capacity) {
            this.fuelTank.setFuelLevel(capacity);
        } else {
            this.fuelTank.setFuelLevel(currentFuelLevel + amount);
        }
    }
    
    public FuelSystem getFuelSystem() {
    	return this.fuelTank;
    }

    public void consumeFuel(int amount) {
        this.fuelTank.consumeFuel(amount);
    }

    @Override
    public void start() {
        System.out.println("Starting gasoline car");
        super.start();
    }

    @Override
    public void stop() {
        System.out.println("Stopping gasoline engine");
        super.stop();
    }

	public Engine getEngine() {
		return engine;
	}

	public Speed getSpeed() {
		return speed;
	}

	public void setSpeed(Speed speed) {
		this.speed = speed;
	}
	
	@Override
	public Transmission getTransmission() {
		return transmission;
	}

	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}
}
