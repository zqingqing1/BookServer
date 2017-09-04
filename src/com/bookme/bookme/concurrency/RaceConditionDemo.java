package com.bookme.bookme.concurrency;

public class RaceConditionDemo {

	public static void main(String[] args) {
		BankAccount task=new BankAccount();
		task.setBalance(100);
		
		Thread john=new Thread(task);
		Thread anita=new Thread(task);
		
		john.setName("John");
		anita.setName("Anita");
		
		
		anita.start();
		john.start();

	}
}
class BankAccount implements Runnable{
	private int balance;
	public synchronized int getBalance(){
		return balance;
	}
	public void setBalance(int balance){
		this.balance=balance;
	}
	
	@Override
	public void run() {
		makewithdrawal(75);
		if(balance<0){
			System.out.println(Thread.currentThread().getName()+" Money overdrawn!");
		}
		
	}
	public void deposit(int amount){
		String s=new String();
		synchronized(s){
			balance+=amount;
		}
	}

	public synchronized void makewithdrawal(int money){
		if(balance>=money){
			System.out.println(Thread.currentThread().getName()+" is about to withdrawal "+money);
			balance-=money;
			System.out.println(Thread.currentThread().getName()+" has withdrawn "+money+ ", balance is "+balance);
		}else{
			System.out.println(Thread.currentThread().getName()+" has no enough money "+money);
		}
	}
	
}
