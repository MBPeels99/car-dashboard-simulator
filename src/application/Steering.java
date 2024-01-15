package application;

public class Steering{
 
    private String name;
    private String cardinal_direction;
    private int direction;

    public Steering() {
    	cardinal_direction = "North";
        this.direction = 90;
    }

    public String getDirection() {
        return cardinal_direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
    
    public void updateDirection(int direction) {
    	int new_direction = direction + this.direction;
    	if(new_direction == 90 || new_direction == 540 || new_direction == -270) {
        	cardinal_direction = "North";
        	direction = 90;
        } else if (new_direction == 180 || new_direction == -180) {
        	cardinal_direction = "West";
        } else if (new_direction == 0) {
        	cardinal_direction = "East";
        } else if (new_direction == -90 || new_direction == 270) {
        	cardinal_direction = "South";
        }
    }

    public String getName() {
        return name;
    }

    public  void turnLeft(int degrees) {
    	
    }

    public void turnRight(int degrees) {
    	
    }

    public void status() {
        System.out.println("Steering status:");
        System.out.println("- Direction: " + this.direction);
    }
}
