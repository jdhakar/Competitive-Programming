package org.jeet.codechef.sept2018.div2;

import java.util.Scanner;

class A_MAGICHF {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();

		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			int g = scanner.nextInt();
			int s = scanner.nextInt();
			for (int j = 0; j < s; j++) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				if(x==g) {
					g = y;
				} else if (y==g) {
					g = x;
				}
				
			}
			System.out.println(g);
		}

		scanner.close();
	}
}