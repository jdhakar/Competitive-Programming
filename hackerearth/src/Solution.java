import java.util.HashMap;
import java.util.Map;

class Solution {
	
	public static void main(String[] args) {
		int[] cur = {2,1,3};
		System.out.println(new Solution().countTriplets(cur));
	}
	
    public int countTriplets(int[] A) {
        int n=A.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int cur=A[i]&A[j];
                map.put(cur,map.getOrDefault(cur, 0)+1);
            }
        }
        int res=0;
        for(int i=0; i<n; i++){
        		int cur=A[i], temp=0;
        		while(cur!=0) {
        			temp<<=1;
        			temp |= (cur&1);
        			cur>>=1;
        		}
            res+=map.getOrDefault(cur, 0);
        }
        return res;
    }
}