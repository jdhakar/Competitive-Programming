package org.jeet.codechef.sept2018.div2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class H_ANDSQR {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int T = scanner.nextInt();
		for(int i=0; i<T; i++) {
			int N = scanner.nextInt();
			int Q = scanner.nextInt();
			int[] arr = new int[N];
			int[] res = new int[Q];
			for (int j = 0; j < arr.length; j++) {
				arr[j]=scanner.nextInt();
			}
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();

			int[] sqrCountLR = new int[N];
			for (int j = 0; j < arr.length; j++) {
				Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
				for (Integer k : map.keySet()) {
					int curk=k&arr[j];
					map1.put(curk, map1.getOrDefault(curk, 0)+map.get(k));
				}
				map1.put(arr[j], map1.getOrDefault(arr[j], 0)+1);
				int count=0;
				for (Integer k : map1.keySet()) {
					if(isPerfectSqr(k)) {
						count+=map1.get(k);
					}
				}
				sqrCountLR[j]=j==0?count:count;
				map=map1;
			}

			int[] sqrCountRL = new int[N];
			map = new HashMap<Integer, Integer>();
			for (int j = N-1; j >= 0; j--) {
				Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
				for (Integer k : map.keySet()) {
					int curk=k&arr[j];
					map1.put(curk, map1.getOrDefault(curk, 0)+map.get(k));
				}
				map1.put(arr[j], map1.getOrDefault(arr[j], 0)+1);
				int count=0;
				for (Integer k : map1.keySet()) {
					if(isPerfectSqr(k)) {
						count+=map1.get(k);
					}
				}
				sqrCountRL[j]=count;
				map=map1;
			}
			for(int j=0;j<Q;j++) {
				int x=scanner.nextInt();
				int y=scanner.nextInt();
//				res[j]=x==1?sqrCountLR[y-1]:sqrCountLR[y-1]-sqrCountLR[x-1];
				if(x==1) {
					res[j]=sqrCountLR[y-1];
				} else if(y==N-1) {
					res[j]=sqrCountRL[x-1];
				} else {
					res[j]=sqrCountLR[y-1]-sqrCountLR[x-1]+sqrCountRL[x-1]-sqrCountRL[y-1];
				}
				System.out.println(res[j]);
			}
//			for(int j=0;j<Q;j++) {
//				System.out.println(res[j]);
//			}
		}
		scanner.close();
	}

	private static boolean isPerfectSqr(Integer k) {
		int ksqr = (int)Math.sqrt(k);
		return ksqr*ksqr==k;
	}
} 