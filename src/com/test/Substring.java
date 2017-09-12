package com.test;

import java.util.Scanner;

public class Substring {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String str=new String();
	String lsub=new String();
	String wsub=new String();
	System.out.println("Enter a string");
	str=sc.nextLine();
	//System.out.println(str);
	boolean f=true;
	wsub=Character.toString(str.charAt(0));
	lsub=wsub;
	//System.out.println(wsub);
	int count=1;
	for(int i=0;i<str.length()-1;i++)
	{
	
		for(int j=0;j<wsub.length();j++)
		{
			if(str.charAt(i+1)==wsub.charAt(j))
			{
				f=false;
//				if(wsub.length()>count)
//					{
//					lsub=wsub;
//					count=lsub.length();
					wsub=Character.toString(str.charAt(i+1));
//					f=true;
//					}
					
				break;
				
				
			}
				
		}
		if(f)
		{
			wsub=wsub.concat(Character.toString(str.charAt(i+1)));
			if(wsub.length()>=count)
			{
			lsub=wsub;
			count=lsub.length();
			}
		}
		f=true;
		//System.out.println(wsub);
		
	}
	
	System.out.println(lsub);
	System.out.println("longest substring length:"+lsub.length());
	

	
}
}
