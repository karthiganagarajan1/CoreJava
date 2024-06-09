package com.pkg.soring.algorithm;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int arr[] = { 23, 45, 76, 89, 23, 1, 5, 6 };
		System.out.println("Before Sorting ");
		Arrays.stream(arr).forEach(elem -> System.out.print(elem + ","));
		bubbleSortLogic(arr);
		System.out.println("After Sorting ");
		Arrays.stream(arr).forEach(elem -> System.out.print(elem + ","));

	}

	private static void bubbleSortLogic(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

	}

}
