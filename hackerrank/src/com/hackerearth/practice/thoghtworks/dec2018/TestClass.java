package com.hackerearth.practice.thoghtworks.dec2018;

import java.util.PriorityQueue;
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

class TestClass {
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
		
		boolean[] magical = new boolean[1018082],primes=new boolean[1010];

		for (int i = 2; i < primes.length; i++) {
			primes[i]=true;
		}
		for (int i = 2; i < 35; i++) {
			if(primes[i]) {
				for (int j = 2*i; j < primes.length; j+=i) {
					primes[j]=false;
				}
			}
		}
		for (int i = 0; i < primes.length; i++) {
			for (int j = i; j < primes.length; j++) {
				if(primes[i] && primes[j] && i*j<magical.length) {
					magical[i*j]=true;
				}
			}
		}

		int n = s.nextInt(), k=s.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=s.nextInt();
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
//		for (int i = 0; i < arr.length; i++) {
//			int cur=arr[i];
//			int lessOp=0;
//			while(cur-lessOp>0 && !magical[cur-lessOp]) {
//				lessOp++;
//			}
//			if(cur-lessOp==0) {
//				lessOp=Integer.MAX_VALUE;
//			}
//			int moreOp=0;
//			while(cur+moreOp<magical.length && !magical[cur+moreOp]) {
//				moreOp++;
//			}
//			if(cur+moreOp==magical.length) {
//				moreOp=Integer.MAX_VALUE;
//			}
//			
//			pq.add(Math.min(lessOp, moreOp));			
//		}
		
		for (int i = 0; i < arr.length; i++) {
			int cur=arr[i];
			int lessOp=0, sqrt=(int)Math.sqrt(cur);
			int sqrt1=sqrt, sqrt2=sqrt;
			if(sqrt*sqrt!=i) {
				sqrt2++;
			}

			while(sqrt1>1 && !primes[sqrt1]) {
				sqrt1--;
			}
			if(sqrt1==1) {
				lessOp=Integer.MAX_VALUE;
			} else {
				lessOp=cur-sqrt1*sqrt1;
			}
			int moreOp=0;
			while(sqrt2<primes.length && !primes[sqrt2]) {
				sqrt2++;
			}
			if(sqrt2==primes.length) {
				moreOp=Integer.MAX_VALUE;
			}  else {
				moreOp=sqrt2*sqrt2-cur;
			}
			
			pq.add(Math.min(lessOp, moreOp));			
		}
		
		int res=n-k;
		for (int i = 0; i < k; i++) {
			res+=pq.poll();
		}
		System.out.println(res);
		
		s.close();

    }
}
