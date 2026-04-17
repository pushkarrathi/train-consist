package org.example;

public class TrainConsistManagement {
public static void main(String[] args) {

	System.out.println("=== Train Consist Management App ===");

	// UC18: Linear Search for Bogie ID
	String[] bogieIDs = {"BG101", "BG205", "BG309", "BG412", "BG550"};

	String searchKey = "BG309"; // change this value to test

	boolean found = false;

	// Linear Search
	for (int i = 0; i < bogieIDs.length; i++) {
		if (bogieIDs[i].equals(searchKey)) {
			found = true;
			break; // early termination
		}
	}

	// Output result
	if (found) {
		System.out.println("\nBogie ID " + searchKey + " FOUND in the train.");
	} else {
		System.out.println("\nBogie ID " + searchKey + " NOT FOUND in the train.");
	}
}
}