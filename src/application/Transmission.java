package application;

public abstract class Transmission {
    @SuppressWarnings("unused")
	private int currentGear;

    public Transmission() {
        this.currentGear = 1;
    }

    public abstract void shiftUp();

    public abstract void shiftDown();

    public abstract int getCurrentGear() ;

    protected void setCurrentGear(int currentGear) {
        this.currentGear = currentGear;
    }
    
    protected abstract String getType();

	protected abstract double getCurrentGearRatio();
}

