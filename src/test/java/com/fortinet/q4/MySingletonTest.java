package com.fortinet.q4;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import com.fortinet.q4.MySingleton;

public class MySingletonTest {
	
	 @Test
	 public void testUniqueInstance(){
		 MySingleton inst1 = MySingleton.getInstance();
		 MySingleton inst2 = MySingleton.getInstance();		 
		 assertTrue(inst1==inst2);		 
	 }
	 
}
