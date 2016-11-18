package com.wjy.noqueue;

public class TestWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Water water = new Water();        //创建一个水龙头对象
		//创建4个学生对象
		Student xiaochang = new Student("小常", water);  //学生小常
		Student xiaoshang = new Student("小尚", water);  //学生小尚
		Student xiaowang = new Student("小王", water);  //学生小王
		Student xiaoliu = new Student("小刘", water);  //学生小刘
		//启动4个线程
		xiaochang.start();
		xiaoshang.start();
		xiaowang.start();
		xiaoliu.start();
	}

}
