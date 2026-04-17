package org.example;

import java.util.Arrays;

public class TrainConsistManagement {
public static void main(String[] args) {

	System.out.println("=== Train Consist Management App ===");

	// UC17: Sort Bogie Names using Arrays.sort()
	String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

	System.out.println("\nOriginal Bogie Names:");
	System.out.println(Arrays.toString(bogieNames));

	// Built-in sorting
	Arrays.sort(bogieNames);

	System.out.println("\nSorted Bogie Names (Alphabetical):");
	System.out.println(Arrays.toString(bogieNames));
}
}