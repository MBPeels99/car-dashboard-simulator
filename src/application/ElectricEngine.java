package application;

public class ElectricEngine extends Engine {
    private int horsepower;

    public ElectricEngine(int horsepower) {
        super(horsepower);
        this.setHorsepower(horsepower);
    }

    @Override
    public void start() {
        System.out.println("Starting electric engine");
    }

    @Override
    public void stop() {
        System.out.println("Stopping electric engine");
    }

	@Override
	public String getEngineType() {
		return "Electric Engine";
	}

	public int getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}
    
    
}