package com.fortinet.q3;

import java.util.Collections;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import com.fortinet.q3.BackTracker;

public class BackTrackerTest {
	
	private List<Integer> list, list2, list3;
	
	@Before
	public void setup() {
		
	    list = Arrays.asList(new Integer[] {2, 3, 4, 5, 7});
	    list2 = Arrays.asList(new Integer[]{2, 1, 4, 5, 3, 3});
	    list3 = Arrays.asList(new Integer[]{5, 5, 5, 5, 5});
	}
	
	@Test
	public void testIsSeparable() {
		
		assertFalse(BackTracker.isSeparable(null, 3));
		assertFalse(BackTracker.isSeparable(Collections.EMPTY_LIST, 3));
		assertFalse(BackTracker.isSeparable(list, 0));
		assertFalse(BackTracker.isSeparable(list, -1));
		assertFalse(BackTracker.isSeparable(list, 4));
		assertFalse(BackTracker.isSeparable(list, list.size()+1));
		assertTrue(BackTracker.isSeparable(list, 1));
		assertTrue(BackTracker.isSeparable(list, 3));
		assertTrue(BackTracker.isSeparable(list2, 3));
		assertFalse(BackTracker.isSeparable(list2, 6));
		assertTrue(BackTracker.isSeparable(list3, 5));
	}
}
