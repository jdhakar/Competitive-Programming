package org.jeet.interviewbit.linkedlist;

public class PalindromList {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public static int lPalin(ListNode A) {
		if(A==null || A.next==null) return 1;
		ListNode slow = A, fast=A, head=A;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		ListNode rev = fast==null ? reverse(slow):reverse(slow.next);
		while(rev!=null && rev.val==head.val) {
			rev=rev.next;
			head=head.next;
		}
		if (rev!=null) {
			return 0;
		} else {
			return 1;
		}
	}


	private static ListNode reverse(ListNode A) {
		ListNode pre=null, cur=A, next;
		while(cur!=null) {
			next = cur.next;
			cur.next=pre;
			pre=cur;
			cur=next;
		}
		return pre;
	}

	public static void main(String[] args) {
//		ArrayList<Integer> A= new ArrayList<Integer>(Arrays.asList(0, 2, 5, 7));
		ListNode A = new ListNode(0);
		System.out.println(lPalin(A));
	}
	
	static class ListNode {
			public int val;
			public ListNode next;
			ListNode(int x) { val = x; next = null; }
	}
}
