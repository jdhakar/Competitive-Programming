// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.ArrayList;
import java.util.List;
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution1
{        
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public List<Integer> cellCompete(int[] states, int days)
	{
		// WRITE YOUR CODE HERE
		int m = states.length;
		int[][] dayState = new int[days+1][m];

		for (int i = 0; i < m; i++) {
			dayState[0][i]=states[i];
		}
		for (int i = 1; i <= days; i++) {
			for (int j = 0; j < m; j++) {
				if(j==0) {
					dayState[i][j]=dayState[i-1][j+1]==0?0:1;
				} else if(j==m-1) {
					dayState[i][j]=dayState[i-1][j-1]==0?0:1;
				} else {
					dayState[i][j]=dayState[i-1][j-1]==dayState[i-1][j+1]?0:1;
				}
			}
		}
		ArrayList<Integer> res = new ArrayList<Integer>();

		for (int i = 0; i < m; i++) {
			res.add(dayState[days][i]);
		}

		return res;

	}
	// METHOD SIGNATURE ENDS

	public int generalizedGCD(int num, int[] arr)
	{
		
		return num;
		// WRITE YOUR CODE HERE
	}

	public static void main(String[] args) {
		System.out.println(-8 % 7);

	}
}