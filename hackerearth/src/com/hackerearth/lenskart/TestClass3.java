package com.hackerearth.lenskart;

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

public class TestClass3 {
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
			Map<Long, Long> map = new HashMap<Long, Long>();
			a%=m;
			b%=m;
			c%=m;
			d%=m;
			for (long l : A) {
				l%=m;
				long aL = (((l*l)%m)*((a*l)%m))%m;
				long bL = (((l*l)%m)*b)%m;
				long cL = (c*l)%m;
				long cur = (aL+bL+cL+d)%m;
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
