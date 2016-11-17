package com.cjg.jsj;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Closeable;

import javax.swing.text.StyleContext.SmallAttributeSet;

public class Calculator extends WindowAdapter{
	
	//定义3个面板
	Panel p1 = new Panel();
	Panel p2 = new Panel();
	Panel p3 = new Panel();
	TextField txt;
	private Button[] b = new Button[17];
	private String ss[] = {"7","8","9","+","4","5","6","-",
			"1","2","3","*","clear","0","=","/","close"};
	static double a;
	static String s, str;
	public void frame(){
		Frame fm = new Frame("计算器");
		for (int i = 0; i <= 16; i++) {
			b[i] = new Button(ss[i]);
		}
		for (int f = 0; f <=15; f++) {
			p2.add(b[f]);
		}
		b[16].setBackground(Color.yellow);
		//创建和设置文本框
		txt = new TextField(15);
		txt.setEditable(false);
		for (int i = 0; i <=16; i++) {
			b[i].addActionListener(new buttonlistener());//为按钮添加监听器
		}
		b[16].addActionListener(new close());
		fm.addWindowListener(this);
		fm.setBackground(Color.red);
		p1.setLayout(new BorderLayout());
		p1.add(txt, "North");
		p2.setLayout(new GridLayout(4, 4));
		p3.setLayout(new BorderLayout());
		p3.add(b[16]);
		//添加各个面板到窗口上
		fm.add(p1, "North");
		fm.add(p2, "Center");
		fm.add(p3, "South");
		fm.pack();
		fm.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		(new Calculator()).frame();
	}
	
	public void windowClosing(WindowEvent e){
		System.exit(0);
	}
	
	class buttonlistener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Button btn = (Button)e.getSource();
			if (btn.getLabel() == "=") {
				jisuan();
				str = String.valueOf(a);
				txt.setText(str);
				s = "";
			} else if(btn.getLabel() == "+"){
				jisuan();
				txt.setText("");
				s = "+";
			}else if(btn.getLabel() == "-"){
				jisuan();
				txt.setText("");
				s = "-";
			}else if(btn.getLabel() == "*"){
				jisuan();
				txt.setText("");
				s = "*";
			}else if(btn.getLabel() == "/"){
				jisuan();
				txt.setText("");
				s = "/";
			}else if(btn.getLabel() == "clear"){
				txt.setText("");
			}else {
				txt.setText(btn.getLabel());
				
			}
		}
	}
	
	public void jisuan(){
		if (s == "+") {
			a +=Double.parseDouble(txt.getText());
		}else if(s == "-"){
			a -=Double.parseDouble(txt.getText());
		}else if(s == "*"){
			a *=Double.parseDouble(txt.getText());
		}else if(s == "/"){
			a /=Double.parseDouble(txt.getText());
		}else {
			a = Double.parseDouble(txt.getText());
		}
		
	}
	
	class close implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	}

}
