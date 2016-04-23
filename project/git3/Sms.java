package com.briup.ch12;
/**
���Ĳ�Ѱ
*/
import java.util.Scanner;
public class Sms{
	
	private int index=0;
	private Student[] stus=new Student[3];
	
	
	
	//menu
	public void menu(){
		System.out.println("********ѧ����Ϣϵͳ********");
		System.out.println("*1.��ѯ����ѧ����Ϣ");
		System.out.println("*2.����ѧ������Ϣ");
		System.out.println("*3.ͨ��ѧ�Ų�ѯѧ����Ϣ");
		System.out.println("*4.�޸�ѧ������Ϣ");
		System.out.println("*5.ɾ��ѧ����Ϣ");
		System.out.println("*6.exit");
		System.out.println("*7.help");
        System.out.println("****************************");
		}
		
		
		
		/**
		���ѧ����Ϣ
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
	qurrlAll������ѯ����ѧ����Ϣ
	*/
	public Student[] queryAll(){
		Student[] demo = new Student[index];
		System.arraycopy(stus,0,demo,0,index);
		return demo;
	}
	/**
	ͨ��id�ҵ�����*/
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
	/**ͨ��id��ѯѧ������Ϣ
	*/
	public Student querybyId(long id){
		int i=queryindexbyId(id);
		return i==-1?null:stus[i];
	}
	public void update(Student newStu){
		int a=queryindexbyId(newStu.id);
		stus[a]=newStu;
		System.out.println("�޸ĳɹ���");
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
		System.out.println("�����빦�ܱ��");
		Scanner sc=new Scanner(System.in);
		String n=sc.nextLine();
		switch(n){
			/**
			��ѯ����ѧ����Ϣ
			*/
			case "1":
			System.out.println("һ��������ѧ������Ϣ");
			Student[] j=sms.queryAll();
			for(int i=0;i<j.length;i++){
				System.out.println(j[i]);
			}
			System.out.println("�ܼƣ�"+j.length+" ��");
			break;
		case "2":
		       while(true){
			   System.out.println("������ѧ����Ϣ��id#name#age����������break�ص���һ��Ŀ¼");
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
		       System.out.println("����ɹ�");
			   }break;
		case "3":while(true){
		       System.out.print("��������Ҫ��ѯѧ����id��break������һ��Ŀ¼:");
			   String w=sc.nextLine();
			   if(w.equals("break")){
			    break;
		       }
			   System.out.println("������ѧ������Ϣ");
			   Student stu=sms.querybyId(Long.parseLong(w));
		       System.out.println(stu!=null?stu:"not found!");}
		       break;
			   /**
			   �޸�ѧ����Ϣ
			   */
		case "4":
		while(true){
			System.out.println("������Ҫ�޸�ѧ����id���߰�break�˳�");
			String a=sc.nextLine();
			if(a.equals("break")){break;}
			long id=Long.parseLong(a);
			Student oldStu=sms.querybyId(id);
			if(oldStu==null){
				System.out.println("��ѧ��������");continue;
			}
			System.out.println("��ѧ����ԭ��ϢΪ"+oldStu);
			System.out.println("������ѧ������Ϣ��name#age��");
			String arr=sc.nextLine();
			String[] splitarr=arr.split("#");
			String name=splitarr[0];
			int age=Integer.parseInt(splitarr[1]);
			Student newStu=new Student(id,name,age);
			sms.update(newStu);
		}
		        break;
	    case "5":while(true){
			     System.out.println("��������Ҫɾ��ѧ����id��break������һ��Ŀ¼");
			     String a=sc.nextLine();
				 if(a.equals("break")){break;};
				 long id=Long.parseLong(a);
				 Student oldStu=sms.querybyId(id);
				 if(oldStu==null){
				System.out.println("��ѧ��������");continue;
			}
				 int sid=Integer.parseInt(a);
			    sms.delect(sid);
			    System.out.println("ɾ���ɹ���");
		}
		        break;
		case "exit":
		      System.exit(0);break;
		case "help":sms.menu();
		break;}
		}
		
	}
}