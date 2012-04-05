package org.learn.dsa.recursion;

public class Factorial {

	/**
	 * Factorial # is product of numbers till that x. For eg, if x = 3,
	 * Factorial (x) = 3 + 2 + 1;
	 */
	public static void main(String[] args) {
		int fact = 5;
		int factorialNumber = factorial(fact);
		System.out.println(" factorial of " +fact+" is " + factorialNumber);
	}

	public static int factorial(int intVal) {
		if (intVal == 1) {
			return 1;
		}

		return (intVal * factorial(intVal - 1));
	}

}
