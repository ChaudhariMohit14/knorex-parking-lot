package com.parkinglot.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Floor {
	
	private int floorNumber;
	private Map<VehicleType, Integer> capacityPerType;
	private Map<VehicleType, List<VehicleSpace>> vehicleSpacesPerType;
	
	
	public Floor(int floorNumber, Map<VehicleType, Integer> capacityPerType) {
		super();
		this.floorNumber = floorNumber;
		this.capacityPerType = capacityPerType;
		this.vehicleSpacesPerType = new HashMap<>();
		initializeSpaces();
	}


	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public Map<VehicleType, Integer> getCapacityPerType() {
		return capacityPerType;
	}

	public void setCapacityPerType(Map<VehicleType, Integer> capacityPerType) {
		this.capacityPerType = capacityPerType;
	}
	
	
	public Map<VehicleType, List<VehicleSpace>> getVehicleSpacesPerType() {
		return vehicleSpacesPerType;
	}


	public void setVehicleSpacesPerType(Map<VehicleType, List<VehicleSpace>> vehicleSpacesPerType) {
		this.vehicleSpacesPerType = vehicleSpacesPerType;
	}


	private void initializeSpaces() {
		for(VehicleType type : capacityPerType.keySet()) {
			int capacity = capacityPerType.get(type);
			List<VehicleSpace> spaces = new ArrayList<>(capacity);
			
			for(int i=0; i<capacity; i++) {
				spaces.add(new VehicleSpace(i, true, type));
			}
			
			vehicleSpacesPerType.put(type, spaces);
		}
	}
	
	
	

}
