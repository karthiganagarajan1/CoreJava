package com.pkg.ti;

public class PrimeNumber {

	public static void main(String[] args) {
		int number = 12;
		boolean isPrime = findPrime(number);
		System.out.println(isPrime ? "The given Number " + number + " is Prime Number"
				: "The given Number " + number + " is Not Prime Number");
	}

	private static boolean findPrime(int number) {
		if (number <= 1) {
			return false;
		}
		for (int i = 2; i < Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

}
