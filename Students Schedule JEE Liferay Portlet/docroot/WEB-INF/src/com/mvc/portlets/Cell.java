package com.mvc.portlets;

public class Cell {

	String subclass1;
	public String getSubclass1() {
		return subclass1;
	}
	public void setSubclass1(String subclass1) {
		this.subclass1 = subclass1;
	}
	public String getSubclass2() {
		return subclass2;
	}
	public void setSubclass2(String subclass2) {
		this.subclass2 = subclass2;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getTeacher1() {
		return teacher1;
	}
	public void setTeacher1(String teacher1) {
		this.teacher1 = teacher1;
	}
	public String getTeacher2() {
		return teacher2;
	}
	public void setTeacher2(String teacher2) {
		this.teacher2 = teacher2;
	}
	public String getRoom1() {
		return room1;
	}
	public void setRoom1(String room1) {
		this.room1 = room1;
	}
	public String getRoom2() {
		return room2;
	}
	public void setRoom2(String room2) {
		this.room2 = room2;
	}
	public String getCourse1() {
		return course1;
	}
	public void setCourse1(String course1) {
		this.course1 = course1;
	}
	public String getCourse2() {
		return course2;
	}
	public void setCourse2(String course2) {
		this.course2 = course2;
	}

	String subclass2;
	String hour;
	String teacher1;
	String teacher2;
	String room1;
	String room2;
	String course1;
	String course2;
	public Cell(){
		
	}
	@Override
	public String toString() {
		StringBuilder s=new StringBuilder("Cell [");
		if(hour!=null){
			s.append(",hour=").append(hour);
		}
		if(subclass1!=null){
			s.append(",subclass1=").append(subclass1);
		}
		if(subclass2!=null){
			s.append(",subclass2=").append(subclass2);
		}
		if(teacher1!=null){
			s.append(",teacher1=").append(teacher1);
		}
		if(teacher2!=null){
			s.append(",teacher2=").append(teacher2);
		}
		if(room1!=null){
			s.append(",room1=").append(room1);
		}
		if(room2!=null){
			s.append(",room2=").append(room2);
		}
		if(course1!=null){
			s.append(",course1=").append(course1);
		}
		if(course2!=null){
			s.append(",course2=").append(course2);
		}
		s.append("]");
		if(!isValid()){
			s.append(" missing : ");
			if(isEmpty(hour)){
				s.append("/hour");
			}
			if(isEmpty(course1)){
				s.append("/course1");
			}
			if(isEmpty(room1)){
				s.append("/room1");
			}
			if(isEmpty(teacher1)){
				s.append("/teacher1");
			}
		}
		return s.toString();
	}
	
	public boolean isValid() {
		if(!isEmpty(room1)){
			if(isEmpty(room2)){
				if(!isEmpty(subclass2) || !isEmpty(teacher2)){
					return false;
				}
			}
			return true;
		}
		return false;
	}

	private boolean isEmpty(String s) {
		return s == null || s.trim().length() == 0;
	}
	
}
