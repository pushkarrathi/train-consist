package org.example;

import java.util.*;
import java.util.stream.Collectors;

// Custom Exception
class InvalidCapacityException extends Exception {
public InvalidCapacityException(String message) {
	super(message);
}
}

// Passenger Bogie class with validation
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

// Goods Bogie class
class GoodsBogie {
String type;
String cargo;

GoodsBogie(String type, String cargo) {
	this.type = type;
	this.cargo = cargo;
}
}

public class TrainConsistManagement {
public static void main(String[] args) {

	System.out.println("=== Train Consist Management App ===");

	List<Bogie> bogieList = new ArrayList<>();

	try {
		// Valid bogies
		bogieList.add(new Bogie("Sleeper", 72));
		bogieList.add(new Bogie("AC Chair", 54));

		// Invalid bogie (will throw exception)
		bogieList.add(new Bogie("First Class", 0));

	} catch (InvalidCapacityException e) {
		System.out.println("Error: " + e.getMessage());
	}

	// Display valid bogies only
	System.out.println("\nValid Bogies in Train:");
	for (Bogie b : bogieList) {
		System.out.println(b);
	}
}
}