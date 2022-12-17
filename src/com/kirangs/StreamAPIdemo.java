package com.kirangs;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class StreamAPIdemo {
	
	public static void main(String[] args) {
		
		/**
		 * create stream
		 * */
		Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		intStream.forEach(value -> System.out.println(value));
		
		
		/**
		 * create stream from sources
		 * */
		// converting collection to stream : collection_name.stream()
		Collection<String> collection = Arrays.asList("Java", "Spring boot", "Microservices");
		Stream<String> collectionStream = collection.stream();
		collectionStream.forEach(System.out::println);

		List<String> javaList = Arrays.asList("Java", "Spring boot", "Microservices");
		Stream<String> javaListStream = javaList.stream();
		javaListStream.forEach(System.out::println);

		Set<String> javaSet = new HashSet<>(javaList);
		Stream<String> javaSetStream = javaSet.stream();
		javaSetStream.forEach(System.out::println);

		// converting arrays to streams : Arrays.stream(array_object)
		String[] strArray = { "a", "b", "c", "d" };
		Stream<String> strStream = Arrays.stream(strArray);
		strStream.forEach(System.out::println);
		
		/**
		 * Filter in Stream API
		 * */
		Stream<Integer> numberStream=Stream.of(1,2,3,4,5,6,7,8,9,10);
		
		System.out.println("Even numbers : ");
		
		numberStream
		.filter(number-> number%2 == 0)
		.forEach(number -> System.out.println(number));
		
		//we can perform operation on stream only once in a method
		Stream<Integer> numberStream1=Stream.of(1,2,3,4,5,6,7,8,9,10);

		System.out.println("Odd numbers : ");
		
		numberStream1
		.filter(number-> number%2 != 0)
		.forEach(number -> System.out.println(number));
		
		
		//findFirst() and findAny()
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		
		Optional<Integer> findFirst = numbers.stream().findFirst();
		if(findFirst.isPresent()) {
			System.out.println("Element : "+findFirst.get());
		}
		
		Optional<Integer> findAny = numbers.stream().findAny();
		if(findAny.isPresent()) {
			System.out.println("Element : "+findAny.get());
		}
		
		//count(), min() and max()
		List<Integer> numbersList = Arrays.asList(1,2,3,4,5);
		System.out.println("Number of elements : "+numbersList.stream().count());
		
		Integer minValue = numbersList.stream()
				.min(Comparator.comparing(Integer::valueOf))
				.get();
		System.out.println("Minimum element : "+minValue);
		
		Integer maxValue = numbersList.stream()
				.max(Comparator.comparing(Integer::valueOf))
				.get();
		System.out.println("Maximum element : "+maxValue);
	}

}
