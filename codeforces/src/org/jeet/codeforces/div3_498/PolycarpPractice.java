package org.jeet.codeforces.div3_498;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PolycarpPractice {
	
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		int n, k; 
		n = scanner.nextInt();
		k = scanner.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i]= scanner.nextInt();
		}

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < n; i++) {
			if(pq.size()==k) {
				if(arr[i]>pq.peek()) {
					pq.poll();
				}
				else {
					continue;
				}
			}
			pq.add(arr[i]);
		}
		Map<Integer, Integer> set = new HashMap<Integer, Integer>();
		
		int pre=0, resSum=0;
		ArrayList<Integer> res= new ArrayList<Integer>();
		for(int i:pq) {
			resSum+=i;
			set.put(i, set.getOrDefault(i, 0)+1);
		}
		for (int i = 0; i < n; i++) {
			if(set.containsKey(arr[i])) {
				if(set.size()==1 && set.get(arr[i])==1) {
					continue;
				}
				res.add(i-pre+1);
				pre=i+1;
				set.put(arr[i],set.get(arr[i])-1);
				if(set.get(arr[i])==0) {
					set.remove(arr[i]);
				}
			}
		}
		res.add(n-pre);
		System.out.println(resSum);
		for(int i:res) {
			System.out.print(i+" ");
		}
		
		scanner.close();
	}

}
