package org.jeet.codechef.IOITC.div2;

import java.util.Scanner;

class ChangingNumbers {

	private static final Scanner scanner = new Scanner(System.in);
	private static final long modulo=1000000007;

	public static void main(String[] args) {
		int n, x, y, t, k, xp, yp; 
		t = scanner.nextInt();

		for (int i = 0; i < t; i++) {
			n = scanner.nextInt();
			k = scanner.nextInt();
			int[] a1=new int[n], a2=new int[n];
			boolean[] visited = new boolean[n+1];
			S[] sets = new S[n+1];
			for (int j = 0; j < n; j++) {
				a1[j]=scanner.nextInt();
			}
			for (int j = 0; j < n; j++) {
				a2[j]=scanner.nextInt();
			}
			for (int j = 0; j <= n; j++) {
				sets[j]=new S(j, 0);
			}
			int count=0;
			for (int j = 0; j < n; j++) {
				x=a1[j];
				y=a2[j];
				if(x!=y) {
					xp = findParent(sets, x);
					yp = findParent(sets, y); 
					if(xp != yp) {
						count++;
						union(sets, xp, yp);
					}
				}
			}
			if(k==1) {
				System.out.println(count);
			}
			else {
				if(count==0) {
					System.out.println("0 0");
				}
				else {
					long pow2=1, fact=1;
					for(long j=1; j<=count; j++) {
						pow2=(pow2*2)%modulo;
						fact=(fact*j)%modulo;
					}
					System.out.println(count + " " + (pow2*fact)%modulo);
				}
			}

		}

		scanner.close();
	}

	static int findParent(S[] sets, int x) {
		if(sets[x].p!=x) 
			sets[x].p=findParent(sets, sets[x].p);
		return sets[x].p;
	}
	
	static void union(S[] sets, int x, int y) {
		int xp = findParent(sets, x);
		int yp = findParent(sets, y);
		int xr = sets[xp].r;
		int yr = sets[yp].r;
		if(xr<yr) {
			sets[xp].p=yp;
		} else if(yr<xr) {
			sets[yp].p=xp;
		} else {
			sets[xp].r++;
			sets[yp].p=xp;
		}
	}
	
	static class S{
		public int p;
		public int r;
		public S(int p_, int r_) {
			p=p_;
			r=r_;
		}
	}

}