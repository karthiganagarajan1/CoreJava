package com.common.map.tasks;

public class TwoSum {
//	Given an array of integers, return indices of the two numbers such that they add up to a specific target.
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int target = 17;

		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				sum = arr[i] + arr[j];
				if (i < j && sum == target) {
					System.out.println("Index [" + i + "," + j + "] = " + target);
				}

			}
		}

	}
}
