package org.jeet.codechef.aug2018.div2;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class C_PROBLEMS {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String ps[] = scanner.nextLine().split(" ");
		int p=Integer.valueOf(ps[0]);
		int s=Integer.valueOf(ps[1]);
		List<P> ranks = new LinkedList<P>();
		for (int i = 1; i <= p; i++) {
			String scores = scanner.nextLine();
			String solved = scanner.nextLine();
			
			int r = getRank(scores.split(" "), solved.split(" "), s) ;
			ranks.add(new P(i,r));
		}

		Collections.sort(ranks, Comparator.comparing(P::getY).thenComparing(P::getX));
		
		for (P p2 : ranks) {
			System.out.println(p2.getX());
		}

		scanner.close();
	}

	private static int getRank(String[] scores, String[] solved, int s) {
		List<P> l = new LinkedList<P>();
		for(int i=0; i< s; i++) {
			l.add(new P(Integer.valueOf(scores[i]), Integer.valueOf(solved[i])));
		}
		Collections.sort(l, Comparator.comparing(P::getX));
		int n=0;
		for(int i=0; i<s-1; i++) {
			if(l.get(i).getY()>l.get(i+1).getY()) {
				n++;
			}
		}
		
		return n;
	}

	static class P{
		int x;
		int y;
		int getX() {
			return x;
		}
		int getY() {
			return y;
		}
		P(int x_, int y_){
			x=x_;
			y=y_;
		}
	}

}