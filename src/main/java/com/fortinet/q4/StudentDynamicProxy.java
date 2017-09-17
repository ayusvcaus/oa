package com.fortinet.q4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StudentDynamicProxy implements InvocationHandler {

	private Student student;
	 
	public StudentDynamicProxy(Student student) {
	     this.student = student;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) {
	 
	    try {
	        if (method.getName().startsWith("get") || method.getName().equals("setAssignment")) {
	            return method.invoke(student, args);
	        } else if (method.getName().startsWith("set")) {
	        	throw new IllegalAccessException();
	        } 	 
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
}
