package org.bitcamp.ex0801.collection.list;

import java.util.List;
import java.util.Vector;

public class VectorExample {
	public static void main(String... args) {
		List<Board> list = new Vector<>();
		
		list.add(new Board("Title1","Contents1","Writer1"));
		list.add(new Board("Title2","Contents2","Writer2"));
		list.add(new Board("Title3","Contents3","Writer3"));
		list.add(new Board("Title4","Contents4","Writer4"));
		list.add(new Board("Title5","Contents5","Writer5"));
		
		list.remove(2);
		list.remove(3);
		
		System.out.println(list);
		for(int i=0; i<list.size(); i++) {
			Board board = list.get(i);
			System.out.println(board.subject+"\t"+board.content+"\t"+board.writer);
		} // for
			
		
	} // main
	
} // end class
