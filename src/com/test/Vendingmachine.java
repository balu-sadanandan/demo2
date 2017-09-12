package com.test;


import java.util.Scanner;


public class Vendingmachine {
	//private int stockc,stockp,stocks;
	private int one=0,five=0,ten=0,tfive=0;
	private int selection;
	item coke=new item("coke",25,1);
	item pepsi=new item("pepsi",35,2);
	item soda=new item("soda",45,3);
	item sel =new item("blank",0,0);
	Scanner sc=new Scanner(System.in);
	
	public boolean dispmenu(){
		//sc.nextLine();
		System.out.println("Vending machine\n\nPlease make a selection");
		System.out.println(coke.print()+"\n"+pepsi.print()+"\n"+soda.print()+"\n"+ "0.I'm the supplier\n\nPress q to exit");
		selection=userin();
		if (selection==0)
			return false;
		
		sel=objsel(selection);
		return true;
		//System.out.println(sel.print());
	}
	public  int userin(){
		String ch;
		int n;
		
		ch=sc.nextLine();
		//n=sc.nextInt();
		//System.out.println(n);
		
		if(ch.equalsIgnoreCase("Q"))
		{
			System.exit(0);
		}
		return (int)Integer.parseInt(ch);
		
		
	}
	public item objsel(int selec){
		switch(selec){
		case 1:{
			return coke;
			}
		case 2:{
			return pepsi;
			}
		case 3:{
			return soda;
			}
		default: return sel;
		}
	}
	
	public void cashin(){
		int l1=0,l5=0,l10=0,l25=0;
		int cn=0,opt;
		String ch;
		int blnc;
		if(sel.stock!=0)
		{
		System.out.println("You have selected\n "+sel.name+"\n Please input Rs."+sel.cost+" in denominations of 1,5,10 or 25" );
			
		while(true){
			cn=sc.nextInt();
			ch=sc.nextLine();//to flush out \n from buffer
						
			switch(cn)
			{
			case 1:
				l1++;
				break;
			case 5:
				l5++;
				break;
			case 10:
				l10++;
				break;
			case 25:
				l25++;
				break;
			}
			if(sel.cost<=(l1+l5*5+l10*10+l25*25))
				{
				//System.out.println("breaking");
				break;			
				}
		}
		blnc=((l1+l5*5+l10*10+l25*25)-sel.cost);
		if(chkblnc(blnc))
		{
		
		
			System.out.println("You have selected"+sel.print()+"\n Cash input:"
				+ "\n One  :"+l1+"\nFive  :"+l5+"\nTen  :"+l10+"\nTwentyfive :"+l25+
				"\n\n Total:"+(l1+l5*5+l10*10+l25*25)+"\n\nYou will get back"+blnc+"\n1.Confirm\n2.Cancel");
			opt=userin();
			if(opt==1)
				{
				System.out.println("Here's your "+sel.name);
				sel.stock--;
				retblnc(blnc);
				one+=l1;
				five+=l5;
				ten+=l10;
				tfive+=l25;
			
				}
			else
			{
				System.out.println("Order cancelled");
				System.out.println("Returning money\n");
				System.out.println(" One  :"+l1+"\nFive  :"+l5+"\nTen  :"+l10+"\nTwentyfive :"+l25+
				"\n\n Total:"+(l1+l5*5+l10*10+l25*25));
			}
				
		}
		else
		{
			System.out.println("sorry, there is no change available to return the balance");
			System.out.println("Returning money\n");
			System.out.println(" One  :"+l1+"\nFive  :"+l5+"\nTen  :"+l10+"\nTwentyfive :"+l25+
			"\n\n Total:"+(l1+l5*5+l10*10+l25*25));
		}
		
		
		
		}
	}
public boolean chkblnc(int amt){
	int w1=one,w5=five,w10=ten,w25=tfive;
	while(amt>=25)
	{
		if(w25>0)
		   {
			amt-=25;
			w25--;
		   }
		else 
			break;
	}
	while(amt>=10)
	{
		if(w10>0)
		   {
			amt-=10;
			w10--;
		   }
		else break;
	}
	while(amt>=5)
	{
		if(w5>0)
		   {
			amt-=5;
			w5--;
		   }
		else
			break;
	}
	while(amt>=1)
	{
		if(w1>0)
		   {
			amt-=1;
			w1--;
		   }
		else 
			return false;
	}
	if(amt==0)
		return true;
 return false;
	
}

public void retblnc(int amt){
	int w1=one,w5=five,w10=ten,w25=tfive,d=amt;
	int r1=0,r5=0,r10=0,r25=0;
	while(amt>=25)
	{
		if(w25>0)
		   {
			amt-=25;
			w25--;
			r25++;
		   }
		else 
			break;
	}
	while(amt>=10)
	{
		if(w10>0)
		   {
			amt-=10;
			w10--;
			r10++;
		   }
		else 
			break;
	}
	while(amt>=5)
	{
		if(w5>0)
		   {
			amt-=5;
			w5--;
			r5++;
		   }
		else 
			break;
	}
	while(amt>=1)
	{
		if(w1>0)
		   {
			amt-=1;
			w1--;
			r1++;
		   }
	}
	one=w1;
	five=w5;
	ten=w10;
	tfive=w25;
	System.out.println("Amount to be returned:"+d+"\n One:"+r1+"\nFive:"+r5+"\nTen:"+r10+"\nTwentyfive:"+r25);
		
}

public void supplier()
{
while(true){
	System.out.println("Supplier operations");
	System.out.println("1.View status");
	System.out.println("2.Restock");
	System.out.println("3.Reset cash");
	System.out.println("4.Go to starting page");
	switch(userin()){
	case 1:
		view();
		break;
	case 2:
		restock();
		break;
	case 3:
		cashout();
	case 4:
		return;
	}
	sc.nextLine();
}	
}
private void view(){
	coke.printstock();
	pepsi.printstock();
	soda.printstock();
	System.out.println("\nCash in machine:");
	System.out.println("Twentyfive:"+tfive+"    \nTen:"+ten+"    \nFive:"+five+"    \nOne:"+one);
	System.out.println("Total cash:"+(one+five*5+ten*10+tfive*25));
}

private void restock(){
	System.out.println("Enter No of pepsi");
	pepsi.add(Integer.parseInt(sc.nextLine()));
	System.out.println("Enter No of coke");
	coke.add(Integer.parseInt(sc.nextLine()));
	System.out.println("Enter No of soda");
	soda.add(Integer.parseInt(sc.nextLine()));
}
private void cashout(){
	System.out.println("Enter no of rs 25 denominations:");
	tfive=Integer.parseInt(sc.nextLine());
	System.out.println("Enter no of rs 10 denominations:");
	ten=Integer.parseInt(sc.nextLine());
	System.out.println("Enter no of rs 5 denominations:");
	five=Integer.parseInt(sc.nextLine());
	System.out.println("Enter no of rs 1 denominations:");
	one=Integer.parseInt(sc.nextLine());
}
class item{
	public String name =new String();
	public int cost;
	public int stock;
	public int serno;
	public String print(){
		if(stock>0)
		return (serno+"."+name+"("+cost+")");
		else 
			return "------";
	}
	void printstock(){
		System.out.println("Stock remaining:"+name+" : "+stock);
	}
	void add(int m){
		stock=m;
	}
	public item(String s, int c,int st){
		name=s;
		cost=c;
		serno=st;
	}
	
}
}