# ParkingHub
This Java project implements a simple parking lot system. The system is designed to manage different types of vehicles across multiple floors. It supports functionalities such as adding vehicles, removing vehicles, and checking availability based on a configurable cost strategy.

## Project Structure
The project is organized into the following packages:

Model Package: Contains the core classes for modeling the parking lot system, including CostStrategy, Floor, ParkingLot, Vehicle, and VehicleSpace.

Service Package: Contains the ParkingService class with the main method that demonstrates the usage of the parking lot system.

## Usage
### 1.Initialization:
The parking lot is initialized with a given number of floors and capacity per floor for each vehicle type.
Hourly rates for parking are also configured based on vehicle types.

### 2.Adding Vehicles:
Vehicles of different types (Car, Sports Car, Truck, Bus) can be added to the parking lot.
The system assigns a space to each vehicle based on availability.

### 3.Removing Vehicles:
Vehicles can be removed from the parking lot by providing their registration number.

### 4.Checking Availability:
Availability of parking spaces on a specific floor for a given vehicle type can be checked.
