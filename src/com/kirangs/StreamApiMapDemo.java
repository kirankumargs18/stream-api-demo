package com.kirangs;

import java.util.ArrayList;
import java.util.List;

/**
 * map() --> does not change data type of stream
 * mapToInt() --> changes stream to IntStream
 * mapToLong() --> changes stream to LongStream
 * mapToDouble() --> changes stream to DoubleStream
 * */
public class StreamApiMapDemo {
	
	public static void main(String[] args) {
		
		List<Employee> employees=new ArrayList<>();
		employees.add(new Employee("3", "Naveen", 26, 40000.0));
		employees.add(new Employee("1", "Kiran", 24, 30000.0));
		employees.add(new Employee("2", "Shravan", 25, 35000.0));
		
		/**
		 * mapToDouble
		 * */
		Double totalSalary = employees.stream().mapToDouble(employee -> employee.getSalary()).sum();
		System.out.println("Total Salary : "+totalSalary);
		
		/**
		 * mapToInteger
		 * */
		int[] ages=
		employees.stream().mapToInt(employee-> employee.getAge()).distinct().toArray();
		for(Integer age:ages) {
			System.out.println(age);
		}
		
	}

}
