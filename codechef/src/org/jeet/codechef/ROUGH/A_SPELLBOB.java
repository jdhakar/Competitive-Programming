package org.jeet.codechef.ROUGH;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class A_SPELLBOB {

	public static void main(String[] args) {
		int i = 1000000;
		int j =1;
		while(i>0) {
			j<<=1;
			i>>=1;
		}
//		j<<=1;
		System.out.println(j);
		System.out.println(2^2);
	}
}