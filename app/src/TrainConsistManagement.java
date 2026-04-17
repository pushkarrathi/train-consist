package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TrainConsistManagement {
public static void main(String[] args) {

	// Welcome Message
	System.out.println("=== Train Consist Management App ===");

	// UC1: Initialize train consist
	List<String> trainConsist = new ArrayList<>();
	System.out.println("Train initialized successfully.");
	System.out.println("Initial number of bogies: " + trainConsist.size());

	// UC2: Add Passenger Bogies
	System.out.println("\nAdding passenger bogies...");
	trainConsist.add("Sleeper");
	trainConsist.add("AC Chair");
	trainConsist.add("First Class");
	System.out.println("Bogies after addition: " + trainConsist);

	System.out.println("\nRemoving 'AC Chair' bogie...");
	trainConsist.remove("AC Chair");
	System.out.println("Bogies after removal: " + trainConsist);

	System.out.println("\nChecking if 'Sleeper' exists...");
	if (trainConsist.contains("Sleeper")) {
		System.out.println("'Sleeper' bogie exists in the train.");
	} else {
		System.out.println("'Sleeper' bogie does NOT exist in the train.");
	}

	// UC3: Track Unique Bogie IDs using HashSet
	System.out.println("\nTracking unique bogie IDs...");

	Set<String> bogieIDs = new HashSet<>();

	// Adding IDs (with duplicates)
	bogieIDs.add("BG101");
	bogieIDs.add("BG102");
	bogieIDs.add("BG103");
	bogieIDs.add("BG101"); // duplicate
	bogieIDs.add("BG102"); // duplicate

	// Display unique IDs
	System.out.println("Unique Bogie IDs: " + bogieIDs);
}
}