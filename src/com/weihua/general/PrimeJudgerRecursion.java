package com.weihua.general;

/*
 * check if a number is prime using recursion
 */
public class PrimeJudgerRecursion {

	public static void main(String[] args) {
		PrimeJudgerRecursion test = new PrimeJudgerRecursion();
		System.out.println(test.isPrime(1));
		System.out.println(test.isPrime(2));
		System.out.println(test.isPrime(3));
		System.out.println(test.isPrime(100));

	}
	
	public boolean isPrime(int input) {
		return isPrime(input, 2);
	}
	
	private boolean isPrime(int input, int divider) {
		if (input <= 1) {
			return false;
		}
		
		if (divider > Math.sqrt(input)) {
			return true;
		} else {
			if (input % divider == 0) {
				return false;
			} else {
				return isPrime(input, divider -1);
			}
		}
	}

}
