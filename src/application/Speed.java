package application;

public class Speed {
    private static double currentSpeed;
    private double maxSpeed;

    public Speed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
        currentSpeed = 0;
    }

    public double getCurrentSpeed() {
    	if(currentSpeed == 0) {
    		return currentSpeed = 1;
    	} else {
    		return currentSpeed;
    	}
    }

    public void setCurrentSpeed(double current_Speed) {
        currentSpeed = current_Speed;
    }
    
    public double getMaxSpeed() {
    	return maxSpeed;
    }
}