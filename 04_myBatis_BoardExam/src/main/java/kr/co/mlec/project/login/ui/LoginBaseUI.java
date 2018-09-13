package kr.co.mlec.project.login.ui;

import java.util.Scanner;

public abstract class LoginBaseUI {
	Scanner sc = new Scanner(System.in);
	
	
	public int getInt(String msg) {
		System.out.print(msg);
		return Integer.parseInt(sc.nextLine());
	} 
	
	public String getStr(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}
	
	public abstract void service();
}
