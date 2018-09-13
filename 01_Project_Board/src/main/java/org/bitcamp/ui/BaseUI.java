package org.bitcamp.ui;

import java.util.Scanner;

public abstract class BaseUI {
	Scanner sc = new Scanner(System.in);
	
	public abstract void service();
	
	public String getStr(String msg) {
		System.out.println(msg);
		return sc.nextLine();
	} // getStr
	
	public int getInt(String msg) {
		System.out.println(msg);
		return Integer.parseInt(sc.nextLine());
	} // getInt
	
}
