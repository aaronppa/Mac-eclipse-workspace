package org.bitcamp.ex0802.ch15.treemap;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample1 {

	public static void main(String...args) {
		TreeMap<Integer, String> scores = new TreeMap<>();
		scores.put(new Integer(87), "John");
		scores.put(new Integer(98), "Steve");
		scores.put(new Integer(75), "Paul");
		scores.put(new Integer(95), "Matt");
		scores.put(new Integer(80), "Kyle");

		Map.Entry<Integer, String> entry = null;
		
		entry = scores.firstEntry();
		System.out.println("Lowest Score: "+entry.getKey()+"-"+entry.getValue());
		
		entry = scores.lastEntry();
		System.out.println("Highest Score: "+entry.getKey()+"-"+entry.getValue()+"\n");
		
		entry = scores.lowerEntry(new Integer(95));
		System.out.println("Score below 95: "+entry.getKey()+"-"+entry.getValue());
		
		entry = scores.higherEntry(new Integer(95));
		System.out.println("Score above 95: "+entry.getKey()+"-"+entry.getValue()+"\n");
		
		entry = scores.floorEntry(new Integer(95));
		System.out.println("Score equal to or right below 95: "+entry.getKey()+"-"+entry.getValue());
		
		entry = scores.ceilingEntry(new Integer(85));
		System.out.println("Score equal to or right above 85: "+entry.getKey()+"-"+entry.getValue()+"\n");
		
		while(!scores.isEmpty()) {
			entry = scores.pollFirstEntry();
			System.out.println(entry.getKey()+"-"+entry.getValue()+"(Remaining Object Number: "+scores.size()+")");
		}
	}
} // end class
