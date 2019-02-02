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
		int n = Integer.valueOf(s.nextLine()), count_0=0, count_1=0, max=0;
		String s1 = s.nextLine();
		Map<Integer, Integer> diffMap = new HashMap<Integer, Integer>();
		diffMap.put(0, -1);
		for(int i=0; i<n; i++) {
			if(s1.charAt(i)=='0') {
				count_0++;
			} else {
				count_1++;
			}
			if(count_0>count_1) {
				max=i+1;
			} else {
				int diff=count_1-count_0;
				if(diffMap.containsKey(diff+1)) {
					max=Math.max(max, i-diffMap.get(diff+1));
				}
				if(!diffMap.containsKey(diff)) {
					diffMap.put(diff, i);
				}
			}
		}
		System.out.println(max);
		s.close();
	}
}
