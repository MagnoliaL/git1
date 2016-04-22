package com.briup.homework;

import java.util.Scanner;
public class Tms{
	private Teacher[] teas=new Teacher[3];
    private int index=0;
	public void menu(){
		System.out.println("*********Teacher Message System********");
		System.out.println("*1.查询所有教师的信息");
	    System.out.println("*2.添加教师的信息");
		System.out.println("*3.通过教师编号查询教师信息");
		System.out.println("*4.删除教师信息");
		System.out.println("*5.help");
		System.out.println("*6.exit");
		System.out.println("***************************************");
		}
	public void add(Teacher teach){
		if(index>=teas.length){
			Teacher[] demo=new Teacher[index+3];
			System.arraycopy(teas,0,demo,0,index);
			teas=demo;
		}
		teas[index++]=teach;
		System.out.println("保存成功！");
	}
	public Teacher[] queryAll(){
		Teacher[] demo=new Teacher[index];
		System.arraycopy(teas,0,demo,0,index);
		return demo;
	}
	public Teacher queryById(String indexById){
		int indexquerBy=queryindexById(indexById);
		return indexqueryBy==-1?null:teas[indexquerBy];
	}
	public int queryindexById(String id){
		int j=-1;
		for(int i=0;i<index;i++){
			if(id.equals("stus[i].id")){
				j=i;
			}
		}
		return j;
	}
	public static void main(String[] args){
		Tms teacher=new Tms();
		teacher.menu();
		while(true){
		System.out.println("请输入功能编号");
		Scanner sc=new Scanner(System.in);
		String scstr=sc.nextLine();
		switch(scstr){
			case "1":System.out.println("以下是所有教师的信息");
			        Teacher[] arr=teacher.queryAll();
					for(int i=0;i<arr.length;i++){
						System.out.println(arr[i]);
					}
					System.out.println("总计："+arr.length+" 人");
			         break;
		    case "2":while(true){
				System.out.println("请输入教师的信息格式【id#name#age】或者输入【break】退出添加");
				String addstr=sc.nextLine();
				if(addstr.equals("break")){
					break;
				}
				String[] addarr=addstr.split("#");
				long id=Long.parseLong(addarr[0]);
				String name=addarr[1];
				int age=Integer.parseInt(addarr[2]);
				Teacher teach=new Teacher(id,name,age);
				teacher.add(teach);
				//System.out.println("一共有"+index+"个教师");
			}
			        break;
		    case "3":
				System.out.println("请输入要查询教师的编号");
				String id=sc.nextLine();
				Teacher tea=teacher.queryById(id);System.out.println(tea);
				/**
			     更改学生的信息*/
		    case "4":while(true){
				    System.out.println("请输入要修改学生的【id】或者输入【break】退出");
					String arr=sc.nextLine();
					if(arr.equals("break")){
						break;
					}
					int a=sc.queryindexById(arr);
			}
			        break;
			case "help":teacher.menu();
			            break;
			case "exit":System.exit(0);
			            break;
						}
		}
	}
}