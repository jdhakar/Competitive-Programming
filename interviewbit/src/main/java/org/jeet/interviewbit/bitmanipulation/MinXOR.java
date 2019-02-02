package org.jeet.interviewbit.bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinXOR {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public static int findMinXor(ArrayList<Integer> A) {
		int len = A.size();
		Collections.sort(A);
		int minXOR = Integer.MAX_VALUE;
		for (int i = 0; i < len-1; i++) {
			minXOR=Math.min(minXOR, A.get(i)^A.get(i+1));
		}
		return minXOR;
	}


	public static void main(String[] args) {
		ArrayList<Integer> A= new ArrayList<Integer>(Arrays.asList(0, 2, 5, 7));
		System.out.println(findMinXor(A));
	}
}
