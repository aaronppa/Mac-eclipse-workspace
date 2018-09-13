package org.bitcamp.ex0727.ch12.multithread;

import java.awt.Toolkit;

import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class BeepPrintExample3 {

	public static void main(String[] args) {
		//		//how 1
		//				Thread thread = new BeepThread();

		// how 2: creating anonymous child object
		Thread thread = new Thread() {

			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();

				for(int i=0; i<Integer.MAX_VALUE; i++) {
					toolkit.beep();


					Thread currThread = Thread.currentThread();
					String currThreadName = currThread.getName();
					System.out.println("\t- currThread: "+ currThreadName);

					try {Thread.sleep(1000);
					} catch (Exception e){}
				}
			}
		};

		Thread thread0 = new Thread() {

			@Override
			public void run() {
				BasicPlayer player = new BasicPlayer();

				try {
					player.open(
							App.class.
							getResource("Salut d'amour_ Antonio Stradivari, 1709 'La Pucelle'.mp3"));
					player.play();
				} catch(BasicPlayerException e) {
					e.printStackTrace();
				} //try-catch
			}
		};

		thread.start();
		thread0.start();

		for(int i=0; i<Integer.MAX_VALUE;i++) {
			System.out.println("Beep");

			try {Thread.sleep(1000);
			} catch (Exception e){}
		}


	}
} // end class
