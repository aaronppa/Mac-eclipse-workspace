package org.bitcamp.ex11;

import java.util.Arrays;

public class GenericArray<T>{
	T[] array;

	// Constructor
	public GenericArray(int capacity) {
//		array = new int[capacity];// T Type class로는 이게 불가능하니, 다음 두단계를 통해 field를 대
		Object obj = new Object[capacity];
		array = (T[]) obj; 
	} // constructor
	
	public void add(int index, T element) {
		array[index] = element;
	} // add
	
	@Override
	public String toString() {
		return Arrays.toString(array);
	}
	
	
	public static void main(String[] args) {
		GenericArray<String> ga = new GenericArray<>(10);
		ga.add(0, "String1");
		ga.add(1, "String2");
		
		System.out.println(ga.toString());
	}
}
