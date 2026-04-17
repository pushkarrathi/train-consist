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

	// UC1–UC12 (shortened setup)
	List<Bogie> bogieList = new ArrayList<>();
	bogieList.add(new Bogie("Sleeper", 72));
	bogieList.add(new Bogie("AC Chair", 54));
	bogieList.add(new Bogie("First Class", 24));
	bogieList.add(new Bogie("Sleeper", 70));
	bogieList.add(new Bogie("AC Chair", 65));
	bogieList.add(new Bogie("General", 90));

	// Create large dataset for realistic benchmarking
	List<Bogie> largeList = new ArrayList<>();
	for (int i = 0; i < 100000; i++) {
		largeList.add(new Bogie("Sleeper", 50 + (i % 50)));
	}

	// UC13: Loop vs Stream Performance Comparison

	// Loop-based filtering
	long startLoop = System.nanoTime();

	List<Bogie> loopResult = new ArrayList<>();
	for (Bogie b : largeList) {
		if (b.capacity > 60) {
			loopResult.add(b);
		}
	}

	long endLoop = System.nanoTime();
	long loopTime = endLoop - startLoop;

	// Stream-based filtering
	long startStream = System.nanoTime();

	List<Bogie> streamResult = largeList.stream()
		.filter(b -> b.capacity > 60)
		.collect(Collectors.toList());

	long endStream = System.nanoTime();
	long streamTime = endStream - startStream;

	// Output results
	System.out.println("\nLoop Filtering Count: " + loopResult.size());
	System.out.println("Stream Filtering Count: " + streamResult.size());

	System.out.println("\nLoop Execution Time (ns): " + loopTime);
	System.out.println("Stream Execution Time (ns): " + streamTime);

	// Validate both results are same
	System.out.println("\nResults Match: " + (loopResult.size() == streamResult.size()));
}
}