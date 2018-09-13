package org.bitcamp.ex0725;

import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class App {
    public static void main( String[] args ) {

    	BasicPlayer player = new BasicPlayer();
    	
    	try {
    		player.open(
    				App.class.
    				getResource("Salut d'amour_ Antonio Stradivari, 1709 'La Pucelle'.mp3"));
    		player.play();
    	} catch(BasicPlayerException e) {
    		e.printStackTrace();
    	} //try-catch
    	
    	
    } // main
    
} // end class
