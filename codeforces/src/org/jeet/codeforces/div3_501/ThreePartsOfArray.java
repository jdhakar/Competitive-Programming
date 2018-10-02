package org.jeet.codeforces.div3_501;

import java.util.Scanner;

public class ThreePartsOfArray {
	
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		int n; 
		n = scanner.nextInt();
		long[] arr = new long[n];
		
		for (int i = 0; i < n; i++) {
			arr[i]= scanner.nextLong();
		}

		long leftsum=0, rightsum=0;
		for (long l : arr) {
			rightsum+=l;
		}
		int i=0;
		while(leftsum<rightsum) {
			leftsum+=arr[i];
			rightsum-=arr[i];
			i++;
		}
		i--;
		int rightI=i+1;
		while(leftsum!=rightsum) {
			while(rightsum<leftsum) {
				leftsum-=arr[i];
				i--;
			}
			while(leftsum<rightsum) {
				rightsum-=arr[rightI];
				rightI++;
			}
		}
		System.out.println(leftsum);
		
		scanner.close();
	}

}
