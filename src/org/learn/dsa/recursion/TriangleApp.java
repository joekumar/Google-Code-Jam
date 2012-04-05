package org.learn.dsa.recursion;

public class TriangleApp {

	/**
	 * Triangle # is sum of numbers till that x. For eg, if x = 3, Triangle (x) = 3 + 2 + 1;
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tri = 5;
		int triangleNumber = triangle(tri);
		System.out.println(" Triangle # of " +tri+" is "+triangleNumber);
	}

	public static int triangle (int intVal){
		if (intVal == 1){
			return 1;
		}
		
		return (intVal + triangle (intVal - 1));
	}
}
