package org.jeet.interviewbit.arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MaxAbsoluteDiff {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public static  int spiralOrder(final ArrayList<Integer> A) {
//		int n = A.size();
//		int ret = 0;        
//        for (int i = 0; i < A.size(); i++) {
//			for (int j = 0; j < A.size(); j++) {
//				ret = Math.max(ret, Math.abs(A.get(i)-A.get(j))+j-1);
//			}
//		}

		// max and min variables as described
		// in algorithm.
		int max1 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE;
		int max2 = Integer.MIN_VALUE;
		int min2 = Integer.MAX_VALUE;

		for (int i = 0; i < A.size(); i++)
		{
			// Updating max and min variables as described in algorithm.
			max1 = Math.max(max1, A.get(i) + i);
			min1 = Math.min(min1, A.get(i) + i);
			max2 = Math.max(max2, A.get(i) - i);
			min2 = Math.min(min2, A.get(i) - i);
		}

		// Calculating maximum absolute difference.
		return Math.max(max1 - min1, max2 - min2);
	}

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.addAll(Arrays.asList(1,3,-1));

		System.out.println(spiralOrder(a));
	}
}
