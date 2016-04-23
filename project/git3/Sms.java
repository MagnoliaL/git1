package com.briup.ch12;
/**
增改查寻
*/
import java.util.Scanner;
public class Sms{
	
	private int index=0;
	private Student[] stus=new Student[3];
	
	
	
	//menu
	public void menu(){
		System.out.println("********学生信息系统********");
		System.out.println("*1.查询所有学生信息");
		System.out.println("*2.保存学生的信息");
		System.out.println("*3.通过学号查询学生信息");
		System.out.println("*4.修改学生的信息");
		System.out.println("*5.删除学生信息");
		System.out.println("*6.exit");
		System.out.println("*7.help");
        System.out.println("****************************");
		}
		
		
		
		/**
		添加学生信息
		*/
	public void save(Student stu){
		if(index>=stus.length){
			Student[] demo=new Student[stus.length+3];
			System.arraycopy(stus,0,demo,0,stus.length);
			stus=demo;
		}
		stus[index] = stu;
		index++;
	}
	/**
	qurrlAll（）查询所有学生信息
	*/
	public Student[] queryAll(){
		Student[] demo = new Student[index];
		System.arraycopy(stus,0,demo,0,index);
		return demo;
	}
	/**
	通过id找到索引*/
	public int queryindexbyId(long id){
		int stuindex=-1;
		for(int i=0;i<index;i++){
			if(stus[i].getid()==id){
				stuindex=i;
				break;
			}
		}
		return stuindex;
	}
	/**通过id查询学生的信息
	*/
	public Student querybyId(long id){
		int i=queryindexbyId(id);
		return i==-1?null:stus[i];
	}
	public void update(Student newStu){
		int a=queryindexbyId(newStu.id);
		stus[a]=newStu;
		System.out.println("修改成功！");
	}
	public void delect(int k){
		for(int i=k;i<index-1;i++){
			stus[i]=stus[i++];
		}
		stus[--index]=null;
	}
	public static void main(String[] args){
		Sms sms=new Sms();
		sms.menu();
		while(true){
		System.out.println("请输入功能编号");
		Scanner sc=new Scanner(System.in);
		String n=sc.nextLine();
		switch(n){
			/**
			查询所有学生信息
			*/
			case "1":
			System.out.println("一下是所有学生的信息");
			Student[] j=sms.queryAll();
			for(int i=0;i<j.length;i++){
				System.out.println(j[i]);
			}
			System.out.println("总计："+j.length+" 人");
			break;
		case "2":
		       while(true){
			   System.out.println("请输入学生信息【id#name#age】或者输入break回到上一级目录");
		       String a=sc.nextLine();
		       if(a.equals("break")){
			    break;
		       }
		       String[] s=a.split("#");
		       long id=Long.parseLong(s[0]);
		       String name=s[1];
		       int age=Integer.parseInt(s[2]);
		       Student stu=new Student(id,name,age);
		       sms.save(stu);
		       System.out.println("保存成功");
			   }break;
		case "3":while(true){
		       System.out.print("请输入您要查询学生的id或break返回上一级目录:");
			   String w=sc.nextLine();
			   if(w.equals("break")){
			    break;
		       }
			   System.out.println("以下是学生的信息");
			   Student stu=sms.querybyId(Long.parseLong(w));
		       System.out.println(stu!=null?stu:"not found!");}
		       break;
			   /**
			   修改学生信息
			   */
		case "4":
		while(true){
			System.out.println("请输入要修改学生的id或者按break退出");
			String a=sc.nextLine();
			if(a.equals("break")){break;}
			long id=Long.parseLong(a);
			Student oldStu=sms.querybyId(id);
			if(oldStu==null){
				System.out.println("该学生不存在");continue;
			}
			System.out.println("该学生的原信息为"+oldStu);
			System.out.println("请输入学生的信息【name#age】");
			String arr=sc.nextLine();
			String[] splitarr=arr.split("#");
			String name=splitarr[0];
			int age=Integer.parseInt(splitarr[1]);
			Student newStu=new Student(id,name,age);
			sms.update(newStu);
		}
		        break;
	    case "5":while(true){
			     System.out.println("请输入您要删除学生的id或break返回上一级目录");
			     String a=sc.nextLine();
				 if(a.equals("break")){break;};
				 long id=Long.parseLong(a);
				 Student oldStu=sms.querybyId(id);
				 if(oldStu==null){
				System.out.println("该学生不存在");continue;
			}
				 int sid=Integer.parseInt(a);
			    sms.delect(sid);
			    System.out.println("删除成功！");
		}
		        break;
		case "exit":
		      System.exit(0);break;
		case "help":sms.menu();
		break;}
		}
		
	}
}