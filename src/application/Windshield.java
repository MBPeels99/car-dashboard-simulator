package application;

public class Windshield{

    private static int wiperSpeed;

    public Windshield() {
        super();
        wiperSpeed = 0;
    }

    public void turnOnWipers(int speed) {
        wiperSpeed = speed;
        System.out.println("Windshield wipers turned on at speed " + speed);
    }

    public void turnOffWipers() {
        wiperSpeed = 0;
        System.out.println("Windshield wipers turned off");
    }

    public int getWiperSpeed() {
        return wiperSpeed;
    }

    public void setWiperSpeed(int wiper_speed) {
        wiperSpeed = wiper_speed;
    }

    public void status() {
        System.out.println("Windshield status:");
        System.out.println("- Wiper speed: " + wiperSpeed);
    }
}
