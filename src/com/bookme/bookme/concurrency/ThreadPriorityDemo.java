package com.bookme.bookme.concurrency;

public class ThreadPriorityDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread());
		
		Thread t1=new Thread(new EmailCampaign());
		Thread t2= new Thread(new DataAggregator());
		
		t1.setName("EmailCampaign");
		t2.setName("DataAggregator");
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		
		t1.start();
		t2.start();
		
		try{
			t2.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		
		System.out.println("inside main...");
	}

}

class EmailCampaign implements Runnable{

	@Override
	public void run() {
		for(int i=1;i<=5;i++){
			System.out.println(Thread.currentThread().getName());
			if(i==3){
				Thread.currentThread().yield();
			}
		}
		
	}
	
}

class DataAggregator implements Runnable{

	@Override
	public void run() {
		for(int i=1;i<=5;i++){
			System.out.println(Thread.currentThread().getName());
		}
		
	}
	
}