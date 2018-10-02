package org.jeet.codechef.ROUGH;

import java.util.Scanner;
 
class E_KCOMPRES {
 
	private static final Scanner scanner = new Scanner(System.in);
	static long modulo=1000000007;

	public static void main(String[] args) {
		int T = scanner.nextInt();
		for(int i=0; i<T; i++) {
			long A = scanner.nextLong();
			long B = scanner.nextLong();
			long N = scanner.nextLong();
			if(A==B) {
				long res = (powerModuloMod(A, N, modulo)+powerModuloMod(B, N, modulo))%modulo;
				System.out.println(res);
			} else {
				long mod = Math.abs(A-B);
				long res = (powerModuloMod(A, N, mod) + powerModuloMod(B, N, mod))%mod;
				res = gcd(res, mod);
				System.out.println(res % modulo);
			}
		}
		scanner.close();
	}

//	static long powerModulo(long x, long y)
//	{
//		// Initialize result
//		long res = 1;     
//		x %= modulo;
//		while (y > 0)
//		{
//			if((y & 1)==1) res = (res * x) % modulo;
//			y = y >> 1; 
//			x = (x * x) % modulo; 
//		}
//		return res;
//	}

	static long gcd(long x, long y) {
		if(x==0) return y;
		return gcd(y%x, x);
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