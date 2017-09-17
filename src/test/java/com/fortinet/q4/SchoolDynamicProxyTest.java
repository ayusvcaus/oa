package com.fortinet.q4;

import java.lang.reflect.Proxy;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.doThrow;

import com.fortinet.q4.Student;
import com.fortinet.q4.StudentDynamicProxy;
import com.fortinet.q4.ProfessorDynamicProxy;

public class SchoolDynamicProxyTest {
	
	private final String NAME = "Jeff";
	private final String SCORE = "85";
	private final String ASSIGNMENT = "math";
	
	private final String NAME2 = "Tony";
	private final String SCORE2 = "93";
	private final String ASSIGNMENT2 = "physics";
	
	@Mock
	private Student mockStudentProxy;	
	@Mock
	private Student mockProfessorProxy;
	
	private Student studentProxy;
	private Student professorProxy;
	
	@Before
	public void setup() {
		
		MockitoAnnotations.initMocks(this);
		
		Student student = new StudentImpl();
		student.setName(NAME);
		student.setScore(SCORE);
		student.setAssignment(ASSIGNMENT);
		
		studentProxy = (Student) Proxy.newProxyInstance(student.getClass().getClassLoader(), 
				student.getClass().getInterfaces(),  new StudentDynamicProxy(student));
		professorProxy = (Student) Proxy.newProxyInstance(student.getClass().getClassLoader(), 
				student.getClass().getInterfaces(),  new ProfessorDynamicProxy(student));			
	}
	
	@Test
	public void testStudentDynamicProxy() {
		assertEquals(NAME, studentProxy.getName());
		assertEquals(SCORE, studentProxy.getScore());
		assertEquals(ASSIGNMENT, studentProxy.getAssignment());
		
		studentProxy.setAssignment(ASSIGNMENT2);
		assertEquals(ASSIGNMENT2, studentProxy.getAssignment());
	   
		doThrow(Exception.class).when(mockStudentProxy).setName(NAME2);
		doThrow(Exception.class).when(mockStudentProxy).setScore(SCORE2);
	}
	
	@Test
	public void testManagerDynamicProxy() {
		assertEquals(NAME, professorProxy.getName());
		assertEquals(SCORE, professorProxy.getScore());
		assertEquals(ASSIGNMENT, professorProxy.getAssignment());
		
		professorProxy.setScore(SCORE2);
		assertEquals(SCORE2, professorProxy.getScore());
		professorProxy.setAssignment(ASSIGNMENT2);
		assertEquals(ASSIGNMENT2, professorProxy.getAssignment());
	   
		doThrow(Exception.class).when(mockProfessorProxy).setName(NAME2);		
	}

}
