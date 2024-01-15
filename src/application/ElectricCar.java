package application;

public class ElectricCar extends Car {

	private Engine engine;
    private FuelSystem battery;
    private Speed speed;
    private Transmission transmission;

    public ElectricCar(int horsepower, int torque, int top_speed, double weight, double width, double height, double tire_diameter, int capacity, double consumption_rate) {
        super(horsepower, torque, top_speed, weight, width, height, tire_diameter, capacity, consumption_rate);
        this.engine = new ElectricEngine(horsepower);
        this.battery = new Battery(capacity, consumption_rate);
        this.speed = new Speed(top_speed);
        this.transmission = new AutomaticTransmission();
    }
    
    public FuelSystem getBattery() {
        return this.battery;
    }

    public void rechargeBattery(double amount) {
        double newChargeLevel = this.battery.getFuelLevel() + amount;
        if (newChargeLevel > this.battery.getCapacity()) {
            this.battery.setFuelLevel(this.battery.getCapacity());
            System.out.println("Battery fully charged.");
        } else {
            this.battery.setFuelLevel(newChargeLevel);
            System.out.println("Battery charged.");
        }
    }

    @Override
    public void start() {
        if (this.battery.getFuelLevel() >= 20) {
            super.start();
        } else {
            System.out.println("Battery level too low. Cannot start engine.");
        }
    }
    
    @Override
    public void stop() {
    	super.stop();
    	System.out.println("Turning off electric engine");
    }

	public Engine getEngine() {
		return engine;
	}

	protected FuelSystem getFuelSystem() {
		return this.battery;
	}

	@Override
	protected Speed getSpeed() {
		return speed;
	}

	@Override
	public Transmission getTransmission() {
		return transmission;
	}
}
