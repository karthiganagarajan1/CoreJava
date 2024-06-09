package com.common.map.tasks;

import java.util.Arrays;

public class RotateKTimes {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 4, 5, 8, 9, 6, 3 };
		int k = 4;
		rotate(arr, k);
		System.out.println(Arrays.toString(arr));
	}

	private static void rotate(int[] arr, int k) {
		int n = arr.length;
		k = k % n;
		reverse(arr, 0, n - 1);
		reverse(arr, 0, k - 1);
		reverse(arr, k, n - 1);
	}

	private static void reverse(int[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[end];
			arr[end] = arr[start];
			arr[start] = temp;
			start++;
			end--;
		}

	}

}
