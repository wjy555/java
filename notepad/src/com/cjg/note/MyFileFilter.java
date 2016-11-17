package com.cjg.note;

import java.io.File;

public class MyFileFilter extends javax.swing.filechooser.FileFilter {

	@Override
	public boolean accept(File f) {
		// TODO Auto-generated method stub
		if (f.isDirectory() || f.getName().endsWith(".txt")) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "记事本文件(*.txt)";
	}

}
