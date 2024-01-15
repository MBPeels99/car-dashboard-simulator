package application;

public class GasPedal {
	
	private static boolean isPressed = false;
	
    public GasPedal() {
        super();
    }
    
    public void pressGas() {
    	isPressed = true;
    }
    
    public void releaseGas() {
    	isPressed = false;
    }

    public boolean isPressed(Car car) {
    	return isPressed;
    }
}