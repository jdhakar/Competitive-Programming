package org.jeet.codechef.ROUGH;

import java.util.Scanner;

class B_SHKNUM {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();

		for (int i = 0; i < t; i++) {
			long n = scanner.nextLong();
			if(n==1) {
				System.out.println(2);
				continue;
			}
			if((n & (n-1))==0){
				System.out.println(1);
			} else {
				long first=setBitNumber(n);
				long second=setBitNumber(n^first);
				long res = n^(first|second);
				if(first>second*2) {
					res=Math.min(res, second-res);
				}
				else {
					res=Math.min(res, second-res+1);
				}
				System.out.println(res);
			}
		}

		scanner.close();
	}


	static long setBitNumber(long n)
	{
		n |= n >> 1;
		n |= n >> 2; 
		n |= n >> 4;
		n |= n >> 8;
		n |= n >> 16;
		n |= n >> 32;
		return ((n+1) >> 1);
	}
}