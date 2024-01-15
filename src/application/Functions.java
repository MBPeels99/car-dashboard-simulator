package application;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.lang.Math;

public class Functions {
	private Car car;
	private ExecutorService executorService;
	
	public Functions(Car car) {
        this.car = car;
        this.executorService = Executors.newFixedThreadPool(4); // Creates a thread pool with 4 threads
    }
	
	 public Future<Double> calculateFuelConsumptionRateAsync(double speed) {
	        Callable<Double> task = () -> {
	            return calculateFuelConsumptionRate(speed);
	        };
	        return executorService.submit(task);
	    }
	 
	 public Future<Double> calculateRPMAsync() {
	        Callable<Double> task = () -> {
	            return calculateRPM();
	        };
	        return executorService.submit(task);
	    }
	 
	 public Future<Double> calculateSpeedAsync() {
	        Callable<Double> task = () -> {
	            return calculateSpeed();
	        };
	        return executorService.submit(task);
	    }
	 
	 public Future<Double> calculateHPAsync() {
	        Callable<Double> task = () -> {
	            return calculateHorsepower();
	        };
	        return executorService.submit(task);
	    }
	
	 public double calculateFuelConsumptionRate(double speed) {
	    // Get the base fuel consumption rate from the fuel system
	    double fuelConsumptionRate = 0;
	    if(car.getUserInteractibles().getGasPedal().isPressed(car)) {
	    	fuelConsumptionRate = car.getFuelSystem().getConsumptionRate(speed);
	    }
	
	    // Check if the headlights are on and increase fuel consumption rate accordingly
	    if (car.getUserInteractibles().getElectricalSystem().areHeadlightsOn()) {		
	        fuelConsumptionRate += 0.001; // Increase fuel consumption rate by 0.1 L/km
	    }
	    
	    // Check if the windshield wipers are on and increase fuel consumption rate accordingly
	    if (car.getUserInteractibles().getWindshield().getWiperSpeed() != 0) {
	        fuelConsumptionRate += 0.002 * car.getUserInteractibles().getWindshield().getWiperSpeed();
	    }
	    
	    // Check if the radio system is on and increase fuel consumption rate accordingly
	    if (car.getUserInteractibles().getRadioSystem().isOn()) {
	        fuelConsumptionRate += 0.005; // Increase fuel consumption rate by 0.05 L/km
	    }
	    
	    // Return the final fuel consumption rate
	    return fuelConsumptionRate;
	}
	 
	 public double calculateTorque(){
		 double torque;
		 torque = (-0.55 * car.getSpeed().getCurrentSpeed()) + car.getTorque();
		 return torque;
		 
	 }
	
	public double calculateRPM() {
		double gearRatio = car.getTransmission().getCurrentGearRatio();
		double fixedFinalDriveRatio = 3.73; // Fixed final drive ratio value
		double fixedTireDiameter = car.getTire_diameter()/2.54; // Fixed tire diameter value
		double rpm = ((car.getSpeed().getCurrentSpeed()/1.609) * gearRatio * fixedFinalDriveRatio * 336) / fixedTireDiameter;
		    
		return rpm;
	}	
	
	public double calculateHorsepower() {
		double torque = calculateTorque();
	    double rpm = calculateRPM();
	    double horsepower = (rpm * torque) / 525.2;
		return horsepower;
		
	}
		
	public double calculateSpeed() {
	    double horsepower = calculateHorsepower();
	    double finalDriveRatio = 3.73;
	    double gearRatio = car.getTransmission().getCurrentGearRatio();

	    // Calculate the acceleration factor based on the car's properties
	    double accelerationFactor = (Math.pow(((horsepower * 746.0) / 0.275), 1.0 / 3.0) * Math.pow(((2.0 * car.getWeight() * 2.205 / (1.2 * (car.getHeight() * car.getWidth() / (2.54 * 2.54))))), 1.0 / 6.0)) / (gearRatio * finalDriveRatio);

	    // Add a speed modifier constant between 0 and 1 to reduce the acceleration factor
	    double speedModifier = 0.005; // Adjust this value to control the acceleration
	    accelerationFactor *= speedModifier;

	    // Return the acceleration factor
	    return accelerationFactor;
	}
	
	public void shutdown() {
        executorService.shutdown();
    }
}
