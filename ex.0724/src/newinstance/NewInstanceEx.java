package newinstance;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class NewInstanceEx {

	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("newinstance.SendAction");
			// Class clazz = Class.forName("newinstance.ReceiveAction");
			
//			Action action = (Action) clazz.newInstance();
			Constructor[] constructors = clazz.getConstructors();
			Action action;
			try {
				action = (Action) constructors[0].newInstance("Won", 23);
				action.execute();
			} catch (IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			action.execute();

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		} 
			
	}
} // end class
