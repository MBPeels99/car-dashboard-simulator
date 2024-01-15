package application;

public class BrakePedal {
	
	private static boolean isPressed = false;
	
    public BrakePedal() {
        super();
    }

    public void press(Car car) {
    	isPressed = true;
    	double speed = car.getSpeed().getCurrentSpeed();
        if (car.isOn()) {
        	if(speed <= 10.0) {
        		speed = 0;
        	} else {
        		speed = speed * 0.6;// Reduce speed by 40%
        	}
        	car.getSpeed().setCurrentSpeed(speed);// Set new speed
        } else {
            System.out.println("Cannot accelerate, car is not turned on.");
        }
    }

	protected boolean isPressed(Car car) {
		return isPressed;
	}
}
