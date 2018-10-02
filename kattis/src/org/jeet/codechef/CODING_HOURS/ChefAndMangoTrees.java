package org.jeet.codechef.CODING_HOURS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

class ChefAndMangoTrees {

	static int parent[];
	static int childCount[];
	static HashMap<Integer, LinkedList<Integer>> childs = new HashMap<Integer, LinkedList<Integer>>();
	private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		parent = new int[n+1];
		childCount = new int[n+1];
		for (int i = 1; i <= m; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			parent[y]=x;
			if(!childs.containsKey(x)) {
				childs.put(x, new LinkedList<Integer>());
			}
			childs.get(x).add(y);			
		}
		int Q=scanner.nextInt();
		for (int i = 1; i <= Q; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			if(parent[x]==y) {
				System.out.println(countChildred(x));
			}
			else {
				System.out.println(countChildred(y));
			}
		}
		scanner.close();
	}

	private static int countChildred(int x) {
		if(childCount[x]==0) {
			int count=1;
			if(childs.containsKey(x)){
				for (int i : childs.get(x)) {
					count+=countChildred(i);
				}
			}
			childCount[x]=count;
		}
		return childCount[x];
	}
}