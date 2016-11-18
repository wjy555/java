package com.wjy.noqueue;

public class Student extends Thread{
	//创建两个成员字段
	private String studentName;      //学生名字字段
	private Water water;          //水龙头字段
	public Student(String studentName,Water water){
		super();
		this.studentName = studentName;
		this.water = water;
	}
	//学生接水全过程
	public void receiveWater(){
		//学生跑向水龙头
		System.out.println(studentName + "从教室跑向水龙头"); 
		water.flowWater(studentName);   //水龙头流水
		System.out.println(studentName + "跑回教室");
	}
	public void run(){
		receiveWater();
	}
}
