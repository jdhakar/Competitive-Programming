package com.hackerearth.lenskart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());
		for(int t_i=0; t_i<T; t_i++)
		{
			int N = Integer.parseInt(br.readLine().trim());
			String[] arr_A = br.readLine().split(" ");
			long[] A = new long[N];
			for(int i_A=0; i_A<arr_A.length; i_A++)
			{
				A[i_A] = Long.parseLong(arr_A[i_A]);
			}

			int out_ = solve(A,N);
			System.out.println(out_);
			System.out.println("");
		}

		wr.close();
		br.close();
	}

	static int solve(long[] A,int N){
		// Write your code here
		long modulo=1000000007;
		if(N==1) {
			if(A[0]>=1) {
				return (int)(A[0]%modulo);
			} else {
				return 0;
			}
		} else if(N<61) {
			long pow2=1<<N-1, sum=0;
			for (long l : A) {
				if(l>=pow2) {
					sum+=l;
					sum%=modulo;
				}
			}
			return (int)sum;
		} else {
			return 0;
		}
	}

	static long powerModuloMod(long x, long y, long mod)
	{
		// Initialize result
		long res = 1;     
		x %= mod;
		while (y > 0)
		{
			if((y & 1)==1) {
				res = (res * x) % mod;
			}
			y = y >> 1;
		x %= mod;
		x = (x * x) % mod; 
		}
		return res;
	}
}
