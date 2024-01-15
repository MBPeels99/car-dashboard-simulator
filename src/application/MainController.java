package application;

import eu.hansolo.medusa.Gauge;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class MainController extends StartScreenController implements Initializable {

    @FXML 	private 	Gauge 		gaugeSpeed;
    @FXML 	private 	Gauge 		fuel_gauge;
    @FXML 	private 	Gauge 		guage_rpm;
    
    @FXML 	private 	ImageView 	steer_wheel;
    @FXML 	private 	ImageView 	power_btn_img_view;
    @FXML 	private 	ImageView 	head_light_img_view;
    @FXML 	private 	ImageView 	windscreen_wiper_img_view;
    @FXML 	private 	ImageView 	gear_icon_img_view;
    @FXML	private		ImageView	shift_up_img_view;
    @FXML	private		ImageView	shift_down_img_view;
    @FXML	private		ImageView	left_indicator_img_view;
    @FXML	private		ImageView	right_indicator_img_view;
    
    
    @FXML 	private 	AnchorPane 	anchorpane;
    
    @FXML 	private 	Button 		power_btn;
    @FXML 	private 	Button 		light_btn;
    @FXML 	private 	Button 		windscreen_btn;

    static 	private 	int 		steer_angle = 0;
    static 	private 	double 		speed;
    static 	private 	double 		fuel_level = 0;
    static 	private 	double 		consume_rate = 0;
    static 	private 	boolean 	drive_started = false;

    private Map<KeyCode, Boolean> keyStateMap = new HashMap<>();

    Functions functions = new Functions(car);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupGauges();
        setupImages();
        setupPowerButton();
        handleKeyHeld();
        setupHeadlightButton();
        setupWindscreenButton();
    }

    private void setupGauges() {
        car.getTest();
        gaugeSpeed.setMaxValue(220);

        fuel_gauge.setValue(car.getFuelSystem().getFuelLevel());
    }

    private void setupImages() { 
    	
        shift_up_img_view.setVisible(false);
        shift_down_img_view.setVisible(false);
        head_light_img_view.setVisible(false);
        windscreen_wiper_img_view.setVisible(false);
        left_indicator_img_view.setVisible(false);
        right_indicator_img_view.setVisible(false);
        steer_wheel.setRotate(0);
    }

    private void setupPowerButton() {
        power_btn.setOnMouseClicked(e -> {
            if (!drive_started) {
                car.start();
                car.setIsOn();
                drive_started = true;
            } else {
                car.stop();
                drive_started = false;
            }
        });
    }
    
    private void setupHeadlightButton() {
    	light_btn.setOnMouseClicked(e->{
    		if(car.getUserInteractibles().getElectricalSystem().areHeadlightsOn()) {
    			car.getUserInteractibles().getElectricalSystem().turnOffHeadlights();
    			head_light_img_view.setVisible(false);
    		} else {
    			car.getUserInteractibles().getElectricalSystem().turnOnHeadlights();
    			head_light_img_view.setVisible(true);
    		}
    		car.getUserInteractibles().getElectricalSystem().status();
    		
    	});
    }

    private void setupWindscreenButton() {
    	windscreen_btn.setOnMouseClicked(e ->{
    		if(car.getUserInteractibles().getWindshield().getWiperSpeed() == 0) {
    			car.getUserInteractibles().getWindshield().turnOnWipers(1);
    			windscreen_wiper_img_view.setVisible(true);
    		} else {
    			car.getUserInteractibles().getWindshield().turnOffWipers();
    			windscreen_wiper_img_view.setVisible(false);
    		}
    	});
    }
    
    public void handleKeyHeld() {

        AnimationTimer keyHeldTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                handleKeyPresses();
                updateGauges();
                calculateHighRPM();
            }
        };

        keyHeldTimer.start();
    }

    private void handleKeyPresses() {
    	if(drive_started) {
	        if (keyStateMap.getOrDefault(KeyCode.W, false)) {
	            car.getUserInteractibles().getGasPedal().pressGas();
	            drive_started = true;
	
	            // Calculate the acceleration factor using the calculateSpeed() method
	            double accelerationFactor = functions.calculateSpeed();
	
	            // Update the speed based on the acceleration factor
	            speed += accelerationFactor;
	            car.getSpeed().setCurrentSpeed(speed);
	        } else {
	            handleGasPedalRelease();
	        }
    	}

        if (keyStateMap.getOrDefault(KeyCode.S, false)) {
            releaseGasAndSlowDown();
        }
        
        if(keyStateMap.getOrDefault(KeyCode.U, false)) {
        	car.getTransmission().shiftUp();
        	shift_up_img_view.setVisible(false);
        	try {
        	    Thread.sleep(1000); // wait for 2 seconds
        	} catch (InterruptedException e) {
        	    e.printStackTrace();
        	}
        }
        if(keyStateMap.getOrDefault(KeyCode.P, false)) {
        	car.getTransmission().shiftDown();
        	shift_down_img_view.setVisible(false);
        	try {
        	    Thread.sleep(1000); // wait for 2 seconds
        	} catch (InterruptedException e) {
        	    e.printStackTrace();
        	}
        	
        }

        handleSteering();
        try {
            Future<Double> futureConsumeRate = functions.calculateFuelConsumptionRateAsync(speed);
            consume_rate = futureConsumeRate.get();
            car.getFuelSystem().consumeFuel(consume_rate);
            fuel_level = car.getFuelSystem().getFuelLevel();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private void handleGasPedalRelease() {
        if (drive_started) {
            car.getUserInteractibles().getGasPedal().releaseGas();
            speed = car.getSpeed().getCurrentSpeed();
            speed *= 0.9975;
            car.getSpeed().setCurrentSpeed(speed);
            if (speed == 0) {
                drive_started = false;
            }
        }
    }

    private void releaseGasAndSlowDown() {
    	car.getUserInteractibles().getGasPedal().releaseGas();
    	speed = car.getSpeed().getCurrentSpeed();
    	speed *= 0.99;
    	car.getSpeed().setCurrentSpeed(speed);
    	}
    
    private void calculateHighRPM() {
    	if(car.getTransmission().getType() == "Automatic") {
    		double rpm = functions.calculateRPM();
    		System.out.println(rpm);
    		
    		if(drive_started) {
        		guage_rpm.setValue(rpm/1000.0);
        	} else {
        		guage_rpm.setValue(0);
        	}
    		if(guage_rpm.getValue() > 4.0) {
    			if(car.getTransmission().getCurrentGear() != 6) {
    				System.out.println(car.getTransmission().getCurrentGear());
        			car.getTransmission().shiftUp();
        		}
    		} else if(guage_rpm.getValue() < 1.0) {
    			if(car.getTransmission().getCurrentGear() > 1) {
    				car.getTransmission().shiftDown();
        		}
    		}
    	} else if(car.getTransmission().getType() == "Manual") {
    		double rpm = functions.calculateRPM()*10.0;
    		if(drive_started) {
        		guage_rpm.setValue(rpm/1000.0);
        	} else {
        		guage_rpm.setValue(0);
        	}
        	if(rpm > 3000 ) {
        		if(car.getTransmission().getCurrentGear() != 6) {
        			shift_up_img_view.setVisible(true);
        		}
        	} else if (rpm < 1000) {
        		if(car.getTransmission().getCurrentGear() > 1) {
        			shift_down_img_view.setVisible(true);
        		}
        	}
    	}
    }
    
    private void handleSteering() {
        if (keyStateMap.getOrDefault(KeyCode.A, false)) {
            steer_angle -= 1;
            steer_wheel.setRotate(steer_angle);
            left_indicator_img_view.setVisible(true);
        } else if (keyStateMap.getOrDefault(KeyCode.D, false)) {
            steer_angle += 1;
            steer_wheel.setRotate(steer_angle);
            right_indicator_img_view.setVisible(true);
        } else {
            steer_angle = 0;
            steer_wheel.setRotate(steer_angle);
            left_indicator_img_view.setVisible(false);
            right_indicator_img_view.setVisible(false);
        }
    }

    private void updateGauges() {
        if (speed > car.getSpeed().getMaxSpeed()) {
            gaugeSpeed.setValue(car.getSpeed().getMaxSpeed());
        } else {
            gaugeSpeed.setValue(car.getSpeed().getCurrentSpeed());
        }
        fuel_gauge.setValue((int) fuel_level);
    }
   
    @FXML
    public void handleKeyPressed(KeyEvent event) {
        keyStateMap.put(event.getCode(), true);
    }

    @FXML
    public void handleKeyReleased(KeyEvent event) {
        keyStateMap.put(event.getCode(), false);
    }
}
