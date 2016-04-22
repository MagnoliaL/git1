package com.briup.homework;

public class Teacher{
	public String name;
	public int age;
	public long id;
	public String sedpt;
	
	public Teacher(long id,String name,int age){
		this.id=id;
		this.name=name;
		this.age=age;
		this.sedpt=sedpt;
	}
	public Teacher(){}
	public void setId(long id){
		this.id=id;
	}
	public long getId(){
		return this.id;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
		}
	public void setAge(int age){
		this.age=age;
		}
	public int getAge(){
		return this.age;
		}
	public String toString(){
		return "["+"id:"+id+",name:"+name+",age:"+age+"]";
	}
	
	
}