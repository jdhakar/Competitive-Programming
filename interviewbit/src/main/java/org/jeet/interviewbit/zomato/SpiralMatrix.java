package org.jeet.interviewbit.zomato;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static  ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        int T=0, B=n-1, L=0, R=m-1, dir=0;
        ArrayList<Integer> ret= new ArrayList<Integer>();
        
        while(L<=R && T<=B ){
            if(dir==0){
                for(int i=L; i<=R; i++){
                    //System.out.println(A.get(T).get(i));
                    ret.add(A.get(T).get(i));
                    // dir=1;
                }
                T++;
            } else if(dir==1){
                for(int i=T; i<=B; i++){
                    //System.out.println(A.get(i).get(R));
                    ret.add(A.get(i).get(R));
                    // dir=2;
                }
                R--;
            } else if(dir==2){
                for(int i=R; i>=L; i--){
                    //System.out.println(A.get(B).get(i));
                    ret.add(A.get(B).get(i));
                    // dir=3;
                }
                B--;
            } else if(dir==3){
                for(int i=B; i>=T; i--){
                    //System.out.println(A.get(i).get(L));
                    ret.add(A.get(i).get(L));
                    // dir=0;
                }
                L++;
            } 
            
            dir = (dir+1) % 4;
        }
        
        return ret;
    }
    
    public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		a.add(new ArrayList<Integer>());
		a.add(new ArrayList<Integer>());
		a.add(new ArrayList<Integer>());
		a.get(0).addAll(Arrays.asList(1,2));
		a.get(1).addAll(Arrays.asList(3,4));
		a.get(2).addAll(Arrays.asList(5,6));

		spiralOrder(a);
	}
}
