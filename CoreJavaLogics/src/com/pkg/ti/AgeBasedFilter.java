package com.pkg.ti;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AgeBasedFilter {
	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(new Student(22, "Karthiga"), new Student(12, "Anu"));
		List<Student> sortedStudentList = studentList.stream().sorted(Comparator.comparing(Student::getAge))
				.collect(Collectors.toList());
		sortedStudentList.forEach(stud -> {
			System.out.println(stud.getAge() + "=" + stud.getName());
		});
	}
}
