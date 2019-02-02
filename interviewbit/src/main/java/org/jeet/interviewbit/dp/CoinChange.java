package org.jeet.interviewbit.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class CoinChange {
	// DO NOT MODIFY THE LIST. IT IS READ ONLYO
	public static int coinchange2(ArrayList<Integer> A, int B) {
		int n=A.size();
		int[] coins = new int[B+1];
		coins[0]=1;

		for(int i=0; i<n; i++){
			for(int j=A.get(i); j<=B; j++){
				coins[j]+=coins[j-A.get(i)];
			}
		}
		return coins[B];
	}

	public static void main(String[] args) {
		ArrayList<Integer> A =new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		int i = coinchange2(A, 4);
		System.out.println(i);
	}

}
