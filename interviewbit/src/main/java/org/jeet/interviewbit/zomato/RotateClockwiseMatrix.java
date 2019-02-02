package org.jeet.interviewbit.zomato;

import java.util.ArrayList;

public class RotateClockwiseMatrix {
	public void rotate(ArrayList<ArrayList<Integer>> a) {
	    int n = a.size();
	    for(int i=0; i<n/2; i++){
	        for (int j = 0; j < n; j++) {
	        		int k = a.get(i).get(j);
	        		a.get(i).set(j, a.get(n-i-1).get(j));
	        		a.get(n-i-1).set(j, k);
			}
	    }
	    for (int i = n-1; i>0; i--) {
			for (int j = 0; j <= n-1-i; j++) {
				int k = a.get(i+j).get(j);
        			a.get(i+j).set(j, a.get(j).get(i+j));
        			a.get(j).set(i+j, k);
			}
		}
	}
}