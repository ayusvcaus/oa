package com.fortinet.q4;

public class StudentImpl implements Student {
	
	private String name;
	private String score;
	private  String assignment;
	
	@Override
	 public String getName() {
	     return name;
	 }
	 
	 @Override
	 public String getScore() {
	     return score;
	 }
	 
	 @Override
	 public String getAssignment() {
	     return assignment;
	 }
	 
	 @Override
	 public void setName(String name) {
	     this.name = name;    
	 }
	 
	 @Override
	 public void setScore(String score) {
	     this.score = score;
	 }
	 
	 @Override
	 public void setAssignment(String assignment) {
	     this.assignment = assignment;
	 }
}
