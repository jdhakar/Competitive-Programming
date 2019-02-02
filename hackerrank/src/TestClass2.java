import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
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

class TestClass2 {
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
		int N = sc.nextInt();
		Map<Integer, LinkedList<Integer>> adj = new HashMap<Integer, LinkedList<Integer>>();
		for (int i = 1; i <= N; i++) {
			adj.put(i, new LinkedList<Integer>());
		}
		for (int i = 0; i < N-1; i++) {
			int x = sc.nextInt(), y =sc.nextInt();
			adj.get(x).add(y);
			adj.get(y).add(x);
		}
		int first = bfs(1, adj);
		int second = bfs(first, adj);

		System.out.println(first + " " + second);

	}

	private static int bfs(int i, Map<Integer, LinkedList<Integer>> adj) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(i);
		int n=adj.size();
		int dist[] = new int[n+1];
		dist[i]=1;
		while(q.size()>0) {
			int cur = q.poll();
			for (int j : adj.get(cur)) {
				if(dist[j]==0) {
					dist[j]=dist[cur]+1;
					q.add(j);
				}
			}
		}
		int res=i, maxDist=1;
		for(int j=0; j<=n; j++) {
			if(dist[j]>maxDist) {
				maxDist=dist[j];
				res=j;
			}
		}
		return res;
	}
}