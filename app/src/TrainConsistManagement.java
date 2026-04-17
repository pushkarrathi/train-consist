package org.example;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

// Passenger Bogie class
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

// Goods Bogie class for UC12
class GoodsBogie {
String type;   // Cylindrical, Rectangular, etc.
String cargo;  // Petroleum, Coal, Grain

GoodsBogie(String type, String cargo) {
	this.type = type;
	this.cargo = cargo;
}

@Override
public String toString() {
	return type + " -> " + cargo;
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
	bogieList.add(new Bogie("Sleeper", 70));
	bogieList.sort(Comparator.comparingInt(b -> b.capacity));

	// UC8
	List<Bogie> filteredBogies = bogieList.stream()
		.filter(b -> b.capacity > 60)
		.collect(Collectors.toList());

	// UC9
	Map<String, List<Bogie>> groupedBogies = bogieList.stream()
		.collect(Collectors.groupingBy(b -> b.name));

	// UC10
	int totalCapacity = bogieList.stream()
		.map(b -> b.capacity)
		.reduce(0, Integer::sum);

	System.out.println("\nTotal Seating Capacity: " + totalCapacity);

	// UC11
	Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
	Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");

	String trainID = "TRN-1234";
	String cargoCode = "PET-AB";

	System.out.println("\nTrain ID Valid: " + trainPattern.matcher(trainID).matches());
	System.out.println("Cargo Code Valid: " + cargoPattern.matcher(cargoCode).matches());

	// UC12: Safety Compliance Check
	System.out.println("\nChecking safety compliance for goods bogies...");

	List<GoodsBogie> goodsList = new ArrayList<>();

	goodsList.add(new GoodsBogie("Cylindrical", "Petroleum"));
	goodsList.add(new GoodsBogie("Rectangular", "Coal"));
	goodsList.add(new GoodsBogie("Cylindrical", "Petroleum"));
	// Try invalid case: new GoodsBogie("Cylindrical", "Coal")

	boolean isSafe = goodsList.stream()
		.allMatch(b ->
			!b.type.equalsIgnoreCase("Cylindrical") ||
				b.cargo.equalsIgnoreCase("Petroleum")
		);

	if (isSafe) {
		System.out.println("Train is SAFETY COMPLIANT.");
	} else {
		System.out.println("Train is NOT SAFE!");
	}
}
}