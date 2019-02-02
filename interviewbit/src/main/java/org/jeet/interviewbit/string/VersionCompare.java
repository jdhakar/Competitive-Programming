package org.jeet.interviewbit.string;

public class VersionCompare {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static int compareVersion(String A, String B) {
        String[] aL = A.split(".");
        String[] bL = B.split(".");
        int i=0, aN=aL.length, bN=bL.length;
        while(i<aN && i<bN){
            int c = compare(aL[i], bL[i]);
            if(c!=0){
                return c;
            }
            i++;
        }
        if(i<aN){
            return 1;
        }
        if(i<bN){
            return -1;
        }
        return 0;
    }
    public static int compare(String s1, String s2){
        int i=0, n=s1.length(), m=s2.length();
        while(i<n && i<m){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(s1.charAt(i)<s2.charAt(i)){
                    return -1;
                }
                return 1;
            }
            i++;
        }
        if(i<n){
            return 1;
        }
        if(i<m){
            return -1;
        }
        return 0;
    }

	public static void main(String[] args) {
		int i = compare("13.0", "13.0.8");
		System.out.println(i);
	}

}
