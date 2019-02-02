package org.jeet.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PlusOne {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static int[] coverPoints(int[] A) {
    		int n= A.length;

    		List<Integer> reversed = new ArrayList<Integer>();
    		Stack<Integer> rev = new Stack<Integer>();
    		    		
    		int i=0;
    		while(A[i]==0 && i<A.length) { i++; }
    		
    		for (; i < A.length; i++) {
    			rev.push(A[i]);
		}
    		int carry=1;
    		while(rev.size()>0) {
    			int k = rev.pop();
    			reversed.add((carry+k)%10);
    			carry = (k + carry)/10;
    		}
    		if (carry > 0) {
			reversed.add(carry);
		}
    		Collections.reverse(reversed);
    		return reversed.stream().mapToInt(j -> j).toArray();
    }
    

	public static void main(String[] args) {

		int[] A= {9,9,1};
		
//		System.out.println(coverPoints(A));
		for (int i : coverPoints(A)) {
			System.out.println(i);
		}
	}
}
