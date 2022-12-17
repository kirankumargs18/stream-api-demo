package com.kirangs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingInStreamDemo {

	public static void main(String[] args) {

		/**
		 * Sorting in Stream API : Ascending order
		 */
		List<String> fruits = new ArrayList<>(
				
				Arrays.asList("Orange", "Apple", "Mango", "Kiwi","apple")
				
				);

		List<String> sortedFruits = fruits.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedFruits); //[Apple, Kiwi, Mango, Orange, apple]
		
		List<String> sortedFruits1=fruits.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
		System.out.println(sortedFruits1); //[Apple, Kiwi, Mango, Orange, apple]
		
		List<String> sortedFruits2=fruits.stream().sorted((o1,o2)->o1.compareTo(o2)).collect(Collectors.toList());
		System.out.println(sortedFruits2);	//[Apple, Kiwi, Mango, Orange, apple]	
		
		//here case will be ignored
		List<String> sortedFruits3=fruits.stream().sorted((o1,o2)->o1.compareToIgnoreCase(o2)).collect(Collectors.toList());
		System.out.println(sortedFruits3); //[Apple, apple, Kiwi, Mango, Orange]
		
		
		/**
		 * Sorting in Stream API : Descending order
		 * */
        List<String> fruits1 = new ArrayList<>(
				
				Arrays.asList("Orange", "Apple", "Mango", "Kiwi")
				
				);

		List<String> sortedFruits4 = fruits1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(sortedFruits4);
		
		
		List<String> sortedFruits5=fruits1.stream().sorted((o1,o2)->o2.compareTo(o1)).collect(Collectors.toList());
		System.out.println(sortedFruits5);
		
		
		/**
		 * Sorting Objects
		 * */
		List<Employee> employees=new ArrayList<>();
		employees.add(new Employee("3", "Naveen", 26, 40000.0));
		employees.add(new Employee("1", "Kiran", 24, 30000.0));
		employees.add(new Employee("2", "Shravan", 25, 35000.0));
		
		
		//sorting by salary in ascending order where comparator implemented using anonymous inner class
		List<Employee> sortedEmployees = employees.stream().sorted(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {

				return (int) (o1.getSalary() - o2.getSalary());
			}

		}).collect(Collectors.toList());
		
		System.out.println("Employees sorted by salary : ");
		sortedEmployees.forEach(System.out::println);
		
		
		//sorting by salary in ascending order where comparator implemented using lambda expressions
		List<Employee> sortedEmployees2 = employees.stream().sorted((e1, e2) -> {
			return (int) (e1.getSalary() - e2.getSalary());
		}).collect(Collectors.toList());
		System.out.println("Employees sorted by salary : ");
		sortedEmployees2.forEach(System.out::println);
		
		
		//sorting by salary in ascending order by Comparator.comparing
		System.out.println("Employees sorted by salary : ");
		List<Employee> sortedEmployees3=employees.stream()
				.sorted(Comparator.comparing(Employee::getSalary))
				.collect(Collectors.toList());
		sortedEmployees3.forEach(System.out::println);
		
		
		//sorting by salary in descending order by Comparator.comparing
		System.out.println("Employees sorted by salary DESC : ");
		List<Employee> sortedEmployees4=employees.stream()
				.sorted(Comparator.comparing(Employee::getSalary).reversed())
				.collect(Collectors.toList());
		sortedEmployees4.forEach(System.out::println);
		
		
		//sorting employees by Name in ascending
		System.out.println("Employees sorted by name ASC");
		List<Employee> sortedEmployees5=employees.stream()
				.sorted(Comparator.comparing(Employee::getName))
				.collect(Collectors.toList());
		sortedEmployees5.forEach(System.out::println);
		
		// sorting employees by Name in ascending
		System.out.println("Employees sorted by name DESC");
		List<Employee> sortedEmployees6 = employees.stream()
				.sorted(Comparator.comparing(Employee::getName).reversed())
				.collect(Collectors.toList());
		sortedEmployees6.forEach(System.out::println);
		
		//get Employee with highest salary
		Employee employee=employees.stream()
				.max(Comparator.comparing(Employee::getSalary))
				.get();
		System.out.println("Employee with Highest salary : "+employee);
		
		//get total number of employees
		System.out.println("Number of Employees : "+employees.stream().count());
		
		//get Employee with lowest Age
		Employee employee2=employees.stream()
				.min(Comparator.comparing(Employee::getAge))
				.get();
		System.out.println("Employee with Lowest Age : "+employee2);
		
	}

}
