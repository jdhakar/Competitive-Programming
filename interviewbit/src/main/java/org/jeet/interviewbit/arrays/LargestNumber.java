package org.jeet.interviewbit.arrays;

import java.util.Arrays;

public class LargestNumber {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public static String solve(int[] A) {
		
//		List<Integer> listA = Arrays.stream(A).boxed().collect(Collectors.toList());
//		List<Integer> sorted = listA.stream().sorted((x,y)->((y+""+x).compareTo(x+""+y))).collect(Collectors.toList());
//		String res = sorted.stream().map(String::valueOf).reduce("", String::concat);
		
//		if(res.length() > 0 && res.charAt(0)=='0') {
//			return "0";
//		}
//		else {
//			return res;
//		}
		
		int[] B = A.clone();
		B = Arrays.stream(B).boxed().sorted((x, y) -> (y+""+x).compareTo(x+""+y)).mapToInt(i -> i).toArray();
		String res1="";
		for (int j : B) {
			res1 += j;
		}
		if(res1.length() > 0 && res1.charAt(0)=='0') {
			return "0";
		}
		else {
			return res1;
		}		
	}
	
	public static int comapreTo(int x, int y) {
		return (y+""+x).compareTo(x+""+y);
	}


	public static void main(String[] args) {

		int[] A= {3, 30, 34, 5, 9, 0};

//		int[] A= {2, 3, 4};

		System.out.println(solve(A));
		//		for (int i : solve(A)) {
		//			System.out.println(i);
		//		}
	}
}
