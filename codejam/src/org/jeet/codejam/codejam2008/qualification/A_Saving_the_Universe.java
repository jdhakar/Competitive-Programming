package org.jeet.codejam.codejam2008.qualification;
import java.io.*;
import java.util.*;

public class A_Saving_the_Universe {
	private static Scanner in;
	private static PrintWriter out;
	public static boolean SUBMIT = true;
//	public static final String NAME = "A-small-practice";
	public static final String NAME = "A-large-practice";

	private static void solve() throws IOException {
		int s = Integer.parseInt(in.nextLine());
		String[] engines = new String[s];
		for (int i = 0; i < s; i++) {
			engines[i]=in.nextLine();
		}
		//    	String[] queries = new String[26];
		Set<String> set = new HashSet<String>();
		int ans=0, q=Integer.parseInt(in.nextLine());
		for (int i = 0; i < q; i++) {
			String qi = in.nextLine();
			set.add(qi);
			if(set.size()==s) {
				set.clear();
				ans++;
				set.add(qi);
			}
		}
		out.print(ans);

		out.println();
	}


	public static void main(String[] args) throws IOException {
		if (SUBMIT) {
			in = new Scanner(new FileInputStream(new File(NAME + ".in")));
			out = new PrintWriter(new BufferedWriter(new FileWriter(NAME + ".out")));
		} else {
			in = new Scanner(System.in);
			out = new PrintWriter(System.out, true);
		}

		int numCases = Integer.parseInt(in.nextLine());
		for (int test = 1; test <= numCases; test++) {
			out.print("Case #" + test + ": ");
			solve();
		}

		out.close();
		System.exit(0);
	}

}
