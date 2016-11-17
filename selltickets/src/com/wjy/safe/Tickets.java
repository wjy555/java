package com.wjy.safe;

public class Tickets implements Runnable{

	int tickets = 4;          
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			synchronized (this) {
				if (tickets > 0) {
					//输出相应的信息
					System.out.println("顾客到达" + 
					Thread.currentThread().getName() + "售票台");
					//输出相应的信息
					System.out.println("售票台" + 
					Thread.currentThread().getName() + "准备卖第" + tickets +
					"张票");
					try {
						//输出相应信息
						System.out.println("售票台需要5分钟处理买票");
						//通过循环遍历
						for (int i = 1; i < 5; i++) {
							Thread.sleep(5);
							System.out.print(i + "分钟");
						}
						//输出相应信息
						System.out.println("\n售票台" + 
						Thread.currentThread().getName() + "卖完第" + 
								tickets + "张票");
						//输出相应信息
						System.out.println("顾客从" + 
						Thread.currentThread().getName() + "售票台买到票");
						--tickets;
					} catch (InterruptedException e) {
						// TODO: handle exception
						System.err.println("卖票不成功");
						System.exit(1);      //推出系统
					}
					
				}
			}
			
		}
	}

}
