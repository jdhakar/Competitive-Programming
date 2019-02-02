package org.jeet.interviewbit.string;

public class PatternMatching {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
//    public int isMatch(final String A, final String B) {
//        int n=A.length(), m=B.length();
//        boolean[][] res = new boolean[n+1][m+1];
//        
//        for(int i=1; i<m; i++) {
//        		res[i][0]=false;
//        }
//    }
    
    public static void main(String[] args) {
		System.out.println(minCut("abab"));
	}
    
    public static int minCut(String A) {
        int n=A.length();
        int[] count = new int[n+1];
        for(int i=1; i<n; i++){
            count[i]=i;
        }
        for(int i=0; i<n-1; i++){
            if(A.charAt(i)==A.charAt(i+1)){
                int l=i, r=i+1;
                while(l>=0 && r<n && A.charAt(l)==A.charAt(r)){
                    count[r+1]=Math.min(count[r], count[l]+1);
                    l--;
                    r++;
                }
            }
            if(i>0){
                int l=i-1, r=i+1;
                while(l>=0 && r<n && A.charAt(l)==A.charAt(r)){
                    count[r+1]=Math.min(count[r+1], count[l]+1);
                    l--;
                    r++;
                }
            }
        }
        return count[n];
    }
}
