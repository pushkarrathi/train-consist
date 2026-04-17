package org.example;

import java.util.*;
import java.util.stream.Collectors;

// Bogie class
class Bogie {
String name;
int capacity;

Bogie(String name, int capacity) {
	this.name = name;
	this.capacity = capacity;
}

@Override
public String toString() {
	return name + " (Capacity: " + capacity + ")";
}
}

public class TrainConsistManagement {
public static void main(String[] args) {

	// Welcome Message
	System.out.println("=== Train Consist Management App ===");

	// UC1
	List<String> trainConsist = new ArrayList<>();
	System.out.println("Train initialized successfully.");
	System.out.println("Initial number of bogies: " + trainConsist.size());

	// UC2
	trainConsist.add("Sleeper");
	trainConsist.add("AC Chair");
	trainConsist.add("First Class");
	trainConsist.remove("AC Chair");
	trainConsist.contains("Sleeper");

	// UC3
	Set<String> bogieIDs = new HashSet<>();
	bogieIDs.add("BG101");
	bogieIDs.add("BG102");
	bogieIDs.add("BG101");

	// UC4
	LinkedList<String> orderedConsist = new LinkedList<>();
	orderedConsist.add("Engine");
	orderedConsist.add("Sleeper");
	orderedConsist.add("AC");
	orderedConsist.add("Cargo");
	orderedConsist.add("Guard");
	orderedConsist.add(2, "Pantry Car");
	orderedConsist.removeFirst();
	orderedConsist.removeLast();

	// UC5
	LinkedHashSet<String> trainFormation = new LinkedHashSet<>();
	trainFormation.add("Engine");
	trainFormation.add("Sleeper");
	trainFormation.add("Cargo");
	trainFormation.add("Guard");
	trainFormation.add("Sleeper");

	// UC6
	Map<String, Integer> bogieCapacity = new HashMap<>();
	bogieCapacity.put("Sleeper", 72);
	bogieCapacity.put("AC Chair", 54);
	bogieCapacity.put("First Class", 24);

	// UC7
	List<Bogie> bogieList = new ArrayList<>();
	bogieList.add(new Bogie("Sleeper", 72));
	bogieList.add(new Bogie("AC Chair", 54));
	bogieList.add(new Bogie("First Class", 24));

	bogieList.sort(Comparator.comparingInt(b -> b.capacity));

	// UC8: Filter using Streams
	System.out.println("\nFiltering bogies with capacity > 60...");

	List<Bogie> filteredBogies = bogieList
		.stream()
		.filter(b -> b.capacity > 60)
		.collect(Collectors.toList());

	// Display filtered bogies
	System.out.println("Filtered Bogies:");
	for (Bogie b : filteredBogies) {
		System.out.println(b);
	}

	// Verify original list unchanged
	System.out.println("\nOriginal Bogie List:");
	for (Bogie b : bogieList) {
		System.out.println(b);
	}
}
}