package org.example;

import java.util.*;

// Custom Checked Exception
class InvalidCapacityException extends Exception {
public InvalidCapacityException(String message) {
	super(message);
}
}

// Custom Runtime Exception
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
}

// Goods Bogie
class GoodsBogie {
String type;
String cargo;

GoodsBogie(String type) {
	this.type = type;
}

public void assignCargo(String cargo) {
	try {
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
}

public class TrainConsistManagement {
public static void main(String[] args) {

	System.out.println("=== Train Consist Management App ===");

	// UC16: Bubble Sort on Passenger Capacities
	int[] capacities = {72, 56, 24, 70, 60};

	System.out.println("\nOriginal Capacities:");
	System.out.println(Arrays.toString(capacities));

	// Bubble Sort Algorithm
	int n = capacities.length;
	for (int i = 0; i < n - 1; i++) {
		for (int j = 0; j < n - i - 1; j++) {

			if (capacities[j] > capacities[j + 1]) {
				// Swap
				int temp = capacities[j];
				capacities[j] = capacities[j + 1];
				capacities[j + 1] = temp;
			}
		}
	}

	System.out.println("\nSorted Capacities (Ascending):");
	System.out.println(Arrays.toString(capacities));
}
}