package PracticeBoard.ui;

import java.util.Scanner;

public abstract class BaseUI {
	
	Scanner sc = new Scanner(System.in);
	
	public void service() {};
	
	public String getStr(String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}
	
	public int getInt(String msg) {
		System.out.println(msg);
		return Integer.parseInt(sc.nextLine());
	}
	
} // end abstract class
