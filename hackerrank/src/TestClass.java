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

class TestClass {
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

		// Write your code here
		Scanner sc = new Scanner(System.in);
		long modulo=720720;
		int N = sc.nextInt();
		int arr[] = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		int K=sc.nextInt();
		if(K>N) {
			System.out.println(0);
		} else {
			long[][] nCk = new long[N+1][K+1];
			for(int a=0; a<=N; a++) {
				for(int b=0; b<=a && b<=K; b++) {
					if (b == 0 || b == a)
						nCk[a][b] = 1;
					else
						nCk[a][b] = (nCk[a-1][b-1] + nCk[a-1][b])%modulo;
				}
			}
			long res=0;
			for (int i = 0; i <= N-K; i++) {
				if(arr[i]>0) {
					res=(res+nCk[N-i-1][K-1])%modulo;
				}
			}

			System.out.println(res);
		}

	}
}