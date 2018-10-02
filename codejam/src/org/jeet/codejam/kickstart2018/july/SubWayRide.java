package org.jeet.codejam.kickstart2018.july;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
 
class SubWayRide {
 
	private static final Scanner scanner = new Scanner(System.in);
 
	private static ArrayList<HashMap<Integer, HashSet<Integer>>> graph = new ArrayList<HashMap<Integer, HashSet<Integer>>>();
	private static ArrayList<HashMap<Integer, Integer>> maxMap = new ArrayList<HashMap<Integer, Integer>>();
 
	public static void main(String[] args) {
		int c, m, n, x, y, T; 
		n = scanner.nextInt();
		m = scanner.nextInt();
 
		for (int i = 0; i <= n; i++) {
			graph.add(new HashMap<Integer, HashSet<Integer>>());
			maxMap.add(new HashMap<Integer, Integer>());
		}
 
		for (int i = 0; i < m; i++) {
			x=scanner.nextInt();
			y=scanner.nextInt();
			c=scanner.nextInt();
 
			if(!graph.get(x).containsKey(y)) {
				graph.get(x).put(y, new HashSet<Integer>());
			}
			graph.get(x).get(y).add(c);
 
			if(!graph.get(y).containsKey(x)) {
				graph.get(y).put(x, new HashSet<Integer>());
			}
			graph.get(y).get(x).add(c);
		}
 
		T=scanner.nextInt();
 
		for (int i = 0; i < T; i++) {
			x=scanner.nextInt();
			y=scanner.nextInt();
 
			if(!maxMap.get(x).containsKey(y) && !maxMap.get(y).containsKey(x)) {
				
				Queue<N> q = new LinkedList<N>();
				q.add(new N(x));
				boolean visited[]=new boolean[n+1];
				visited[x]=true;
				while(q.size()>0) {
					N cur=q.poll();
					for(Entry<Integer, HashSet<Integer>> e: graph.get(cur.n).entrySet()) {
						if(!visited[e.getKey()]) {
							visited[e.getKey()]=true;
							N curN = new N(e.getKey());
							int count=e.getValue().size();
 
							if(count>2 || (count==2 && cur.multi)) {
								curN.multi=true;
								curN.max=cur.max+1;
 
							} else {
								int curMax=0;
								for(int a: e.getValue()) {
									int nodeMax=0;
									if (cur.multi) {
										nodeMax=Math.max(nodeMax, cur.max+1);
										curN.maxMap.put(a, nodeMax);
									} else if(cur.maxMap.size()==0) {
										nodeMax=Math.max(nodeMax, cur.max);
										curN.maxMap.put(a, cur.max);
									} else {
										for(Entry<Integer, Integer> e1: cur.maxMap.entrySet()) {
											if(a!=e1.getKey()) {
												nodeMax=Math.max(nodeMax, e1.getValue()+1);
											}
											else {
												nodeMax=Math.max(nodeMax, e1.getValue());
											}
										}
 
										curN.maxMap.put(a, nodeMax);
										curMax=Math.max(curMax, nodeMax);
									}
								}
								curN.max=curMax;
							}
							maxMap.get(x).put(curN.n, curN.max);
							maxMap.get(curN.n).put(x, curN.max);
							q.add(curN);
						}
					}
				}
			}
 
			if(maxMap.get(y).containsKey(x)) {
				System.out.println(maxMap.get(y).get(x));
			} else if(maxMap.get(x).containsKey(y)) {
				System.out.println(maxMap.get(x).get(y));
			} else {
				System.out.println("0");
			}
		}
		scanner.close();
	}
 
	static class N{
		public int n;
		public int max;
		public boolean multi;
		public Map<Integer, Integer> maxMap;
		public N(int n_) {
			n=n_;
			maxMap=new HashMap<Integer, Integer>();
		}
 
	}
 
} 