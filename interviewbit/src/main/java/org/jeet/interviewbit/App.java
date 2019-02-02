package org.jeet.interviewbit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
        for (int i = 7; i < 7000000; i+=10) {
			int j=i/10;
			int k=j;
			int l=7;
			while(k>0) {
				k/=10;
				l*=10;
			}
			if(i*5==(l+j)) {
				System.out.println(i);
			}
		}
    }
}
