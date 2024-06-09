package com.pkg.ti;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicates {
	public static void main(String[] args) {
		List<String> studentList = Arrays.asList("Karthiga", "Karthiga", "Nilan", "Nilan", "Sabari");
		Map<String, Long> countMap = studentList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		countMap.entrySet().forEach(entry -> {
			if (entry.getValue() > 1) {
				System.out.println(entry.getKey());
			}
		});
	}
}
