package com.bookme.bookme.concurrency;

import java.util.concurrent.TimeUnit;

public class MyFirstThread {

	public static void main(String[] args) {
		Task task=new Task();
		Thread thread= new Thread(task);
		thread.start();
		try{
			//Thread.sleep(3000);
			TimeUnit.SECONDS.sleep(3);
			thread.interrupt();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		System.out.println("inside main..");
	}
}
class Task implements Runnable{

	@Override
	public void run() {
		System.out.println("Inside run...");
		try{
			//Thread.sleep(3000);
			TimeUnit.SECONDS.sleep(9);
		}catch(InterruptedException e){
			
			System.out.println("Interrupted!!");
			//e.printStackTrace();
		}
		go();
	}

	private void go() {
		System.out.println("Inside go...");
		more();
		
	}

	private void more() {
		System.out.println("Inside more...");
		
	}
	
	
	
}
