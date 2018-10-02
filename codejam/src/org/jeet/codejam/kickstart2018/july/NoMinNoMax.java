package org.jeet.codejam.kickstart2018.july;

import java.util.Arrays;
import java.util.Scanner;
 
public class NoMinNoMax {
 
	private static final Scanner scanner = new Scanner(System.in);
	static long modulo=1000000007;
 
	public static void main(String[] args) {
		int T = Integer.valueOf(scanner.nextLine());
		for(int i=0; i<T; i++) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			long[] ns = new long[n];
			for (int j = 0; j < n; j++) {
				ns[j]=scanner.nextLong();
			}
			Arrays.sort(ns);
			long[][] nCk= new long[n+1][k+1];
			for(int a=0; a<n; a++) {
				for(int b=0; b<=a && b<=k; b++) {
		            if (b == 0 || b == a)
		                nCk[a][b] = 1;
		            else
		                nCk[a][b] = (nCk[a-1][b-1] + nCk[a-1][b])%(modulo-1);
				}
			}
			long res=1;
			for(int j=2; j<=n/2; j++) {
				long key=ns[j-1]*ns[n-j], raise=0;
				for(int l=1; l<j && l<k-1; l++) {
					//pow(key, (j-1)Cl * (n-j)C(k-l-1), 10ˆ9+7)
					raise+=(nCk[j-1][l]*nCk[n-j][k-l-1])%(modulo-1);
				}
				raise%=(modulo-1);
				res*=power(key, raise);
				res%=modulo;
			}
			if(n%2==1) {
				int j=(n+1)/2;
				long key=ns[j-1], raise=0;	
				for(int l=1; l<j && l<k-1; l++) {
					raise+=(nCk[j-1][l]*nCk[n-j][k-l-1])%(modulo-1);
					//pow(key, (j-1)Cl * (n-j)C(k-l-1), 10ˆ9+7)
				}
				raise%=modulo-1;
				res*=power(key, raise);
				res%=modulo;
			}
			System.out.println(res);
		}
		scanner.close();
	}
	
	static long power(long x, long y)
    {
        // Initialize result
        long res = 1;     
        x = x % modulo; 
        while (y > 0)
        {
            if((y & 1)==1) res = (res * x) % modulo;
            y = y >> 1; 
            x = (x * x) % modulo; 
        }
        return res;
    }
} 