package application;

public abstract class Engine {
    private int horsepower;

    public Engine(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getHorsepower() {
        return horsepower;
    }
    
    public abstract String getEngineType();
    
    public abstract void start();

    public abstract void stop();
}
