package application;

import java.util.List;
import java.util.ArrayList;

public class DistanceDriven {
	private double distance; // the distance driven by the vehicle
	private String direction; // the direction in which the vehicle is heading
	private List<Steering> turnHistory; // list of Steering objects representing the history of turns made by the vehicle

	public DistanceDriven() {
		this.distance = 0;
		this.direction = "North";
		this.turnHistory = new ArrayList<Steering>();
	}

	public String getDirection() {
		return this.direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	public void addDistance(double distance) {
		this.distance += distance;
	}

	public double getDistance() {
		return this.distance;
	}

	public void recordTurn(Steering turn) {
		this.turnHistory.add(turn);
	}

	public List<Steering> getTurnHistory() {
		return this.turnHistory;
	}
}
