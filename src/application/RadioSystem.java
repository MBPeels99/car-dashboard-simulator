package application;

public class RadioSystem{
    private boolean isOn;
    private int volume;
    private String station;
    private String[] radio_stations = {"94.7","104.2","92.4"}; 

    public RadioSystem() {
        super();
        this.isOn = false;
    }

    public boolean isOn() {
        return this.isOn;
    }

    public void turnOn() {
        this.isOn = true;
    }

    public void turnOff() {
        this.isOn = false;
    }

    public void increaseVolume() {
        if (this.isOn && this.volume < 20) {
            this.volume++;
            System.out.println("Volume increased to " + this.volume);
        }
    }

    public void decreaseVolume() {
        if (this.isOn && this.volume > 0) {
            this.volume--;
            System.out.println("Volume decreased to " + this.volume);
        }
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return this.volume;
    }

    public void setStation(String station) {
        if (this.isOn) {
            this.station = station;
            System.out.println("Set station to " + station);
        } else {
            System.out.println("Radio is off");
        }
    }
    
    public void setStation1() {
    	this.station = radio_stations[0];
    }
    
    public void setStation2() {
    	this.station = radio_stations[1];
    }
    
    public void setStation3() {
    	this.station = radio_stations[2];
    }

    public String getStation() {
        return this.station;
    }

    public Boolean getStatus() {
        if (isOn()) {
            return true;
        } else {
            return false;
        }
    }

    public void status() {
        System.out.println("Radio system status:");
        System.out.println("- Is on: " + this.isOn());
    }
}
