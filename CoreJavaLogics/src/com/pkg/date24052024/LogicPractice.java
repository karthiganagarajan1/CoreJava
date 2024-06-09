package com.pkg.date24052024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LogicPractice {
	public static void main(String[] args) {
		// 1. Find the largest String in the list
		List<String> countries = Arrays.asList("India", "USA", "UK", "India");
		Optional<String> largestString = countries.stream().max(Comparator.comparing(String::length));
		System.out.println(largestString.isPresent() ? largestString.get() : "Not Found");
		// 2. Remove Duplicate elements from the list
		List<String> distinctList = countries.stream().distinct().collect(Collectors.toList());
		System.out.println(distinctList);
		// 3. Take one employee list and write code for employees whose salaries more
		// than 50,000
		List<Integer> salary = Arrays.asList(20000, 50000, 5000, 10000, 60000);
		salary.stream().filter(s -> s > 50000).collect(Collectors.toList()).forEach(System.out::println);
		// 4. Sort an array without using predefined methods
		sortArray();
		// 6. We have 50 students in a particular class room, can you sort these
		// students based on their age:
		Map<String, Integer> students = new LinkedHashMap<>();
		students.put("Anu", 20);
		students.put("Bala", 30);
		students.put("Cathrine", 15);
		List<Map.Entry<String, Integer>> studList = new ArrayList<>(students.entrySet());
		studList.sort(Map.Entry.comparingByValue());
//		Collections.sort(studList, (s1, s2) -> s1.getValue().compareTo(s2.getValue()));
		Map<String, Integer> sortedMap = new LinkedHashMap<>();
		for (Map.Entry<String, Integer> entry : studList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		System.out.println(sortedMap);
//		7. In a particular classroom, can you display only those students whose names are repetitive?
		List<String> names = Arrays.asList("Karthiga", "Karthiga", "Anu", "Bala");
		Map<String, Long> namesMap = names.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		namesMap.entrySet().forEach(elem -> {
			if (elem.getValue() > 1) {
				System.out.println(elem.getKey());
			}
		});
//		8. SOrt map based on keys
		List<Map.Entry<String, Integer>> studList2 = new ArrayList<>(students.entrySet());
		studList2.sort(Map.Entry.comparingByKey());
		for (Map.Entry<String, Integer> entry : studList2) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
//		9. SOrt map based on values
		studList2.sort(Map.Entry.comparingByValue());
		for (Map.Entry<String, Integer> entry : studList2) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
//		10. insert an entry after key "Anu"
		System.out.println("Before " + students);
		Map<String, Integer> newMap = new LinkedHashMap<>();
		for (Map.Entry<String, Integer> entry : students.entrySet()) {
			newMap.put(entry.getKey(), entry.getValue());
			if (entry.getKey().equals("Anu")) {
				newMap.put("Abi", 40);
			}
		}
		System.out.println("After " + newMap);
//		11. insert an entry after value 10
		Map<String, Integer> newMap2 = new LinkedHashMap<>();
		for (Map.Entry<String, Integer> entry : students.entrySet()) {
			newMap2.put(entry.getKey(), entry.getValue());
			if (entry.getValue() == 30) {
				newMap2.put("David", 50);
			}
		}
		System.out.println(newMap2);
//		12. remove entry if the value is equal to 10
		students.entrySet().removeIf(entry -> entry.getValue() == 20);
		System.out.println(students);
//		13. remove entry if the key is equal to "A"
		students.entrySet().removeIf(entry -> entry.getKey().equalsIgnoreCase("bala"));
		System.out.println(students);
//		14. check the given 2 strings are anagram
		anagram();
		groupAnagrams();
//		15. Check the given number is Prime or not
		boolean isPrime = checkPrime(29);
		System.out.println(isPrime ? "The given number is Prime" : "The given number is not a prime");
//		16. Check the given String is palindrome
		isPalindrome("Madam");
//		18. Count the number of digits present in the number
		digitsCount(4589);
//		19. Swap 2 values associated with the variables
		swap(10, 20);
//		20. sum of digits
		digitsSum(123);
//		21.Count the number of chanracters in a String
		String sentence = "Java is a popular programming language";
		countChars(sentence);
//		22. Count the number of Strings in a sentence
		countWords(sentence);
//		23. Armstrong number
		armstrongNumber(153);
//		24. sort the list in asending order
		sortListAsc();
//		25. Sort the list in descending order
		sortListDesc();
//		26. Add element after "Apple" in a list
		List<String> fruits = new ArrayList<>(Arrays.asList("Apple", "Cherry", "Dragon Fruit"));
		addElementAfterElement(fruits);
//		27. Remove particular element from a list
		removeElem(fruits);
//		28. swap 2 items from a list
		swapItems(fruits);
		List<String> nameList = new ArrayList<>(
				Arrays.asList("Nilan", "Nilan", "Karthiga", "Nagarajan", "Sabari", "Sabari"));
//		29. Remove duplicates from a list
		removeDupe(nameList);
//		30. count number of times a particular element present in a list
		countFrequency(nameList);
//		31. count the number of unique elements present in a list
		uniqueElemCount(nameList);

		Map<String, Integer> map = new LinkedHashMap<>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 2);
		map.put("D", 3);
		map.put("E", 4);
		map.put("F", 5);
		map.put("G", 6);
//		32. Remove an entry from a map based on Key
		removeKey(map, "G");
//		33. Removean entry from a map based on value
		removeValue(map, 5);
//		34. in a map if the value is duplicate remove the entry in the map
		removeDupeValues(map);
//		35. Count number of duplicate values irrespective of key in a map java
		countDupeValues(map);

	}

	private static void countDupeValues(Map<String, Integer> map) {
		System.out.println("Before " + map);
		List<Integer> valueList = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			valueList.add(entry.getValue());
		}
		valueList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
				.forEach(entry -> {
					if (entry.getValue() > 1) {
//						System.out.println(entry.getKey() + "=" + entry.getValue());
						map.entrySet().forEach(entry2 -> {
							if (entry2.getValue() == entry.getKey()) {
								System.out.println(entry2.getKey());
							}
						});
					}
				});

	}

	private static void removeDupeValues(Map<String, Integer> map) {
		System.out.println("Actual Map " + map);
		Map<Integer, String> reverseMap = new LinkedHashMap<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			reverseMap.put(entry.getValue(), entry.getKey());
		}
		Map<String, Integer> resultMap = new LinkedHashMap<>();
		for (Map.Entry<Integer, String> entry : reverseMap.entrySet()) {
			resultMap.put(entry.getValue(), entry.getKey());
		}
		System.out.println(resultMap);
	}

	private static void removeValue(Map<String, Integer> map, int i) {
		System.out.println("Before " + map);
		map.entrySet().removeIf(entry -> entry.getValue().equals(i));
		System.out.println("After " + map);
	}

	private static void removeKey(Map<String, Integer> map, String key) {
		System.out.println("Before " + map);
		map.entrySet().removeIf(entry -> entry.getKey().equalsIgnoreCase(key));
		System.out.println("After " + map);
	}

	private static void isPalindrome(String str) {
		StringBuilder strBuilder = new StringBuilder(str);
		StringBuilder reverse = strBuilder.reverse();
		if (strBuilder.equals(reverse)) {
			System.out.println("The given String is palindrome");
		} else {
			System.out.println("The given string is not a palindrome");
		}
		// Without using StringBuilder
		char[] c = str.toCharArray();
		String rev = "";
		for (int i = c.length - 1; i >= 0; i--) {
			rev += c[i];
		}
		if (str.equalsIgnoreCase(rev)) {
			System.out.println("The given string is palindrome");
		} else {
			System.out.println("The given string is not a palindrome");
		}
	}

	private static void uniqueElemCount(List<String> nameList) {
		System.out.println(nameList.stream().distinct().collect(Collectors.toList()).size());
	}

	private static void countFrequency(List<String> nameList) {
		Map<String, Long> freqMap = nameList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(freqMap);

	}

	private static void removeDupe(List<String> nameList) {
		nameList.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);
	}

	private static void swapItems(List<String> fruits) {
		System.out.println("Before Swap " + fruits);
//		swap chery and banana
		String s1 = "Cherry";
		String s2 = "Bananna";
		if (fruits.contains(s1) && fruits.contains(s2)) {
			int cherryIndex = fruits.indexOf(s1);
			int banannaIndex = fruits.indexOf(s2);
			Collections.swap(fruits, cherryIndex, banannaIndex);
			System.out.println("After swap " + fruits);
		}

	}

	private static void removeElem(List<String> fruits) {
		fruits.removeIf(elem -> elem.equalsIgnoreCase("apple"));
		System.out.println(fruits);
	}

	private static void addElementAfterElement(List<String> fruits) {
		String input = "Apple";
		int inputElemIndex = fruits.indexOf(input);
		fruits.add(inputElemIndex + 1, "Bananna");
		System.out.println("After adding element " + fruits);
	}

	private static void sortListDesc() {
		System.out.println("Descending Order");
		List<Integer> intList = Arrays.asList(78, 52, 33, 1, 2, 5, 678);
		intList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("Descending Order 2");
		intList.stream().sorted((e1, e2) -> e2.compareTo(e1)).collect(Collectors.toList()).forEach(System.out::println);

	}

	private static void sortListAsc() {
		List<Integer> intList = Arrays.asList(10, 78, 1, 2, 5, 200);
		intList.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);
	}

	private static void armstrongNumber(int n) {
		int o = n;
		int sum = 0;
		while (n > 0) {
			int i = n % 10;
			sum += i * i * i;
			n /= 10;
		}
		System.out.println((o == sum) ? "Armstrong" : "Not ArmStrong");
	}

	private static void countWords(String sentence) {
		Map<String, Long> countMap = Arrays.stream(sentence.split(" "))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(countMap);

	}

	private static void countChars(String input) {
		Map<Character, Long> countMap = input.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(countMap);
	}

	private static void digitsSum(int i) {
		int sum = 0;
		while (i > 0) {
			sum += i % 10;
			i /= 10;
		}
		System.out.println(sum);

	}

	private static void swap(int i, int j) {
		System.out.println("Before " + i + "----" + j);
		int temp = i;
		i = j;
		j = temp;
		System.out.println("After " + i + "----" + j);
	}

	private static void digitsCount(int i) {
		System.out.println(String.valueOf(i).length());
		int count = 0;
		while (i > 0) {
			i /= 10;
			count++;
		}
		System.out.println("Digit length " + count);

	}

	private static boolean checkPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static void groupAnagrams() {
		String[] arr = { "god", "no", "on", "dog" };
		List<String> resultList = new LinkedList<>();
		Map<String, List<String>> anagramGroup = new LinkedHashMap<>();
		for (String elem : arr) {
			char[] value = elem.toCharArray();
			Arrays.sort(value);
			String sortedString = new String(value);
			if (!anagramGroup.containsKey(sortedString)) {
				anagramGroup.put(sortedString, new ArrayList<>());
			}
			anagramGroup.get(sortedString).add(elem);
		}
		for (Map.Entry<String, List<String>> entry : anagramGroup.entrySet()) {
			for (String value : entry.getValue()) {
				resultList.add(value);
			}
		}
		System.out.println(resultList);
	}

	private static void anagram() {
		String s1 = "dog";
		String s2 = "gods";
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		System.out.println(Arrays.equals(c1, c2) ? "The given Strings are anagram" : "They are NOT anagram");

	}

	private static void sortArray() {
		int a[] = { 45, 2, 8, 77, 1 };
//		int b[] = Arrays.stream(a).sorted().toArray();
//		System.out.println(Arrays.toString(b));
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		Arrays.stream(a).forEach(System.out::println);
	}
}
