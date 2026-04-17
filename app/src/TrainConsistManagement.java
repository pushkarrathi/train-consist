package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
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

	// UC3: Unique Bogie IDs using HashSet
	System.out.println("\nTracking unique bogie IDs...");
	Set<String> bogieIDs = new HashSet<>();
	bogieIDs.add("BG101");
	bogieIDs.add("BG102");
	bogieIDs.add("BG103");
	bogieIDs.add("BG101"); // duplicate
	bogieIDs.add("BG102"); // duplicate
	System.out.println("Unique Bogie IDs: " + bogieIDs);

	// UC4: Maintain ordered train consist using LinkedList
	System.out.println("\nMaintaining ordered train consist...");

	LinkedList<String> orderedConsist = new LinkedList<>();

	// Add bogies
	orderedConsist.add("Engine");
	orderedConsist.add("Sleeper");
	orderedConsist.add("AC");
	orderedConsist.add("Cargo");
	orderedConsist.add("Guard");

	System.out.println("Initial consist: " + orderedConsist);

	// Insert Pantry Car at position 2
	orderedConsist.add(2, "Pantry Car");
	System.out.println("After inserting Pantry Car: " + orderedConsist);

	// Remove first and last bogie
	orderedConsist.removeFirst();
	orderedConsist.removeLast();

	// Final consist
	System.out.println("Final ordered train consist: " + orderedConsist);
}
}