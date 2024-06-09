package com.common.map.tasks;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ReverseArray {
	public static void main(String[] args) {
		int[] arr = { 1, 85, 2, 6, 74, 9, 32 };
		System.out.println(Arrays.toString(IntStream.range(0, arr.length).map(i -> arr[arr.length - 1 - i]).toArray()));
		reverse(arr, 0, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	private static void reverse(int[] arr, int start, int end) {
		end = end - 1;
		while (start < end) {
			int temp = arr[end];
			arr[end] = arr[start];
			arr[start] = temp;
			start++;
			end--;
		}
	}
}
