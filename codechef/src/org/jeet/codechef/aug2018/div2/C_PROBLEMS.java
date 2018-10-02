package org.jeet.codechef.aug2018.div2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

class C_PROBLEMS {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {	

		List<P> list = new LinkedList<P>();

		for (int i = 0; i <= 2; i++) {
			String ps[] = scanner.nextLine().split(" ");
			int p=Integer.valueOf(ps[0]);
			int s=Integer.valueOf(ps[1]);

			list.add(new P(p, s));
		}
		Collections.sort(list, Comparator.comparing(P::getX).thenComparing(P::getY).reversed());

		int maxCalls = 0, curCalls=0;
		for(P p: list){
			if(p.getY()==0){
				curCalls++;
			}
			else{
				curCalls--;
			}
			if(maxCalls>curCalls){
				maxCalls=curCalls;
			}
		}

		System.out.println(maxCalls);

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

	static List<Integer> sort_hotels(String keywords, List<Integer> hotel_ids, List<String> reviews) {

		String[] keys = keywords.split(" ");
		Set<String> keySet = new HashSet<String>();
		Map<Integer, Integer> hotelMap = new HashMap<Integer, Integer>();

		for(String s : keys) {
			s = s.replaceAll(".", "");
			s = s.replaceAll(",", "");
			keySet.add(s.toLowerCase());
		}

		for(int i=0; i<reviews.size(); i++) {
			String[] revKeys = reviews.get(i).split(" ");
			for(String s : revKeys) {
				if(keySet.contains(s.toLowerCase())) {
					int hotelId = hotel_ids.get(i);
					hotelMap.put(hotelId, hotelMap.getOrDefault(hotelId, 0));
				}
			}
		}
		
		List<P> list = new LinkedList<P>();

		for(int k : hotelMap.keySet()) {
			list.add(new P(hotelMap.get(k), k));
		}

		Collections.sort(list, Comparator.comparing(P::getX).thenComparing(P::getY).reversed());

		List<Integer> res = new ArrayList<Integer>();
		for(P p: list) {
			res.add(p.getY());
		}

		return res;

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