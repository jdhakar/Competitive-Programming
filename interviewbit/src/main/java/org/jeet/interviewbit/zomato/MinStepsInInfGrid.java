package org.jeet.interviewbit.zomato;

public class MinStepsInInfGrid {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static int coverPoints(int[] A, int[] B) {
    		int n= A.length;
    		int minSteps = 0;
    		for (int i = 1; i < A.length; i++) {
				minSteps+=Math.max(Math.abs(A[i]-A[i-1]), Math.abs(B[i]-B[i-1]));
		}
    		return minSteps;
    }
    

	public static void main(String[] args) {

		int[] A= {0,1,1};
		int[] B = {0,1,2};
		
		System.out.println(coverPoints(A,B));
	}
}
