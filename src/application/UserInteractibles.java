package application;

public class UserInteractibles{

    private RadioSystem radioSystem;
    private Steering steering;
    private Windshield windshield;
    private ElectricalSystem electricalSystem;
	private GasPedal gasPedal;
	private BrakePedal brakePedal;

	public UserInteractibles() {
	    this.gasPedal = new GasPedal();
	    this.brakePedal = new BrakePedal();
	    this.electricalSystem = new ElectricalSystem();
	    this.windshield = new Windshield();
	    this.radioSystem = new RadioSystem();
	    this.steering = new Steering();
	}

    public void turnRadioOn() {
        if (this.radioSystem != null) {
            this.radioSystem.turnOn();
        }
    }

    public void turnRadioOff() {
        if (this.radioSystem != null) {
            this.radioSystem.turnOff();
        }
    }

    public void increaseVolume() {
        if (this.radioSystem != null) {
            this.radioSystem.increaseVolume();
        }
    }

    public void decreaseVolume() {
        if (this.radioSystem != null) {
            this.radioSystem.decreaseVolume();
        }
    }

    public void setRadioStation(String station) {
        if (this.radioSystem != null) {
            this.radioSystem.setStation(station);
        }
    }

    public void setWiperSpeed(int speed) {
        if (this.windshield != null)
            this.windshield.setWiperSpeed(speed);
            }

    public void turnWipersOn(int speed) {
       if (this.windshield != null) {
           this.windshield.turnOnWipers(speed);
       }
    }

        public void turnWipersOff() {
            if (this.windshield != null) {
                this.windshield.turnOffWipers();
            }
        }

        public RadioSystem getRadioSystem() {
            return this.radioSystem;
        }

        public Windshield getWindshield() {
            return this.windshield;
        }
        
        public Steering getSteering() {
        	return this.steering;
        }

		public GasPedal getGasPedal() {
			return gasPedal;
		}

		public BrakePedal getBrakePedal() {
			return brakePedal;
		}

		public ElectricalSystem getElectricalSystem() {
			return electricalSystem;
		}

		public void setElectricalSystem(ElectricalSystem electricalSystem) {
			this.electricalSystem = electricalSystem;
		}
}
