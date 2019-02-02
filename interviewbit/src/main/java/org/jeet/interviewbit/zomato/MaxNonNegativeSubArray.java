package org.jeet.interviewbit.zomato;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MaxNonNegativeSubArray {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static int[] maxSet(int[] A) {
    		int n= A.length;
    		
    		int minStart=0, minEnd=0, curStart=0, cueEnd=0, curSum=0;
    		
    		int maxSum =0;
    		
    		for (int i = 0; i < A.length; i++) {
    			curStart=i;
    			curSum =0;
    			while(A[i]>=0 && i < A.length) {
    				
    			}
		}
    		
    		return new int[] {0} ;

    }
    

	public static void main(String[] args) {

		int[] A= {9,9,1};
		
//		System.out.println(coverPoints(A));
		for (int i : maxSet(A)) {
			System.out.println(i);
		}
	}
}
