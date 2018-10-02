package org.jeet.codechef.IOITC.div2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class A_SPELLBOB {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();

		for (int i = 0; i < t; i++) {
			String top = scanner.next();
			String bot = scanner.next();
			Set<Integer> sB = new HashSet<Integer>();
			Set<Integer> sO = new HashSet<Integer>();
			for(int j=0; j<3; j++) {
				if(top.charAt(j)=='b') {
					sB.add(j);
				}
				if(top.charAt(j)=='o') {
					sO.add(j);
				}
				if(bot.charAt(j)=='b') {
					sB.add(j);
				}
				if(bot.charAt(j)=='o') {
					sO.add(j);
				}
			}
			if(sB.size()>=2 && sO.size()>=1) {
				sB.addAll(sO);
				if(sB.size()>=3) {
					System.out.println("yes");
					continue;
				}
			}
			System.out.println("no");
		}

		scanner.close();
	}
}