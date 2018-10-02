package org.jeet.codeforces.div2_478;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ObtainingAString {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int n;
		n = scanner.nextInt();
		char[] s= new char[n],t= new char[n];
		s = scanner.next().toCharArray();
		t = scanner.next().toCharArray();	

		List<Integer> l = new LinkedList<Integer>();
		List<Character> sl = new ArrayList<Character>();
		List<Character> tl = new ArrayList<Character>();
		for (int i = 0; i < t.length; i++) {
			sl.add(s[i]);
			tl.add(t[i]);
		}

		int i=0, notPossible=0;
		while(i<n) {
			while(i<n && sl.get(i)==tl.get(i)) {
				i++;
			}
			if(i<n) {
				int j=i;
				while(j<n && sl.get(j)!=tl.get(i)) {
					j++;
				}
				if(j==n) {
					notPossible=-1;
					break;
				}
				else {
					for (int j2 = j; j2 > i; j2--) {
						l.add(j2);
					}
					sl.remove(j);
					sl.add(i, tl.get(i));
				}
			}
		}

		if(notPossible==0 && l.size()<=10000) {
			System.out.println(l.size());
			if(l.size()!=0) {
				for (int i1 : l) {
					System.out.print(i1+" ");
				}
			}
		}
		else {
			System.out.println("-1");
		}
		scanner.close();
	}

}
