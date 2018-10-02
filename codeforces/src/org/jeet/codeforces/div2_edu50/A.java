package org.jeet.codeforces.div2_edu50;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long n = scan.nextLong();
		long k = scan.nextLong();
		System.out.println(((k-1)/n)+1);
		scan.close();
	}
}