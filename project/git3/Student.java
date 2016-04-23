package com.briup.ch12;

public class Student{
	public String name;
	public int age;
	public long id;
	
	public Student(long id,String name,int age){
		this.name=name;
		this.age=age;
		this.id=id;
	}
	public void setname(String name){
		this.name=name;
	}
	public void setid(long id){
		this.id=id;
	}
	public void setage(int age){
		this.age=age;
	}
	public String getname(){
		return this.name;
	}
	public long getid(){
		return this.id;
	}
	public int getage(){
		return this.age;
	}
	public String toString(){
		return "["+"long:"+id+" name:"+name+" age:"+age+"]";
	}
}