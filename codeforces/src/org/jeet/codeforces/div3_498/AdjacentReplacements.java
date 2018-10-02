package org.jeet.codeforces.div3_498;

import java.util.Scanner;

public class AdjacentReplacements {
	
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		int n, t; 
		n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			t= scanner.nextInt();
			if(t%2==0) {
				System.out.println(t-1);
			}
			else {
				System.out.println(t);
			}
		}
		scanner.close();
	}

}
