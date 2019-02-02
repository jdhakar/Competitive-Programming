package org.jeet.interviewbit.linkedlist;

public class InsertionSort {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static ListNode insertionSortList(ListNode A) {
        if(A==null || A.next==null) return A; 
        ListNode sortedList=A, cur, temp;
        A=A.next;
        sortedList.next=null;
        while(A!=null){
            cur=A;
            A=A.next;
            if (cur.val < sortedList.val) {
				cur.next=sortedList;
				sortedList=cur;
			} else {
				temp=sortedList;
				while(temp.next!=null && cur.val > temp.next.val){
					temp=temp.next;
				}
				cur.next=temp.next;
				temp.next=cur;
			}
        }
        return sortedList;
    }

	public static void main(String[] args) {
//		ArrayList<Integer> A= new ArrayList<Integer>(Arrays.asList(0, 2, 5, 7));
		ListNode A = new ListNode(5);
		ListNode head = A;
		head.next = new ListNode(3);
		head=head.next;
		head.next = new ListNode(7);
		head=head.next;
		head.next = new ListNode(1);
		head=head.next;
		head.next = new ListNode(2);
		head=head.next;
		head.next = new ListNode(12);
		
		A = insertionSortList(A);
		while(A!=null) {
			System.out.println(A.val);
			A=A.next;
		}

	}
	
	static class ListNode {
			public int val;
			public ListNode next;
			ListNode(int x) { val = x; next = null; }
	}
}
