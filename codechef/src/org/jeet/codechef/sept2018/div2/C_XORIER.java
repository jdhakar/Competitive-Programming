package org.jeet.codechef.sept2018.div2;

import java.util.HashMap;
import java.util.Scanner;

class C_XORIER {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			long evenCount=0, oddCount=0, result=0;
			for (int j = 0; j < n; j++) {
				int x = scanner.nextInt();
				if(x%2==0) {
					result+=evenCount;
					evenCount++;
				}
				else {
					result+=oddCount;
					oddCount++;
				}
				int xCount = map.getOrDefault(x, 0);
				int xXORCount = map.getOrDefault(x^2, 0);
				result-=xCount + xXORCount;
				map.put(x, xCount+1);
			}
			System.out.println(result);
		}

		scanner.close();
	}

}