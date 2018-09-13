package org.bitcamp.ex0806.firstday_practice;

public class Problem2 {

	static int[] array = {10, 30, 20, 90 ,50};

	public static void main(String...args) {
		calculate(array);
		
	}
	
	static void calculate(int[] array) {
		int total=0;
		
		for(int i=0; i<=array.length-1;i++) {
			total+=array[i];
			
		} // for

		for(int j=0;j<=array.length-1; j++) {
			double tmp = array[j]*100/total;
			for(int i=0;i<=tmp-1; i++) {
				System.out.print("*");
			}
			System.out.println(" "+(double)tmp+"%");
		}
	
	} // calculate()
	
} // end class
