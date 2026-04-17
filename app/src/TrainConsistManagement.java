package org.example;

public class TrainConsistManagement {
public static void main(String[] args) {

	System.out.println("=== Train Consist Management App ===");

	// UC20: Exception Handling During Search

	String[] bogieIDs = {}; // try with empty and non-empty cases

	String searchKey = "BG101";

	// Fail-fast validation
	if (bogieIDs.length == 0) {
		throw new IllegalStateException("Cannot perform search: Train has no bogies.");
	}

	// Linear Search (can also reuse binary search)
	boolean found = false;

	for (String id : bogieIDs) {
		if (id.equals(searchKey)) {
			found = true;
			break;
		}
	}

	// Step 3: Output result
	if (found) {
		System.out.println("\nBogie ID " + searchKey + " FOUND.");
	} else {
		System.out.println("\nBogie ID " + searchKey + " NOT FOUND.");
	}
}
}