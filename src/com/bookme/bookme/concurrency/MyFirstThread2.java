package com.bookme.bookme.concurrency;

public class MyFirstThread2 extends Thread{
	public void run() {
		System.out.println("Inside run...");
		go();
	}

	private void go() {
		System.out.println("Inside go...");
		more();
		
	}

	private void more() {
		System.out.println("Inside more...");
		
	}
	public static void main(String[] args) {
		MyFirstThread2 thread=new MyFirstThread2();
		thread.start();
		
		System.out.println("inside main2..");
		

	}

}
