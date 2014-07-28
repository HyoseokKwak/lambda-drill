package com.khs.java.lambdadrill;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LexicalScope {
	
	private void scope1() {

		List<String> friends = Arrays.asList(new String[] { "brian", "nate", "neal", "raju", "sara", "scott" });


		// lambda expression
		final Predicate<String> startsWithN = name -> name.startsWith("n");
		final Predicate<String> startsWithB = name -> name.startsWith("b");

		System.out.println(friends.stream()
				.filter(startsWithN)
				.collect(Collectors.toList()));

		System.out.println(friends.stream()
				.filter(startsWithB)
				.collect(Collectors.toList()));

	}


	// lexical scope
	public static Predicate<String> checkIfstartsWith(final String letter){
		return name -> name.startsWith(letter);
	}

	private void scope2() {

		List<String> friends = Arrays.asList(new String[] { "brian", "nate", "neal", "raju", "sara", "scott" });


		System.out.println(friends.stream()
				.filter(checkIfstartsWith("n"))
				.collect(Collectors.toList()));

		System.out.println(friends.stream()
				.filter(checkIfstartsWith("b"))
				.collect(Collectors.toList()));

	}
}
