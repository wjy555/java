package com.cjg.note;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;

import org.omg.PortableInterceptor.DISCARDING;

public class Notepad extends JFrame implements ActionListener{
	//创建成员变量
	File file = null;  //文件对象变量
	Color color = Color .black;   //颜色对象变量
	JTextPane text = new JTextPane();  //文本框对象变量
	JDialog about = new JDialog(this);  //实现关于“功能”的对话框对象
	JFileChooser fileChooser = new JFileChooser();  //打开/保存文件的对话框变量
	GraphicsEnvironment getFont = GraphicsEnvironment.getLocalGraphicsEnvironment();//环境变量
	Font[] fonts = getFont.getAllFonts();   //获取本地所有的字体
	JColorChooser colorChooser = new JColorChooser();  //颜色选择器对象
	//创建菜单的成员变量
	//File菜单的菜单选项
	private JMenuItem jminew,jmiopen,jmisave,jmisaves;
	//Edit菜单的选项
	private JMenuItem jmicut,jmicopy,jmiplaster,jmiall;
	//Format菜单的选项
	private JMenuItem jmifont,jmicolor;
	//Tool菜单的选项
	private JMenuItem jminotepad,jmicalculator;
	//Help菜单的选项
	private JMenuItem jmiabout;
	//Exit菜单的选项
	private JMenuItem jmiexit;
	
	
	//主方法
	public static void main(String[] args){
		Notepad frame = new Notepad();   //创建Notepad对象
		//设置窗口的推出功能
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//显示窗口
		frame.pack();
		frame.setVisible(true);
		
	}
	
	
	
	
	public Notepad(){
		//设置窗口对象
		setTitle("记事本");
		setLocation(100, 50);//设置位置
		//创建和设置菜单栏
		JMenuBar jmb = new JMenuBar();  //创建菜单栏对象
		setJMenuBar(jmb);  //设置菜单栏到窗口中
		//创建工具栏上的6个菜单
		//创建和设置File菜单
		JMenu filemenu = new JMenu("File");  //创建菜单filemenu
		filemenu.setMnemonic('F');;   //设置菜单的hotkey键
		jmb.add(filemenu);   //添加菜单到菜栏对象jmb中
		//创建和设置Edit菜单
		JMenu editmenu = new JMenu("Edit");  
		filemenu.setMnemonic('E');;   
		jmb.add(editmenu);   
		//创建和设置Format菜单
		JMenu formatmenu = new JMenu("Format");  
		filemenu.setMnemonic('T');;   
		jmb.add(formatmenu);   
		//创建和设置Tool菜单
		JMenu toolmenu = new JMenu("Tool");  
		filemenu.setMnemonic('L');;   
		jmb.add(toolmenu);   
		//创建和设置Help菜单
		JMenu helpmenu = new JMenu("Help");  
		filemenu.setMnemonic('H');;   
		jmb.add(helpmenu);  
		//创建和设置Exit菜单
		JMenu exitmenu = new JMenu("Exit");  
		filemenu.setMnemonic('X');;   
		jmb.add(exitmenu); 
		//设置工具栏上6个菜单的菜单选项
		//设置File菜单的菜单选项
		//创建和设置File菜单的菜单选项New
		filemenu.add(jminew = new JMenuItem("New",'N'));  //添加New选项
//		jminew.setIcon(new ImageIcon(""));
		//创建和设置File菜单的菜单选项Open
		filemenu.add(jmiopen = new JMenuItem("Open",'O'));
//		jmiopen.setIcon(new ImageIcon(""));
		//创建和设置File菜单的菜单选项Save
		filemenu.add(jmisave = new JMenuItem("Save",'S'));
//		jmisave.setIcon(new ImageIcon(""));
		filemenu.addSeparator();    //添加分隔线
		//创建和设置File菜单的菜单选项Save
		filemenu.add(jmisaves = new JMenuItem("Save as"));
//		jmisaves.setIcon(new ImageIcon(""));
		//设置前3个菜单选项的 快捷键
		//1.设置菜单选项jminew快捷方式
		jminew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		jmiopen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		jmisave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		//设置Edit菜单的菜单选项
		editmenu.add(jmicut = new JMenuItem("Cut",'X'));
//		jmicut.setIcon(new ImageIcon(""));
		editmenu.add(jmicopy = new JMenuItem("Copy",'C'));
//		jmicopy.setIcon(new ImageIcon(""));
		editmenu.add(jmiplaster = new JMenuItem("Plaster",'V'));
//		jmiplaster.setIcon(new ImageIcon(""));
		editmenu.addSeparator();
		editmenu.add(jmiall = new JMenuItem("All"));
//		jmiall.setIcon(new ImageIcon(""));
		//设置Format菜单的菜单选项
		formatmenu.add(jmifont = new JMenuItem("Font",'F'));
//		jmifont.setIcon(new ImageIcon(""));
		formatmenu.add(jmicolor = new JMenuItem("Color",'C'));
//		jmicolor.setIcon(new ImageIcon(""));
		//设置Tool菜单的菜单选项
		toolmenu.add(jminotepad = new JMenuItem("MS Notepad",'N'));
//		jminotepad.setIcon(new ImageIcon(""));
		toolmenu.add(jmicalculator = new JMenuItem("MS Calculator",'C'));
//		jmicalculator.setIcon(new ImageIcon(""));
		//设置Help菜单的菜单选项
		helpmenu.add(jmiabout = new JMenuItem("About",'A'));
//		jmiabout.setIcon(new ImageIcon(""));
		//设置Exit菜单的菜单选项
		exitmenu.add(jmiexit = new JMenuItem("Exit",'E'));
//		jmiexit.setIcon(new ImageIcon(""));
		//设置和初始化文本框对象text
		setFont(new Font("Times New Roman", Font.PLAIN, 12));//设置字体
		JScrollPane scrollPane = new JScrollPane(text);   //创建包含text的滚动面板
		//设置滚动面板的大小
		scrollPane.setPreferredSize(new Dimension(600, 500));
		getContentPane().add(scrollPane);   //添加滚动面板到窗口中
		//为所有的菜单选项注册事件
		//为File菜单选项注册事件
		jminew.addActionListener(this);
		jmiopen.addActionListener(this);
		jmisave.addActionListener(this);
		jmisaves.addActionListener(this);
		//为Edit菜单选项注册事件
		jmicut.addActionListener(this);
		jmicopy.addActionListener(this);
		jmiplaster.addActionListener(this);
		jmiall.addActionListener(this);
		//为Format菜单选项注册事件
		jmifont.addActionListener(this);
		jmicolor.addActionListener(this);
		//为Tool菜单选项注册事件
		jminotepad.addActionListener(this);
		jmicalculator.addActionListener(this);
		//为Help菜单选项注册事件
		jmiabout.addActionListener(this);
		//为Exit菜单选项注册事件
		jmiexit.addActionListener(this);
		
		
	}
	//事件监听器
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String name = e.getActionCommand();   //获取发生事件的组件显示字符
		//判断发生事件的组件
		if (e.getSource() instanceof JMenuItem) {
			//当发生事件的组件是New菜单选项时
			if("New".equals(name)){       //New菜单选项发生事件
				text.setText("");         // 清空text文本框
				file = null;              //为file变量赋值
			}
			//当发生事件的组件是Open菜单选项时
			if("Open".equals(name)){
				if(file != null)   //当file对象不为null时
					fileChooser.setSelectedFile(file); //设置对话框的选择文件属性
				//打开“打开文件对话框”
				int returnVal = fileChooser.showOpenDialog(Notepad.this);
				//当单击“打开”按钮时
				if(returnVal == JFileChooser.APPROVE_OPTION){
					file = fileChooser.getSelectedFile();   //设置file对象的值
					//读取file对象的内容
					try {
						//创建输入流对象
						FileReader fr = new FileReader(file);
						int len = (int)file.length();// 获取file的长度
						char[] buffer = new char[len];  //创建字符数组
						fr.read(buffer, 0, len);  //实现读取功能
						fr.close();   //关闭输入流
						//设置文本框内容
						text.setText(new String(buffer));
						
						
					} catch (Exception e_open) {
						// TODO: handle exception
						e_open.printStackTrace();
					}
				}
			}
		    //当发生事件的组件是Save菜单选项时
			if("Save".equals(name)){
				if(file != null){
					fileChooser.setSelectedFile(file);
				}
				//打开“保存文件对话框”
				int returnVal = fileChooser.showSaveDialog(Notepad.this);
				//当单击“保存”按钮时
				if(returnVal == JFileChooser.APPROVE_OPTION){
					file = fileChooser.getSelectedFile();  //设置file对象的值
				}
				try {
					//写入file对象的相应内容
					FileWriter fw = new FileWriter(file);  //创建输出流对象
					fw.write(text.getText());  //把文本框的内容输出
					fw.close();
					
				} catch (Exception e_save) {
					// TODO: handle exception
					e_save.printStackTrace();
				}
			}
			
			//当发生事件的组件是Cut菜单选项时
			if("Cut".equals(name)){
				text.cut();                    //调用cut()方法
			}
			//当发生事件的组件是Copy菜单选项时
			if("Copy".equals(name)){
				text.copy();                  //调用copy()方法
			}
			//当发生事件的组件是Plaster菜单选项时
			if("Plaster".equals(name)){
				text.paste();                  //调用paste()方法
			}
			//当发生事件的组件是All菜单选项时
			if("All".equals(name)){
				text.selectAll();              //调用selectAll()方法
			}
			//当发生事件的组件是Font菜单选项时
			if("Font".equals(name)){
				
			}
			//当发生事件是Color菜单选项时
			if("Color".equals(name)){
				//为color变量赋值
				color = JColorChooser.showDialog(Notepad.this, "颜色选择对话框",
						color);
				text.setForeground(color);   //设置文件的颜色
			}
			//当发生事件的组件是MS Notepad菜单选项时
			if("MS Notepad".equals(name)){
				try {
					String command = "notepad.exe";    //创建command命令  
					//执行命令
					Process child = Runtime.getRuntime().exec(command);
				} catch (IOException ex) {
					// TODO: handle exception
				}
			}
			//当发生事件的组件是MS Calculator菜单选项时
			if("MS Calculator".equals(name)){
				try {
					String command = "calc.exe";   //创建calc命令
					//执行命令
					Process child = Runtime.getRuntime().exec(command);
				} catch (IOException ex) {
					// TODO: handle exception
				}
			}
			//当发生事件的组件是About菜单选项时
			if("About".equals(name)){
				about.setLayout(new GridLayout(6, 1));//设置对话框about的布局管理器
				about.setTitle("About...");           //设置对话框标题
				about.setSize(320,280);               //设置对话框大小
				//设置对话框背景颜色
				about.getContentPane().setBackground(Color.BLUE);
				JLabel jlbfirst = new JLabel();    //创建面板对象jlbfist
	//			jlbfirst.setIcon(new ImageIcon(""));
				about.getContentPane().add(jlbfirst);  //添加面板jlnfirst到对话框
				//添加相应的信息
				about.getContentPane().add(new JLabel("Star"));
				about.getContentPane().add(new JLabel(
						"Edition 2.0 (author:wujunyu)"));
				about.getContentPane().add(new JLabel(
						"copyright possession (C) xxxx.x.x Star Corp."));
				about.getContentPane().add(new JLabel(
						"Thank you to use!"));
				about.setModal(true);    //设置对话框模式
				about.show(true);            //显示对话框
			}                                        
			//当发生的组件是Exit菜单选项时
			if("Exit".equals(name)){
				System.exit(0);          //退出系统
			}
		} 
	}
}
