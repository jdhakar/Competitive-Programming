package org.jeet.quora.challenges;

import java.util.Arrays;
import java.util.Scanner;

public class Upvotes {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int c, k, n, v, x, y, t, xp, yp; 
		n = scanner.nextInt();
		k = scanner.nextInt();
		
		int[] arr = new int[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i]=scanner.nextInt();
		}
		int[] incr = new int[n], decr = new int[n], incrRev= new int[n], decrRev = new int[n];
		Arrays.fill(incr, 1);
		Arrays.fill(decr, 1);
		Arrays.fill(incrRev, 1);
		Arrays.fill(decrRev, 1);
		for(int i=1; i<n; i++) {
			if(arr[i]>=arr[i-1]) {
				incr[i]+=incr[i-1];
			}
			if(arr[i]<=arr[i-1]) {
				decr[i]+=decr[i-1];
			}
			if(arr[n-i-1]<=arr[n-i]) {
				incrRev[n-i-1]+=incrRev[n-i];
			}
			if(arr[n-i-1]>=arr[n-i]) {
				decrRev[n-i-1]+=decrRev[n-i];
			}
		}
		int res[] = new int[n-k+1];
		for(int i=0; i<k; i++) {
			res[0]+=incr[i]-decr[i];
		}
		for(int i=1; i<n-k+1; i++) {
			res[i]=incr[k+i-1]-incrRev[i-1]-decr[k+i-1]+decrRev[i-1]+res[i-1];
		}
		for(int i=0; i<n-k+1; i++) {
			System.out.println(res[i]);
		}
		scanner.close();
	}

}