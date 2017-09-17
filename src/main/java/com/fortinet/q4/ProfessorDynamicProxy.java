package com.fortinet.q4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProfessorDynamicProxy implements InvocationHandler {
	
	private Student student; 
	 
	public ProfessorDynamicProxy(Student student) {
	    this.student = student;
	}
	 
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) {
	 
	    try { 
	        if (method.getName().startsWith("get")) { 
	            return method.invoke(student, args);	 
	        } else if(method.getName().startsWith("setName")) {
                throw new IllegalAccessException();	 
	        } else if(method.getName().startsWith("set")) {
	            return method.invoke(student, args);
	        }	 
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
}
