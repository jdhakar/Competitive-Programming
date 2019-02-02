package com.hackerearth.practice.thoghtworks.dec2018;

import java.util.LinkedList;
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

public class TestClass2 {
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
		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();
		for (int t = 0; t < tc; t++) {

			int n=s.nextInt(), u=s.nextInt(), v=s.nextInt();

			LinkedList<Integer> list[] = new LinkedList[n];
			for (int i = 0; i < list.length; i++) {
				list[i]=new LinkedList<Integer>();
			}
			for (int i = 0; i < n-1; i++) {
				int a=s.nextInt();
				int b=s.nextInt();
				list[u].add(a);
				list[v].add(b);
			}
			
			boolean[] visited=new boolean[n];
			
		}



		System.out.println(0);

		s.close();

		// Write your code here

	}
}
