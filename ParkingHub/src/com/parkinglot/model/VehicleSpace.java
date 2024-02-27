package com.parkinglot.model;

public class VehicleSpace {
	
	private int spaceNumber;
	private boolean availability;
	private VehicleType type;
	
	
	public VehicleSpace(int spaceNumber, boolean availability, VehicleType type) {
		super();
		this.spaceNumber = spaceNumber;
		this.availability = availability;
		this.type = type;
	}

	public int getSpaceNumber() {
		return spaceNumber;
	}

	public void setSpaceNumber(int spaceNumber) {
		this.spaceNumber = spaceNumber;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}
	
	

}
