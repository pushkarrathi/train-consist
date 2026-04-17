package org.example;

import java.util.*;

// Custom Checked Exception (UC14)
class InvalidCapacityException extends Exception {
public InvalidCapacityException(String message) {
	super(message);
}
}

// Custom Runtime Exception (UC15)
class CargoSafetyException extends RuntimeException {
public CargoSafetyException(String message) {
	super(message);
}
}

// Passenger Bogie
class Bogie {
String name;
int capacity;

Bogie(String name, int capacity) throws InvalidCapacityException {
	if (capacity <= 0) {
		throw new InvalidCapacityException("Capacity must be greater than zero");
	}
	this.name = name;
	this.capacity = capacity;
}

@Override
public String toString() {
	return name + " (Capacity: " + capacity + ")";
}
}

// Goods Bogie
class GoodsBogie {
String type;
String cargo;

GoodsBogie(String type) {
	this.type = type;
}

// Cargo assignment with safety validation
public void assignCargo(String cargo) {
	try {
		// Safety rule: Rectangular cannot carry Petroleum
		if (type.equalsIgnoreCase("Rectangular") &&
			cargo.equalsIgnoreCase("Petroleum")) {
			throw new CargoSafetyException(
				"Unsafe Cargo Assignment: Rectangular bogie cannot carry Petroleum"
			);
		}

		this.cargo = cargo;
		System.out.println("Cargo '" + cargo + "' assigned to " + type + " bogie.");

	} catch (CargoSafetyException e) {
		System.out.println("Error: " + e.getMessage());
	} finally {
		System.out.println("Cargo assignment attempt completed for " + type + " bogie.");
	}
}

@Override
public String toString() {
	return type + " -> " + (cargo != null ? cargo : "No Cargo");
}
}

public class TrainConsistManagement {
public static void main(String[] args) {

	System.out.println("=== Train Consist Management App ===");

	// UC14: Valid Passenger Bogies
	List<Bogie> bogieList = new ArrayList<>();
	try {
		bogieList.add(new Bogie("Sleeper", 72));
		bogieList.add(new Bogie("AC Chair", 54));
	} catch (InvalidCapacityException e) {
		System.out.println("Error: " + e.getMessage());
	}

	// UC15: Safe Cargo Assignment
	System.out.println("\nAssigning cargo to goods bogies...");

	GoodsBogie g1 = new GoodsBogie("Cylindrical");
	GoodsBogie g2 = new GoodsBogie("Rectangular");

	// Safe assignment
	g1.assignCargo("Petroleum");

	// Unsafe assignment (handled gracefully)
	g2.assignCargo("Petroleum");

	// Continue execution
	g2.assignCargo("Coal");

	// Final state
	System.out.println("\nFinal Goods Bogie Status:");
	System.out.println(g1);
	System.out.println(g2);
}
}