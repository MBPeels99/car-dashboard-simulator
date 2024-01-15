package application;

public class InternalCombustionEngine extends Engine {
    private String engine_type;
    private int horsepower;

    public InternalCombustionEngine(int horsepower) {
        super(horsepower);
        this.engine_type = "Conbustion  Engine";
    }

    @Override
    public void start() {
        System.out.println("Starting internal combustion engine");
        
    }

    @Override
    public void stop() {
        System.out.println("Stopping internal combustion engine");
    }

    public int getHorsePower(){
        return horsepower;
    }

	@Override
	public String getEngineType() {
		return engine_type;		
	}
}
