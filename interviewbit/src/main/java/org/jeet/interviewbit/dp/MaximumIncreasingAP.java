package org.jeet.interviewbit.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumIncreasingAP {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public static int solve(final List<Integer> A) {
		if(A==null) return 0;
		int n = A.size();
		if(n<3) return n;
		int[][] dp = new int[n][n];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		dp[0][0]=1;
		int res=0;
		for(int i=1; i<n; i++){
			map.put(A.get(i-1), i-1);
			for(int j=i+1; j<n; j++){
				dp[i][j]=2;
				int need = 2*A.get(i) - A.get(j);
				if(map.containsKey(need)){
					dp[i][j]=Math.max(dp[i][j], dp[map.get(need)][i]+1);
					res=Math.max(res,dp[i][j]);
				}
			}
		}
		return res;
	}


	public static void main(String[] args) {

		ArrayList<Integer> A =new ArrayList<Integer>(Arrays.asList(100, 10, 8, 300, 6, 1, 4, 2));
		int i = solve(A);
		//		for (Integer i : A) {
		System.out.println(i);
		//		}

	}

	static class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
}
