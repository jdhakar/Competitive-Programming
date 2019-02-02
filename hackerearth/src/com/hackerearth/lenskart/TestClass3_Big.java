package com.hackerearth.lenskart;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
 */

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

public class TestClass3_Big {
	public static void main(String args[] ) throws Exception {
		/* Sample code to perform I/O:
		 * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

		 */

		// Write your code here
		Scanner s = new Scanner(System.in);
		int T=s.nextInt();
		long modulo=1000000007;
		for (int t = 0; t < T; t++) {
			long a=s.nextLong(), b=s.nextLong(), c=s.nextLong(), d=s.nextLong(), m=s.nextLong();
			int n=s.nextInt();
			long[] A = new long[n];
			for (int i = 0; i < n; i++) {
				A[i]=s.nextLong();
			}
			if(m==1) {
				System.out.println(n*n);
				continue;
			}
			Map<Long, Long> map = new HashMap<Long, Long>();
			BigInteger aBig = new BigInteger(String.valueOf(a));
			BigInteger bBig = new BigInteger(String.valueOf(b));
			BigInteger cBig = new BigInteger(String.valueOf(c));
			BigInteger dBig = new BigInteger(String.valueOf(d));
			BigInteger mBig = new BigInteger(String.valueOf(m));
			for (long l : A) {
				BigInteger lBig = new BigInteger(String.valueOf(l));
				BigInteger curBig=BigInteger.ZERO;
				curBig=curBig.add(dBig);
				curBig=curBig.add(cBig.multiply(lBig));
				curBig=curBig.add(bBig.multiply(lBig).multiply(lBig));
				curBig=curBig.add(aBig.multiply(lBig).multiply(lBig).multiply(lBig));
				curBig=curBig.mod(mBig);
				long cur=Long.valueOf(curBig.toString());
				map.put(cur, map.getOrDefault(cur, 0L)+1L);
			}
			long res=0;
			for (long l : A) {
				long cur = (l*l)%m;
				if(map.containsKey(cur)) {
					res+=map.get(cur);
					res%=modulo;
				}
			}
			System.out.println(res);
		}
		s.close();
	}
}
