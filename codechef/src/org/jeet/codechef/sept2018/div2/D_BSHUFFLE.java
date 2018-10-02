package org.jeet.codechef.sept2018.div2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

class D_BSHUFFLE {

	private static final Scanner scanner = new Scanner(System.in);
	static long modulo=1000000007;

	public static void main(String[] args) {
		int Z = scanner.nextInt();
		//		for(int i=1; i<=N; i++) {
		//			System.out.print(i + " ");
		//		}
		//		System.out.print("\n");
		//		System.out.print(N + " ");
		//		for(int i=1; i<=N-1; i++) {
		//			System.out.print(i + " ");
		//		}
		//		System.out.print("\n");
		for(int N=1; N<=Z; N++) {
			System.out.println(N);
			ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> cur = new ArrayList<Integer>();
			permutations(N, 0, res, cur);
			Map<String, Integer> perCount = new HashMap<String, Integer>();
			cur.clear();
			for(int i=1; i<=N; i++) {
				cur.add(i);
			}
			for(ArrayList<Integer> a : res) {
				ArrayList<Integer> temp = new ArrayList<Integer>(cur);
				String k = permute(temp, a);
				perCount.put(k, perCount.getOrDefault(k,0)+1);
			}

			List<P> arr = new ArrayList<P>();
			for(Entry<String, Integer> e : perCount.entrySet()) {
				arr.add(new P(e.getValue(), e.getKey()));
			}
			Collections.sort(arr, Comparator.comparing(P::getX));

			int min = arr.get(0).x;
			int max = arr.get(arr.size()-1).x;

			for(P p: arr) {
				if(p.x==min || p.x==max)
					System.out.println(p);
			}
		}
		scanner.close();
	}

	private static String permute(ArrayList<Integer> temp, ArrayList<Integer> a) {
		int N=a.size();
		for(int i=1; i<=N; i++) {
			int swap=a.get(i-1);
			int t = temp.get(i-1);
			temp.set(i-1, temp.get(swap-1));
			temp.set(swap-1, t);
		}
		String res="";
		for(int i=0; i<N; i++) {
			res+=temp.get(i)+"_";
		}
		return res;
	}

	private static void permutations(int n, int i, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> cur) {

		ArrayList<Integer> curNew = new ArrayList<Integer>(cur);
		if(curNew.size()==n) {
			res.add(curNew);
		}
		else {
			for(int j=1; j<=n; j++) {
				curNew.add(j);
				permutations(n, i+1, res, curNew);
				curNew.remove(curNew.size()-1);
			}
		}
	}

	static class P{
		int x;
		String y;
		int getX() {
			return x;
		}
		String getY() {
			return y;
		}
		P(int x_, String y_){
			x=x_;
			y=y_;
		}
		@Override
		public String toString() {
			return "P [x=" + x + ", y=" + y + "]";
		}

	}

} 