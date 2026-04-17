package org.example;

import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagement {
public static void main(String[] args) {

	// Welcome Message
	System.out.println("=== Train Consist Management App ===");

	// UC1: Initialize empty train consist
	List<String> trainConsist = new ArrayList<>();
	System.out.println("Train initialized successfully.");
	System.out.println("Initial number of bogies: " + trainConsist.size());

	// UC2: Add Passenger Bogies
	System.out.println("\nAdding passenger bogies...");

	trainConsist.add("Sleeper");
	trainConsist.add("AC Chair");
	trainConsist.add("First Class");

	// Display bogies after insertion
	System.out.println("Bogies after addition: " + trainConsist);

	// Remove a bogie (AC Chair)
	System.out.println("\nRemoving 'AC Chair' bogie...");
	trainConsist.remove("AC Chair");

	// Display after removal
	System.out.println("Bogies after removal: " + trainConsist);

	// Check existence of Sleeper
	System.out.println("\nChecking if 'Sleeper' exists...");
	if (trainConsist.contains("Sleeper")) {
		System.out.println("'Sleeper' bogie exists in the train.");
	} else {
		System.out.println("'Sleeper' bogie does NOT exist in the train.");
	}

	// Final state
	System.out.println("\nFinal train consist: " + trainConsist);
}
}