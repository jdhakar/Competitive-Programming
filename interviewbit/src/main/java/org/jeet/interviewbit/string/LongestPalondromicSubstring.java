package org.jeet.interviewbit.string;

public class LongestPalondromicSubstring {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public static String longestPalindrome(String A) {
        StringBuilder mod=new StringBuilder(A);
        int n=A.length();
        while(n>=0){
            mod.insert(n,'#');
            n--;
        }
        int maxl=0, maxr=0, maxlen=0;
        n=mod.length();
        int i=1;
        while(i<n-1){
            int l=i,r=i;
            while(l>0 && r<n-1 && mod.charAt(l-1)==mod.charAt(r+1)){
                l--;
                r++;
            }
            if(r-l > maxlen){
                maxr=r;
                maxl=l;
                maxlen=r-l;
            }
            i++;
        }
        String res="";
        while(maxl<=maxr){
            if(mod.charAt(maxl)!='#'){
                res+=mod.charAt(maxl);
            }
            maxl++;
        }
        return res;
    }

	public static void main(String[] args) {
		String i = longestPalindrome("abb");
		System.out.println(i);
	}

}
