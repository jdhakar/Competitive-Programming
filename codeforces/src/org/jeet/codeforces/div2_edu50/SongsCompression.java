package org.jeet.codeforces.div2_edu50;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SongsCompression {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int n;
		long m, x , y; 
		n = scanner.nextInt();
		m = scanner.nextLong();
		PriorityQueue<Long> pq = new PriorityQueue<Long>(Collections.reverseOrder());
		long xsum=0, ysum=0;
		for (int i = 0; i <n; i++) {
			x= scanner.nextLong();
			y= scanner.nextLong();
			xsum+=x;
			ysum+=y;
			pq.add(x-y);
		}
		if(ysum>m) {
			System.out.println("-1");
		}
		else {
			int resCount=0;
			while(pq.size()>0 && xsum>m) {
				xsum-=pq.poll();
				resCount++;
			}
			System.out.print(resCount);
		}
		scanner.close();
	}

}
