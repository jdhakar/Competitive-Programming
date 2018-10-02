package org.jeet.codeforces.div3_498;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MilitaryProblem {
	
	private static final Scanner scanner = new Scanner(System.in);
	private static Map<Integer, Integer> lengthSubtree = new HashMap<Integer, Integer>();
	private static Map<Integer, Integer> startSubtree = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		
		int n,q,t; 
		n = scanner.nextInt();
		q = scanner.nextInt();
		Map<Integer, N> graph = new HashMap<Integer, N>();
		
		for (int i = 1; i <= n; i++) {
			graph.put(i, new N(i));
		}
		for (int i = 2; i <= n; i++) {
			t = scanner.nextInt();
			graph.get(t).addN(graph.get(i));
		}
		
		List<Integer> res = dfsHelper(graph.get(1), 1);
		
		int u,k;
		for (int i = 0; i < q; i++) {
			u = scanner.nextInt();
			k = scanner.nextInt();
			if(lengthSubtree.get(u)<k) {
				System.out.println("-1");
			}
			else {
				System.out.println(res.get(startSubtree.get(u)-1+k-1));
			}
		}
		
		scanner.close();
	}
	
	private static List<Integer> dfsHelper(N n, int start) {
		startSubtree.put(n.n, start);
		List<Integer> ret = new LinkedList<Integer>();
		ret.add(n.n);
		if(n.near.size()>0) {
			for(N n1: n.near) {
				ret.addAll(dfsHelper(n1, start+ret.size()));
			}
		}
		lengthSubtree.put(n.n, ret.size());
		return ret;
	}

	static class N{
		public int n;
		public List<N> near;
		public boolean block;
		public N(int n_) {
			n=n_;
			near=new LinkedList<N>();
		}
		public void addN(N n_) {
			near.add(n_);
		}

	}

}
