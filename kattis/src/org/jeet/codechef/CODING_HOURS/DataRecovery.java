package org.jeet.codechef.CODING_HOURS;

import java.util.Scanner;

class DataRecovery {

	private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		int t = scanner.nextInt();

		for (int i = 1; i < t; i++) {
//			String s = scanner.next();
//			int n =s.length();
//			int mask=2;
//			long count=0;
//			while(n>=mask) {
//				count+=(long)(n-mask+1);
//				mask<<=1;
//			}
//			System.out.println(count);
			test(i);
			
		}
		scanner.close();
	}
	private static void test(int n) {
		int mask=2;
		long count=0;
		while(n>=mask) {
			count+=(long)(n-mask+1);
			mask<<=1;
		}
		System.out.println(count);
	}
}