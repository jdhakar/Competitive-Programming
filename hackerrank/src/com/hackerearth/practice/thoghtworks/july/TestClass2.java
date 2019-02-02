package com.hackerearth.practice.thoghtworks.july;

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
		String[] size = s.nextLine().split(" ");
		int n = Integer.valueOf(size[0]);
		int m = Integer.valueOf(size[1]);
		int[][] board = new int[n][m];
		for (int i = 0; i < board.length; i++) {
			String str = s.nextLine();
			for (int j = 0; j < m; j++) {
				board[i][j]=str.charAt(j)-'0';
			}
		}
		
		int count=0;
		for (int i = 0; i < n-7; i++) {
			for (int j = 0; j < m-7; j++) {
				int cur=board[i][j];
				boolean valid=true;
				for (int k = 0; k < 8; k++) {
					for (int k2 = 0; k2 < 8; k2++) {
						if(((k+k2)%2)==0){
							if(board[i+k][j+k2]!=cur) {
								valid=false;
								break;
							}
						} else {
							if(board[i+k][j+k2]==cur) {
								valid=false;
								break;
							}
						}
					}
					if(!valid) {
						break;
					}
				}
				if(valid) {
					count++;
				}
			}
		}
		System.out.println(count);
		
		s.close();
		
		// Write your code here

	}
}
