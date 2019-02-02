package com.hackerearth.practice.pocketace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

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

public class TestClass {
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
		int tc = Integer.valueOf(s.nextLine());
		Set<Character> set = new HashSet<Character>();
		List<Character> l = Arrays.asList('a', 'A','e', 'E', 'i', 'I', 'o', 'O', 'u', 'U');
		set.addAll(l);
		List<String> in = new ArrayList<String>(), rs = new ArrayList<String>();
		
		for (int i = 0; i < tc; i++) {
			in.add(s.nextLine());
		}
		
		for (int i = 0; i < in.size(); i++) {
			String t = in.get(i);
			int n=t.length(), c=4;
			for (int j = 4; j < n-4; j++) {
				if(!set.contains(t.charAt(j))) {
					c++;
				}
			}
			rs.add(c+"/"+n);
		}
		
		for (String string : rs) {
			System.out.println(string);
		}
		// Write your code here

	}
}
