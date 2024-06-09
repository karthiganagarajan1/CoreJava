package com.common.map.tasks;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapTasks {
	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("Apple", "Apple", "Cherry", "Cherry", "Apple", "kiwi");
		// frequency
		fruits.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
				.forEach(entry -> {
					System.out.println(entry.getKey() + "=" + entry.getValue());
				});
		// Top 2 most frequent
		Map<String, Long> countMap = fruits.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		List<Map.Entry<String, Long>> entryList = new LinkedList<>(countMap.entrySet());
		Collections.sort(entryList, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));
		int count = 1;
		for (Map.Entry<String, Long> entry : entryList) {
//			System.out.println(entry.getKey() + "=" + entry.getValue());
			System.out.println("Most frequently bought fruit " + count + " is " + entry.getKey());
			count++;
			if (count > 2)
				break;
		}

	}
}
