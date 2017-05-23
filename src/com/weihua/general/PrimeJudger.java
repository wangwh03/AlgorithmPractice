package com.weihua.general;

/*
 * check if a number is prime. 
 * loop through 2 to the square root
 */
public class PrimeJudger {
	public static void main(String[] args) {
		PrimeJudger primeTester = new PrimeJudger();
		System.out.println(primeTester.isPrime(0));
		System.out.println(primeTester.isPrime(1));
		System.out.println(primeTester.isPrime(4));
		System.out.println(primeTester.isPrime(-1));
		System.out.println(Math.sqrt(-2));
		System.out.println(Math.sqrt(0));
		Double test = Double.NaN;
		System.out.println(test > 1);
	}
	
	public boolean isPrime(int input) {
		if (input <= 1) {
			return false;
		}
		
		for (int i = 2; i <= Math.sqrt(input); i++) {
			if (input % i == 0) {
				return false;
			}
		}
		return true;
	}
}
