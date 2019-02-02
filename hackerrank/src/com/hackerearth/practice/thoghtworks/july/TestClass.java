package com.hackerearth.practice.thoghtworks.july;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
		int n = s.nextInt();
		boolean visited[] = new boolean[n+1], primes[]= new boolean[n+1];
		int nsqrt = (int)Math.sqrt(n) + 1;
		for (int i = 2; i < primes.length; i++) {
			primes[i]=true;
		}
		for (int i = 2; i <= nsqrt && i< primes.length; i++) {
			if(primes[i]) {
				for (int j = 2*i; j < primes.length; j+=i) {
					primes[j]=false;
				}
			}
		}
		List<Integer> primeL= new ArrayList<Integer>();
		for (int i = 0; i < primes.length; i++) {
			if(primes[i]) {
				primeL.add(i);
			}
		}

		List<List<Integer>> graph = new ArrayList<List<Integer>>();
		for(int i=0; i<=n; i++) {
			graph.add(new LinkedList<Integer>());
		}
		for (int i = 0; i < n-1; i++) {
			int u=s.nextInt();
			int v=s.nextInt();
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		int res=0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		visited[1]=true;
		while(!q.isEmpty()) {
			int cur=q.poll();
			int curSum=0;
			for (int i : graph.get(cur)) {
				if(!visited[i]) {
					curSum+=i;
					visited[i]=true;
					q.add(i);
				}
			}
			if(curSum<2) {
				continue;
			} else if(curSum<4) {
				res++;
				continue;
			}
			int curSumSqrt = (int)Math.sqrt(curSum)+1;
			for (int j = 0; j < primeL.size(); j++) {
				if(primeL.get(j)>curSumSqrt) {
					res++;
					break;
				} else if(curSum%primeL.get(j)==0) {
					break;
				}
			}
		}
		System.out.println(res);
		s.close();
	}
}
