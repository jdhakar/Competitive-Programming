package org.jeet.codechef.sept2018.div2;

import java.util.Scanner;

class E_TABGAME {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int T = scanner.nextInt();
		for(int i=0; i<T; i++) {
			char[] M = scanner.next().toCharArray();
			char[] N = scanner.next().toCharArray();
			int m = M.length;
			int n = N.length;
			boolean[] tableCol = new boolean[n];
			boolean[] tableRow = new boolean[m];
			tableCol[0]=M[0]=='0' || N[0]=='0';
			tableRow[0]=tableCol[0];

			for(int j=1;j<n;j++) {
				tableCol[j]=N[j]=='0'||!tableCol[j-1];
			}
			for(int j=1;j<m;j++) {
				tableRow[j]=M[j]=='0'||!tableRow[j-1];
			}

			int reversed=0;
			if(m>1 && !tableRow[1]) {
				reversed=1;
			}
			if(n>1 && !tableCol[1]) {
				reversed=1;
			}
			int k=2;
			while(k<n && (tableCol[k] || (k+reversed)%2==0)){
				k++;
			}
			int[] colCount=new int[n];
			if(k<n) {
				int count=1;
				colCount[k]=count;
				for (int j = k+1; j < colCount.length; j++) {
					if(!tableCol[j] && (j-k)%2==1) {
						k=j;
						count++;
					}
					colCount[j]=count;
				}

			}

			k=2;
			while(k<m && (tableRow[k] || (k+reversed)%2==0)){
				k++;
			}
			int[] rowCount=new int[m];
			if(k<m) {
				int count=1;
				rowCount[k]=count;
				for (int j = k+1; j < rowCount.length; j++) {
					if(!tableRow[j] && (j-k)%2==1) {
						k=j;
						count++;
					}
					rowCount[j]=count;
				}				
			}

			int Q = scanner.nextInt();
			StringBuilder sb=new StringBuilder();
			for(int j=0;j<Q;j++) {
				int x=scanner.nextInt();
				int y=scanner.nextInt();
				int z=0;
				if(x==1) {
					z=tableRow[y-1]?1:0;
				} else if(y==1) {
					z=tableCol[x-1]?1:0;
				} else {
					z = (x + y + reversed)%2;
					if(x > y) {
						z = (z + colCount[x-y+1])%2;
					} else if(y > x){
						z = (z + rowCount[y-x+1])%2;
					}
				}
				sb.append(z);
			}
			System.out.println(sb.toString());
		}
		scanner.close();
	}
} 