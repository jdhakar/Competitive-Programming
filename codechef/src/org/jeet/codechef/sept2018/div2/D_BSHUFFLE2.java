package org.jeet.codechef.sept2018.div2;

import java.util.ArrayList;
import java.util.Scanner;

class D_BSHUFFLE2 {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int N = scanner.nextInt();
		if(N==1) {
			System.out.println(1);
			System.out.println(1);
		}
		else {
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for(int i=1; i<=N; i++) {
				arr.add(i);
			}
			arr.remove(0);
			arr.add(N/2-1, 1);
			arr.remove(N/2);
			arr.add(N-1, N/2+1);
			for(int i=1; i<=N; i++) {
				System.out.print(arr.get(i-1) + " ");
			}
			System.out.print("\n");
			System.out.print(N + " ");
			for(int i=1; i<=N-1; i++) {
				System.out.print(i + " ");
			}
		}
		scanner.close();
	}
} 