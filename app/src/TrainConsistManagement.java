package org.example;

public class TrainConsistManagement {
public static void main(String[] args) {

	System.out.println("=== Train Consist Management App ===");

	// UC19: Binary Search for Bogie ID

	String[] bogieIDs = {"BG309", "BG101", "BG550", "BG205", "BG412"};

	String searchKey = "BG205"; // change to test

	// Step 1: Sort the array (precondition for binary search)
	Arrays.sort(bogieIDs);

	System.out.println("\nSorted Bogie IDs:");
	System.out.println(Arrays.toString(bogieIDs));

	int low = 0;
	int high = bogieIDs.length - 1;
	boolean found = false;

	// Step 2: Binary Search
	while (low <= high) {
		int mid = (low + high) / 2;

		int comparison = bogieIDs[mid].compareTo(searchKey);

		if (comparison == 0) {
			found = true;
			break;
		} else if (comparison < 0) {
			low = mid + 1; // search right half
		} else {
			high = mid - 1; // search left half
		}
	}

	// Step 3: Output result
	if (found) {
		System.out.println("\nBogie ID " + searchKey + " FOUND using Binary Search.");
	} else {
		System.out.println("\nBogie ID " + searchKey + " NOT FOUND.");
	}
}
}