package application;

public class ElectricalSystem {

    private static boolean headlightsOn = false;

    public ElectricalSystem() {
        super();
        headlightsOn = false;
    }

    public boolean areHeadlightsOn() {
        return headlightsOn;
    }

    public void turnOnHeadlights() {
        headlightsOn = true;
    }

    public void turnOffHeadlights() {
        headlightsOn = false;
    }

    public void status() {
        System.out.println("Electrical system status:");
        System.out.println("- Headlights on: " + headlightsOn);
    }
}
