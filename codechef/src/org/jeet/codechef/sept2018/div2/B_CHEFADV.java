package org.jeet.codechef.sept2018.div2;

import java.util.Scanner;

class B_CHEFADV {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();

		for (int i = 0; i < t; i++) {
			long n = scanner.nextLong()-1;
			long m = scanner.nextLong()-1;
			long x = scanner.nextLong();
			long y = scanner.nextLong();
			long n1=n%x;
			long m1=m%y;
			if(	
				(n==m && n<=1) || 
				(n1==m1 && n1<=1) || 
				(x==1 && n>0 && m1==1) || 
				(y==1 && m>0 && n1==1)
			) 
			{
				System.out.println("Chefirnemo");
			}
			else {
				System.out.println("Pofik");	
			}
		}

		scanner.close();
	}

}