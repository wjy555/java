package com.wjy.safe;

public class Station {
	public static void main(String[] args){
		Tickets tickets = new Tickets();      //创建火车票对象
		//创建4个线程对象，即顾客对象
		Thread static1 = new Thread(tickets);
		Thread static2 = new Thread(tickets);
		Thread static3 = new Thread(tickets);
		Thread static4 = new Thread(tickets);
		static1.start();      //启动4个线程
		static2.start();
		static3.start();
		static4.start();
	}
}
