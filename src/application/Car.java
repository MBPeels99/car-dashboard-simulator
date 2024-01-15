package application;


public abstract class Car extends Vehicle {
    
	private Engine engine;
    private UserInteractibles userInteractibles;
    private int over6000Count;
	private boolean isOn = false;
	private int horsepower;
	private int top_speed;
	private double weight;
	private double width;
	private double height;
	private double tire_diameter;
	private int torque;
	
	public Car(int horsepower, int torque, int top_speed, double weight, double width, double height, double tire_diameter, int capacity, double consumption_rate) {
		this.horsepower = horsepower;
		this.top_speed = top_speed;
		this.height = height;
		this.weight = weight;
		this.width = width;
		this.tire_diameter = tire_diameter;
		this.userInteractibles = new UserInteractibles();
		this.torque = torque;
	}

    abstract public Transmission getTransmission() ;
    
    public void getTest() {
    	System.out.println("Test");
    }

    public UserInteractibles getUserInteractibles() {
        return this.userInteractibles;
    }

	public void stop() {
	    this.isOn = false;
	    System.out.println("Car is now off");
	}

	public void stopCar() {
	    if (this.isOn) {
	        this.engine.stop();
	        System.out.println("Car stopped");
	    } else {
	        System.out.println("Cannot stop car, car is not turned on.");
	    }
	}

	public void setOver6000Count(int over6000Count) {
		this.over6000Count = over6000Count;
	}

	public int getOver6000Count() {
		return over6000Count;
	}

	public boolean isOn() {
		return this.isOn;
	}
	
	public void setIsOn() {
		this.isOn = true;
	}

	public int getHorsepower() {
		return horsepower;
	}

	public int getTop_speed() {
		return top_speed;
	}

	public double getWeight() {
		return weight;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public double getTire_diameter() {
		return tire_diameter;
	}

	public int getTorque() {
		return torque;
	}

	protected abstract FuelSystem getFuelSystem();
	
	protected void start() {
	    this.isOn  = true;
	    System.out.println("Car is now on");
	}

	protected abstract Speed getSpeed();
}
