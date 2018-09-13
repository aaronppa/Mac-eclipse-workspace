package org.bitcamp.ex0726.ch14.lambda;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

public class ConsumerExample {
	public static void main(String[] args) {
		Consumer<String> consumer = t -> System.out.println(t +"8");
		consumer.accept("Java ");

		BiConsumer<String,String> bigConsumer = (t,u) -> System.out.println(t+u);
		bigConsumer.accept("Java ", "9");
		
		DoubleConsumer doubleConsumer = d -> System.out.println("Java "+d);
		doubleConsumer.accept(10.0);
		
		ObjIntConsumer<String> objIntConsumer = (t, i) -> System.out.println(t+i);
		objIntConsumer.accept("Java ", 11);
	}

} // end class
