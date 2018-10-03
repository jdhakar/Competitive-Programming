package org.jeet.codejam.codejam2008.qualification;
import java.io.*;
import java.util.*;

public class B_Train_Timetable {
	private static Scanner in;
	private static PrintWriter out;
	public static boolean SUBMIT = true;
//	public static final String NAME = "B-small-practice";
	public static final String NAME = "B-large-practice";

	private static void solve() throws IOException {
		int T = in.nextInt(), NA=in.nextInt(), NB=in.nextInt();
		in.nextLine();
		Schedule[] schedules = new Schedule[2*(NA+NB)];
		int count=0, startA=0, startB=0, tempA=0, tempB=0;
		
		for (int i = 0; i < NA; i++) {
			String[] arr=in.nextLine().split(" ");
			schedules[count++]=new Schedule(toTime(arr[0]), 1, 0);
			schedules[count++]=new Schedule(toTime(arr[1])+T, 0, 1);
		}

		for (int i = 0; i < NB; i++) {
			String[] arr=in.nextLine().split(" ");
			schedules[count++]=new Schedule(toTime(arr[0]), 1, 1);
			schedules[count++]=new Schedule(toTime(arr[1])+T, 0, 0);
		}

		Arrays.sort(schedules, Comparator.comparing(Schedule::getTime).thenComparing(Schedule::getArr).thenComparing(Schedule::getSta));
		for (Schedule sch : schedules) {
			if(sch.getSta()==0) {
				tempA+=sch.getArr()==0?-1:1;
				startA=Math.max(startA, tempA);
			} else {
				tempB+=sch.getArr()==0?-1:1;
				startB=Math.max(startB, tempB);				
			}
		}
		out.print(startA + " " + startB);
		out.println();
	}

	private static int toTime(String string) {
		String[] times = string.split(":");
		int res = Integer.valueOf(times[0])*60;
		res+=Integer.valueOf(times[1]);
		return res;
	}

	private static class Schedule{
		private int time;
		private int arr;
		private int sta;
		public int getTime() {
			return time;
		}
		public int getArr() {
			return arr;
		}
		public int getSta() {
			return sta;
		}
		public Schedule(int time, int arr, int sta) {
			super();
			this.time = time;
			this.arr = arr;
			this.sta = sta;
		}
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
