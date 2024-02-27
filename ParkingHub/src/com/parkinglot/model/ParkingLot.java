package com.parkinglot.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingLot {
	
	private List<Floor> floors;
	private CostStrategy costStrategy;
	
	public ParkingLot(int numberOfFloors, Map<VehicleType, Integer> capacityPerType, Map<VehicleType, Integer> rates) {
		super();
		this.floors = new ArrayList<>(numberOfFloors);
		initializeFloors(numberOfFloors, capacityPerType);
		this.costStrategy = new CostStrategy(rates);
	}
	
	
	private void initializeFloors(int numberOfFloors, Map<VehicleType, Integer> capacityPerType) {
		for(int i=1; i<=numberOfFloors; i++) {
			floors.add(new Floor(i, capacityPerType));
		}
	}
	
	
	public boolean addVehicle(Vehicle vehicle) {
		for(Floor floor : floors) {
			if(addVehicleToFloor(floor, vehicle)) {
				return true;
			}
		}
		System.out.println("Parking Lot is Full, No Space to Park on the floor");
		return false;
	}


	private boolean addVehicleToFloor(Floor floor, Vehicle vehicle) {
		Map<VehicleType, List<VehicleSpace>> spacesPerType = floor.getVehicleSpacesPerType();
		
		VehicleType vehicleType = vehicle.getType();
		
		if(spacesPerType.containsKey(vehicleType)) {
			List<VehicleSpace> spaces = spacesPerType.get(vehicleType);
			
			for(VehicleSpace space : spaces) {
				if(space.isAvailability()) {
					space.setAvailability(false);
					
					System.out.println("Vehicle added to the floor "+ floor.getFloorNumber() + ", space number " + space.getSpaceNumber());
					return true;
				}
			}
		}
		
		
		return false;
	}
	
	
	public void removeVehicle(String registrationNumber) {
		for(Floor floor: floors) {
			Map<VehicleType , List<VehicleSpace>> spacesPerType = floor.getVehicleSpacesPerType();
			
			for(List<VehicleSpace> spaces : spacesPerType.values()) {
				for(VehicleSpace space : spaces) {
					if(!space.isAvailability()) {
						space.setAvailability(true);
						System.out.println("Vehicle with registration number " + registrationNumber + " removed");
						return;
					}
				}
			}
		}
		
		System.out.println("No Vehicle Found");
	}
	
	
	public boolean checkAvailability(int floorNumber, VehicleType vehicleType) {
		if(floorNumber>0 && floorNumber<=floors.size()) {
			Floor floor = floors.get(floorNumber);
			
			Map<VehicleType, List<VehicleSpace>> spacesPerType = floor.getVehicleSpacesPerType();
			
			if(spacesPerType.containsKey(vehicleType)) {
				for(VehicleSpace space : spacesPerType.get(vehicleType)){
					if(space.isAvailability()) {
						System.out.println("Space is available for "+ vehicleType + " on floor "+ floorNumber);
						return true;
					}
				}
			}
		}
		System.out.println("No Space available for "+ vehicleType + " on floor "+ floorNumber);
		return false;
	}
	
	
	
	
	

}
