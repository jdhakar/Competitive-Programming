package org.jeet.interviewbit;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class TESTCLASS4 
{
	public static void main( String[] args )
	{
		Scanner s = new Scanner(System.in);
		int n=s.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i]=s.nextInt();
		}
		int[] res = new int[n];
		for (int i = 0; i < res.length; i++) {
			res[i]=199*(i+1);
		}
		for (int i = 3; i < res.length; i++) {
			for (int j = i-1; j >=0 && a[i]-a[j] < 7; j--) {
				if(j==0) {
					if(a[i]-a[j]<7) {
						res[i]=Math.min(res[i], 699);
					}
				} else {
					if(i-j<3) {
						res[i]=Math.min(res[i], res[j-1]+(i-j+1)*199);
					} else {
						res[i]=Math.min(res[i], res[j-1]+699);
					}
				}
			}
		}
		if(res[n-1]>2499) {
			res[n-1]=2499;
		}
		System.out.println(res[n-1]);
		s.close();
	}
	
	

}
