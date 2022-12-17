package com.kirangs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MappingInStreamDemo {
	
	public static void main(String[] args) {
		
		List<String> alpha=Arrays.asList("a","b","c","d");
		
		/**
		 * Before Java 8
		 * */
		List<String> alphaUpper = new ArrayList<>();
		for (String string : alpha) {

			alphaUpper.add(string.toUpperCase());
		}
		System.out.println(alphaUpper);
		
		
		/**
		 * After Java 8
		 * */
		List<String> alphaUpper1 = alpha.stream()
				.map(string -> string.toUpperCase())
				.collect(Collectors.toList());
		System.out.println(alphaUpper1);
		
		
		/**
		 * another example
		 * */
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> cubes = numbers.stream()
				.map(number -> (number * number * number))
				.collect(Collectors.toList());
		System.out.println(cubes);
		
		/**
		 * In REST API development we can use map() to convert entity to dto and vice versa
		 * */
		
		
	}

}
