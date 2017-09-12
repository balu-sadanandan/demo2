package com.test;


class Multi extends Thread{  
public void run(){  
System.out.println("thread is running...");  
for(int i=1;i<5;i++){
System.out.println(i);
try{
	Thread.sleep(500);
}
catch(InterruptedException e){
	System.out.println(e);
}
}
}  
public static void main(String args[]){  
Multi t1=new Multi(); 
Multi t2 = new Multi();
Multi t3 =new Multi();

//t1.run();
//t2.run();

t3.start();
try {
	t3.join();
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	System.out.println("ex");
}
t1.start();  
t2.start();
 }  
}  