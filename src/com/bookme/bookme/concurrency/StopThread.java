package com.bookme.bookme.concurrency;

//import java.util.concurrent.TimeUnit;

public class StopThread {
	private static volatile boolean stop;
	
	public static void main(String[] args) throws InterruptedException{
		new Thread(new Runnable(){
			public void run(){
				while(!stop){
					System.out.println("in while...");
				}
			}
		}).start();
		
		Thread.sleep(100);
		stop=true;
		System.out.println("in main");
	}

}
