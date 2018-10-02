package org.jeet.kattis.challenges;

import java.util.Scanner;

class A_PHONE_NUMBERS {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();

		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			Trie root = new Trie();
			boolean valid = true;
			for (int j = 0; j < n; j++) {
				String s=scanner.next();
				if(!valid) continue;
				Trie temp = root;
				for (char c : s.toCharArray()) {
					temp=temp.childs[c-'0'];
					if(temp==null || temp.leaf) {
						break;
					}
				}
				if(temp != null) {
					valid = false;
					continue;
				}
				temp = root;
				for (char c : s.toCharArray()) {
					if(temp.childs[c-'0']==null) {
						temp.childs[c-'0']= new Trie();
					}
					temp=temp.childs[c-'0'];
				}
				temp.leaf=true;	
			}
			if(!valid) {
				System.out.println("NO");
			}
			else {
				System.out.println("YES");
			}

		}

		scanner.close();
	}
	
	static class Trie {
		public boolean leaf=false;
		public Trie[] childs = new Trie[10];
		Trie() {
			
		}
	}
}