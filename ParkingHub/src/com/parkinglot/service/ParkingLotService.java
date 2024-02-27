package com.parkinglot.service;

import java.util.HashMap;
import java.util.Map;

import com.parkinglot.model.ParkingLot;
import com.parkinglot.model.Vehicle;
import com.parkinglot.model.VehicleType;

public class ParkingLotService {
	
	public static void main(String[] args) {
		//initializing 
		ParkingLot parkingLot = initializeParkingLot();
		
		//testing
		testParkingLot(parkingLot);
		
		
	}
	

	private static ParkingLot initializeParkingLot() {
		int numberOfFloors = 2;
		
		//Capacity per type for each floor
		Map<VehicleType, Integer> capacityPerType = new HashMap<>();
		capacityPerType.put(VehicleType.CAR, 6);
		capacityPerType.put(VehicleType.SPORTSCAR, 3);
		capacityPerType.put(VehicleType.TRUCK, 1);
		capacityPerType.put(VehicleType.BUS, 2);
		
		
		// Hourly rates for each Vehicle type
		Map<VehicleType, Integer> rates = new HashMap<>();
		rates.put(VehicleType.CAR, 20);
		rates.put(VehicleType.SPORTSCAR, 20);
		rates.put(VehicleType.BUS, 30);
		rates.put(VehicleType.TRUCK, 30);
		
		return new ParkingLot(numberOfFloors, capacityPerType, rates);
	}
	
	
	
	private static void testParkingLot(ParkingLot parkingLot) {
	
		//Add Vehicles
		
		Vehicle car = new Vehicle("CR11", "Black", VehicleType.CAR);
		parkingLot.addVehicle(car);
		
		Vehicle sportsCar = new Vehicle("SC11", "Red", VehicleType.SPORTSCAR);
		parkingLot.addVehicle(sportsCar);
		
		Vehicle bus = new Vehicle("BS11", "Blue", VehicleType.BUS);
		parkingLot.addVehicle(bus);
		
		Vehicle truck = new Vehicle("TR11", "Yellow", VehicleType.TRUCK);
		parkingLot.addVehicle(truck);
		
		
		//Remove Vehicle
		parkingLot.removeVehicle("BS11");
		
		
		//Check Availability for Car on floor 1
		parkingLot.checkAvailability(1, VehicleType.CAR);
		
		
		//Add sports car again
		Vehicle sportsCar1 = new Vehicle("SC22", "Grey", VehicleType.SPORTSCAR);
		parkingLot.addVehicle(sportsCar1);

		
	}

}
