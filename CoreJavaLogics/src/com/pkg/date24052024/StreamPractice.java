package com.pkg.date24052024;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamPractice {
	public static void main(String[] args) {
//		1. Merge and Sort 2 int[] in Asc order
		int a[] = { 45, 1, 89, 2, 56, 8, 7 };
		int b[] = { 145, 11, 589, 22, 856, 98, 77 };
		int asc[] = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();
		System.out.println(Arrays.toString(asc));
//		2. Merge and Sort 2 int[] in Desc order
		System.out.println(Arrays.toString(Arrays.stream(asc).boxed().sorted(Comparator.reverseOrder()).toArray()));
//		3. Count number of characters in a sentence
		String sentence = "Java is a popular programming Language";
		sentence.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
				.forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));
//		4. Count number of words in a sentence
		Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));
//		5. Create an Employee List with Name and Age and Print max salary of an employee with Name
		List<Employee> empList = Arrays.asList(new Employee("Nilan", "CEO", 1, 1000000000),
				new Employee("Karthiga", "Dev", 1, 450000), new Employee("Sabari", "Data", 1, 40000),
				new Employee("Nagarajan", "HR", 1, 600000), new Employee("Nirmala", "HR", 1, 500000),
				new Employee("Mani", "Admin", 1, 90000));
		Optional<Employee> maxSal = empList.stream().max(Comparator.comparing(Employee::getSalary));
		System.out.println(maxSal.get().getName() + "=" + maxSal.get().getSalary());
		Optional<Employee> minSal = empList.stream().min(Comparator.comparing(Employee::getSalary));
		System.out.println(minSal.get().getName() + "=" + minSal.get().getSalary());
//		6. Print Employee along with the salary in Descending order
		empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(emp -> {
			System.out.println(emp.getSalary() + "," + emp.getName() + "," + emp.getAge() + "," + emp.getDept());
		});
		Map<Integer, String> empBySalDesc = new LinkedHashMap<>(
				empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
						.collect(Collectors.toMap(Employee::getSalary, Employee::toString,
								(oldValue, newValue) -> oldValue, LinkedHashMap::new)));
		empBySalDesc.entrySet().forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));
//		7. Print second highest salary of an employee
		System.out.println(empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(2)
				.skip(1).findFirst().get().getSalary());
//		8. Get avg salary by dept
		System.out.println("8. Get avg salary by dept");
		empList.stream()
				.collect(Collectors.groupingBy(Employee::getDept, Collectors.averagingDouble(Employee::getSalary)))
				.entrySet().forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));
//		9. Print all the employees by dept
		System.out.println("9. Print all the employees by dept");
		Map<String, List<Employee>> empByDept = empList.stream().collect(Collectors.groupingBy(Employee::getDept));
		empByDept.entrySet().forEach(entry -> {
			System.out.print(entry.getKey() + "-----");
			entry.getValue().forEach(emp -> System.out.println(emp.toString()));
		});
//		10. Print max salary of an employee based on dept
		System.out.println("10. Print max salary of an employee based on dept");
		empList.stream().collect(
				Collectors.groupingBy(Employee::getDept, Collectors.maxBy(Comparator.comparing(Employee::getSalary))))
				.entrySet().forEach(entry -> {
					System.out.println(entry.getKey() + "=" + entry.getValue());
				});
//		11. Print Employee count based on dept
		System.out.println("11. Print Employee count based on dept");
		empList.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.counting())).entrySet()
				.forEach(entry -> {
					System.out.println(entry.getKey() + "=" + entry.getValue());
				});
	}
}
