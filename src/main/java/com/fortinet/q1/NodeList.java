package com.fortinet.q1;

public class NodeList {

	/*
	 * Question 1
	 */
	
	public static void print(Node head, String msg) {
		if (head==null) {
			return;
		}
		System.out.print(msg);
		Node cur = head;
		while (cur!=null) {
			if (cur.next!=null) {
			    System.out.print(cur.value+"->");
			} else {
				System.out.print(cur.value);
			}
			cur = cur.next;
		}
		System.out.println();
	}
	
	/*
	 * Time Complexity O(n)  n=number of nodes on list starting from head
	 * Sapce Complexity O(n)
	 * 
	 */
	
	public static Node reverse(Node head) {
		
		if (head==null) {
			return head;
		}		
		Node cur = head;
		Node next = null;
		Node prev = null;
		
		while (cur!=null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}		
		return prev;
	}	
}
