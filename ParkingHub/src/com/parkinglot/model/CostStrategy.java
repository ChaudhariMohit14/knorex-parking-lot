package com.parkinglot.model;

import java.util.Map;

public class CostStrategy {
	
	private Map<VehicleType, Integer> rates;

	public CostStrategy(Map<VehicleType, Integer> rates) {
		super();
		this.rates = rates;
	}

	public Map<VehicleType, Integer> getRates() {
		return rates;
	}

	public void setRates(Map<VehicleType, Integer> rates) {
		this.rates = rates;
	}
	
	
	
	public int calculateAmount(VehicleType type, int hours) {
		return rates.get(type)*hours;
	}

}
