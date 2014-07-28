package com.khs.java.lambdadrill;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LexicalScope {

	private void scope1() {

		List<String> friends = Arrays.asList(new String[] { "brian", "nate",
				"neal", "raju", "sara", "scott" });

		// lambda expression
		// Predicate<input type>
		// always return a boolean type.
		final Predicate<String> startsWithN = name -> name.startsWith("n");
		final Predicate<String> startsWithB = name -> name.startsWith("b");

		System.out.println(friends.stream().filter(startsWithN)
				.collect(Collectors.toList()));

		System.out.println(friends.stream().filter(startsWithB)
				.collect(Collectors.toList()));

	}

	// lexical scope
	private static Predicate<String> checkIfstartsWith(final String letter) {
		return name -> name.startsWith(letter);
	}

	private void scope2() {

		List<String> friends = Arrays.asList(new String[] { "brian", "nate",
				"neal", "raju", "sara", "scott" });

		System.out.println(friends.stream().filter(checkIfstartsWith("n"))
				.collect(Collectors.toList()));

		System.out.println(friends.stream().filter(checkIfstartsWith("b"))
				.collect(Collectors.toList()));

	}


	private void scope3() {
	// Function <input type, return type>
//	final Function<String, Predicate<String>> startsWithLetter 
//		= (String letter) -> {
//		Predicate<String> checkStarts = (String name) -> name
//				.startsWith(letter);
//		return checkStarts;
//	};

//	final Function<String, Predicate<String>> startsWithLetter 
//		= (String letter) -> (String name) -> name.startsWith(letter);

	final Function<String, Predicate<String>> startsWithLetter 
		= letter -> name -> name.startsWith(letter);
		
		
		// ?? from Function to Predicate?
//	final Function<String, Function<String, Predicate<String>>> startsWithLetter 
//		= letter2 -> letter -> name -> name.startsWith(letter);
		
		List<String> friends = Arrays.asList(new String[] { "brian", "nate",
				"neal", "raju", "sara", "scott" });

		System.out.println(friends.stream().filter(startsWithLetter.apply("n"))
				.collect(Collectors.toList()));
	}
	
}
