package org.bitcamp.ex0806.firstday_practice;

import java.util.Arrays;

public class Problem3 {

	String worker;
	
	Problem3(String name){
		this.worker=name;
	}
	
	public static void main(String...args) {
	int[] workPoints= {90,95,78,92,97};
	int engPoint=995;
	
	Problem3 problem= new Problem3("Won Choi");
	problem.evaluateGrade(workPoints,engPoint);
	System.out.println("<<처리결과>>");
	System.out.printf("4번 평가 점수: ");
	System.out.println(Arrays.toString(workPoints));		
	System.out.println();
	System.out.println("영어 점수: "+engPoint);
	System.out.println();
	System.out.println(problem.worker+"'s Final Grade: "+problem.evaluateGrade(workPoints, engPoint));
	
	}	// main
	
	String evaluateGrade(int[] workPoints, int engPoint) {
		String grade;
		int total=0;
		for(int i=0; i<=workPoints.length-1;i++) {
			total = total+workPoints[i];
		} // array sum for
		
		int avg = total/workPoints.length;
		
		int finalPoint = avg+(engPoint/1000);
		
		if(finalPoint>=90 && finalPoint<=110) {
			grade = "A";
			return grade;
		} else if (finalPoint>=80) {
			grade = "B";
			return grade;
		} else if (finalPoint>=70) {
			grade = "C";
			return grade;
		} else {
			grade = "D";
			return grade;
		} // if-else condition
			
	} //evaluate
} // end class
