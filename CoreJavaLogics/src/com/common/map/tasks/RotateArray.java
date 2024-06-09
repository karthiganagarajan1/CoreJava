package com.common.map.tasks;

import java.util.Arrays;

public class RotateArray {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int rotate = 5;
		int start = 0;
		int end = rotate - 1;
		while (start < end) {
			int temp = arr[end];
			arr[end] = arr[start];
			arr[start] = temp;
			start++;
			end--;
		}
		System.out.println(Arrays.toString(arr));
		
	}
}
