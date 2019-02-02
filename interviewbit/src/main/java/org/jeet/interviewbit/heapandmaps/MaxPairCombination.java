package org.jeet.interviewbit.heapandmaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxPairCombination {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
    		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    		int n=A.size();
    		for(int i: A) {
    			for(int j:B) {
    				if(pq.size()<n) {
    					pq.add(i+j);
    				}
    				else {
    					if(i+j > pq.peek()) {
    						pq.poll();
    						pq.add(i+j);
    					}
    				}
    			}
    		}
    		ArrayList<Integer> res =new ArrayList<Integer>();
    		int i=0;
    		while(i<n) {
    			res.add(pq.poll());
    			i++;
    		}
    		Collections.reverse(res);
    		return res;
    }

	public static void main(String[] args) {
		
		ArrayList<Integer> A =new ArrayList<Integer>(Arrays.asList(1,4,2,3));
		ArrayList<Integer> B =new ArrayList<Integer>(Arrays.asList(2,5,1,6));
		A = solve(A, B);
		for (Integer i : A) {
			System.out.println(i);
		}

	}
	
	static class ListNode {
			public int val;
			public ListNode next;
			ListNode(int x) { val = x; next = null; }
	}
}
