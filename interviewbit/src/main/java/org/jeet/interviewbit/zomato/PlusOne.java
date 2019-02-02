package org.jeet.interviewbit.zomato;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PlusOne {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY


	public static void main(String[] args) {

		for (int i = 1; i < 20; i++) {
			System.out.println(solve(i));
		}
	}

	public static String solve(int A) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("11");
		arr.add("22");
		int curCount=0;
		while(curCount+arr.size()<A) {
			ArrayList<String> arr1= new ArrayList<String>();
			curCount+=arr.size();
			for (String str : arr) {
				arr1.add("1"+str+"1");
				if(arr1.size()+curCount>=A) {
					break;
				}
			}
			for (String str : arr) {
				arr1.add("2"+str+"2");	
				if(arr1.size()+curCount>=A) {
					break;
				}
			}
			arr=arr1;
		}
		return arr.get(A-curCount-1);
		//		System.out.println(arr.get(A-curCount-1));
	}
}
