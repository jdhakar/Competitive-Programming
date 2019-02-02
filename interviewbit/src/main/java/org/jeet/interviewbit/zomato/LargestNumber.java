package org.jeet.interviewbit.zomato;

import java.lang.*;
import java.util.*;

public class LargestNumber {
	
	static long product=1;
	static long maxHappy=0;
	static int maxSize=0;
	static int primeCount=0;
	static boolean[] primes = new boolean[1000001];
	
	public static void main(String[] args) {
		// YOUR CODE GOES HERE
		// Please take input and print output to standard input/output (stdin/stdout)
		// DO NOT USE ARGUMENTS FOR INPUTS
		// E.g. 'Scanner' for input & 'System.out' for output
		Scanner s = new Scanner(System.in);
		for (int i = 2; i < primes.length; i++) {
			primes[i]=true;
		}
		for (int i = 2; i < 1001; i++) {
			if(primes[i]) {
				for (int j = 2*i; j < primes.length; j+=i) {
					primes[j]=false;
				}
			}
		}

		int tc = s.nextInt();
		for (int t = 0; t < tc; t++) {

			int n = s.nextInt();
			int q = s.nextInt();
			S[] sets = new S[n];
			long[] happy = new long[n];
			for (int i = 0; i < happy.length; i++) {
				happy[i]=s.nextLong();
				sets[i]= new S(i, 0, happy[i], 1);
			}
			int[][] queries = new int[q][2];
			for (int i = 0; i < queries.length; i++) {
				queries[i][0]=s.nextInt()-1;
				queries[i][1]=s.nextInt()-1;
			}
			long[][] res = new long[q][3];
			for (int i = 0; i < res.length; i++) {
				int x=queries[i][0];
				int y=queries[i][1];
				int xp = findParent(sets, x);
				int yp = findParent(sets, y);
				if(xp!=yp) {
					union(sets, queries[i][0], queries[i][1]);
				}
				res[i][0]=maxHappy;
				res[i][1]=primeCount;
				res[i][2]=product;
			}
			
			for (int i = 0; i < res.length; i++) {
				System.out.println(res[i][0] + " " + res[i][1] + " " + res[i][2]);
			}
		}

		s.close();

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
		long curHappy = Math.max(sets[xp].h, sets[yp].h);
		int curSize=sets[yp].s+sets[xp].s;
		product*=(long)curSize;
		product /= ((long)sets[xp].s)*((long)sets[yp].s);
		if(primes[sets[yp].s]) primeCount--;
		if(primes[sets[xp].s]) primeCount--;
		if(primes[curSize]) primeCount++;
		if(curSize>=maxSize) {
			maxSize=curSize;
			maxHappy=Math.max(maxHappy, curHappy);
		}
		if(xr<yr) {
			sets[xp].p=yp;
			sets[yp].s=curSize;
			sets[yp].h=curHappy;
		} else {
			if(xr==yr) {
				sets[xp].r++;
			}
			sets[yp].p=xp;
			sets[xp].s=curSize;
			sets[xp].h=curHappy;

		}
	}

	static class S{
		public int p;
		public int r;
		public long h;
		public int s;
		public S(int p_, int r_, long h_, int s_) {
			p=p_;
			r=r_;
			h=h_;
			s=s_;
		}
	}
}