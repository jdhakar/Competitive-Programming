package org.jeet.interviewbit.arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class NobleInteger {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public static int solve(int[] A) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i : A) {
			pq.add(i);
		}
		
		boolean found= false;
		while(pq.size()>0) {
			int k = pq.poll();
			while (pq.size()>0 && pq.peek()==k) {
				pq.poll();
			}
			if(pq.size()==k) {
				found=true;
				break;
			}
		}
				
		return found ? 1 : -1;

	}


	public static void main(String[] args) {

//		int[] A= {-3, -3, -2, 0, 0, 0};

		int[] A= {2, 3, 4};

		System.out.println(solve(A));
		//		for (int i : solve(A)) {
		//			System.out.println(i);
		//		}
	}
}
