package com.fortinet.q4;

public class MySingleton {
	
	private static MySingleton instance;
	
	private MySingleton(){}
	
	public static MySingleton getInstance() {

		if (instance==null) {
			synchronized (MySingleton.class) {
				if (instance==null) {
					instance = new MySingleton();
				}
			}
		}
		return instance;
	}
}
