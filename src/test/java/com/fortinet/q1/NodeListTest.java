package com.fortinet.q1;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.fortinet.q1.Node;
import com.fortinet.q1.NodeList;

public class NodeListTest {
	
	private Node list;
	private int[] arr ;
	private final int LENGTH = 10;
	
	@Before
	public void setup() {
		
		arr = new int[LENGTH];
		Node head = null;
		for (int i=1; i<=LENGTH; i++) {
			arr[i-1] = i;
			Node n = new Node();
			n.value = i;
			if (list==null) {
				list = n;
				head = list;
			} else {
				list.next = n;
				list = list.next;
			}
		}
		list = head;
	}
	
	@Test
	public void testReverse() throws Exception {

		assertNull(NodeList.reverse(null));
		
		NodeList.print(list, "Original:");

		Node reversed = NodeList.reverse(list);
		
	    NodeList.print(reversed, "Reversed:");
		
	    int i = LENGTH-1;
	    Node cur = reversed;
	    while (cur!=null) {
	    	assertEquals(arr[i--], cur.value);
	    	cur = cur.next;
	    }
	}
}
