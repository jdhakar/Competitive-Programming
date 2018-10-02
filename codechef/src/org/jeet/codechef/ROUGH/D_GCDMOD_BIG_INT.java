package org.jeet.codechef.ROUGH;

import java.math.BigInteger;
import java.util.Scanner;
 
class D_GCDMOD_BIG_INT {
 
	private static final Scanner scanner = new Scanner(System.in);
	static BigInteger modulo=new BigInteger("1000000007");

	public static void main(String[] args) {
		int T = scanner.nextInt();
		for(int i=0; i<T; i++) {
			BigInteger A = new BigInteger(scanner.next());
			BigInteger B = new BigInteger(scanner.next());
			long N = scanner.nextLong();
			if(A.equals(B)) {
				BigInteger res = (powerModuloMod(A, N, modulo).add(powerModuloMod(B, N, modulo))).mod(modulo);
				System.out.println(res);
			} else {
				BigInteger mod = A.subtract(B);
				BigInteger res = (powerModuloMod(A, N, mod).add(powerModuloMod(B, N, mod))).mod(mod);
				res = mod.gcd(res);
				System.out.println(res.mod(modulo));
			}
		}
		scanner.close();
	}

	static long gcd(long x, long y) {
		if(x==0) return y;
		return gcd(y%x, x);
	}

	static BigInteger powerModuloMod(BigInteger x, long y, BigInteger mod)
	{
		// Initialize result
		BigInteger res = BigInteger.ONE;     
		x = x.mod(mod);
		while (y > 0)
		{
			if((y & 1)==1) {
				res = (res.multiply(x)).mod(mod);
			}
			y = y >> 1;
			x = (x.multiply(x)).mod(mod); 
		}
		return res;
	}
} 