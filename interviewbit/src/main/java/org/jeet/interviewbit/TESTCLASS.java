package org.jeet.interviewbit;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class TESTCLASS 
{
	public static void main( String[] args )
	{
		Scanner s = new Scanner(System.in);
		long S = s.nextLong();
		long res=0;
		if(S>=1001001001001000L) {
			res += 1004006004001L;
		} else {
			for (long i = 0; i < 1001; i++) {
				long s4=S-i*i*i*i;
				if(s4<0) {
					break;
				} else if(s4>=1001001000L) {
					res+=1003003001L;
				} else {
					for (long j = 0; j <=1000; j++) {
						long s3=s4-j*j*j;
						if(s3<0) {
							break;
						} else if(s3>=1001000) {
							res+=1002001;
						} else  {
							for (long k = 0; k <=1000; k++) {
								long s2=s3-k*k;
								if(s2<0) {
									break;
								} else if(s2>1001){
									res+=1001;
								} else {
									res+=s2+1;
								}
							}
						}
					}
				}
			}
		}
		System.out.println(res);
		s.close();
	}

}
