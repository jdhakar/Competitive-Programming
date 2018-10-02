package org.jeet.codeforces.div3_501;

import java.util.Scanner;

public class WalkingBetweenHouses {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		long n, k, s; 
		n = scanner.nextLong();
		k = scanner.nextLong();
		s = scanner.nextLong();
		if(s<k || s>(n-1)*k) {
			System.out.println("NO");
		}
		else {
			System.out.println("YES");
			if(s%k==0) {
				long l=s/k;
				for(long i=0; i<k;i++) {
					if(i%2==0) {
						System.out.print(l);
					}
					else {
						System.out.print(1);
					}
					System.out.print(" ");
				}
			}
			else {
				long l=s/k;
				long rem=s%k, orig=s%k;
				long i=0;
				for(; i<k;i++) {
					if(i%2==0) {
						if(rem>0) {
							System.out.print(l+1);							
						}
						else {
							System.out.print(l);							
						}
					}
					else {
						System.out.print(1);
					}
					System.out.print(" ");
					rem--;
				}

			}
		}

		scanner.close();
	}

}
