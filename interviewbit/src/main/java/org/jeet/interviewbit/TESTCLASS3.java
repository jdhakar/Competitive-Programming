package org.jeet.interviewbit;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class TESTCLASS3 
{
	public static void main( String[] args )
	{
		Scanner s = new Scanner(System.in);
		char[] s1=s.next().toCharArray();
		char[] s2=s.next().toCharArray();
		int i=0,j=0, n=s1.length, m=s2.length, res=0;
		boolean matching=true;
		while(i<n && j<m) {
			if(s1[i]==s2[j]) {
				i++;
				j++;
			} else {
				if(i==0) {
					matching=false;
					break;
				} else if(s1[i]==s1[i-1]) {
					while(i<n && s1[i]==s1[i-1] && s1[i]!=s2[j]) {
						i++;
						res++;
					}
				} else if(j<m && s2[j]==s2[j-1]) {
					while(j<m && s2[j]==s2[j-1] && s2[j]!=s1[i]) {
						j++;
						res++;
					}
				}
				if(i<n && j<m && s1[i]!=s2[j]) {
					matching=false;
					break;
				} 
			}
		}
		if(matching) {
			if(i<n) {
				while(i<n && s1[i]==s1[i-1]) {
					i++;
					res++;
				}
				if(i<n) {
					matching=false;
				}
			} else if(j<m) {
				while(j<m && s2[j]==s2[j-1]) {
					j++;
					res++;
				}
				if(j<m) {
					matching=false;
				}
			}
		}
		if(!matching) {
			System.out.println("Not possible");
		} else {
			System.out.println(res);
		}

		s.close();
	}



}
