package org.jeet.codeforces.div2_edu50;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PointsInSegment {
	
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		int n, m, x, y; 
		n = scanner.nextInt();
		m = scanner.nextInt();
		Set<Integer> set = new HashSet<Integer>(), res = new HashSet<Integer>();
		for (int i = 1; i <= n; i++) {
			x= scanner.nextInt();
			y= scanner.nextInt();
			for (int j = x; j <= y; j++) {
				set.add(j);
			}
		}
		for (int i = 1; i <= m; i++) {
			if(!set.contains(i)) {
				res.add(i);
			}
		}
		System.out.println(res.size());
		if(res.size()>0) {
			for (Integer integer : res) {
				System.out.print(integer+" ");
			}
		}
		scanner.close();
	}

}
