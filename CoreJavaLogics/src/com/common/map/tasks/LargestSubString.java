package com.common.map.tasks;

import java.util.HashSet;
import java.util.Set;

public class LargestSubString {
	public static void main(String[] args) {
		String s = "aabcdeeb";
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int i = 0;
		int j = 0;
		int maxLength = 0;
		while (i < n && j < n) {
			if (!set.contains(s.charAt(j))) {
				Character c = s.charAt(j++);
				set.add(c);
				maxLength = Math.max(maxLength, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		System.out.println(maxLength);
	}

}
