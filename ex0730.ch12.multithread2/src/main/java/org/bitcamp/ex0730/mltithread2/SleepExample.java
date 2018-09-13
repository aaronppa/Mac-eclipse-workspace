package org.bitcamp.ex0730.mltithread2;

import java.awt.Toolkit;

public class SleepExample {

	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		for(int i=0; i<10; i++) {
			toolkit.beep();

			try {
				Thread.sleep(1000*600);
			} catch (InterruptedException e) {
				;;
			}

		} // for loop
		
	} // main

} // end class
