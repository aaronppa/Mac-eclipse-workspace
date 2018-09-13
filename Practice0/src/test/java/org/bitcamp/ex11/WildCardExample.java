package org.bitcamp.ex11;

import java.util.Arrays;

public class WildCardExample {
	public static void registerCourse(Course<?> course) {
		System.out.println(course.getName() + " 수강생: " + 
				Arrays.toString(course.getStudents()));
 	}
	
	public static void registerCourseStudent(Course<? extends TStudent> course) {
		System.out.println(course.getName() + " 수강생: " + 
				Arrays.toString(course.getStudents()) );
 	}
	
	public static void registerCourseWorker(Course<? super Worker> course) {
		System.out.println(course.getName() + " 수강생: " + 
				Arrays.toString(course.getStudents()));
	}
	
	public static void main(String[] args) {
		Course<TPerson> personCourse = new Course<TPerson>("일반인과정", 5);
			personCourse.add(new TPerson("일반인"));
			personCourse.add(new Worker("직장인"));
			personCourse.add(new TStudent("학생"));
			personCourse.add(new HighStudent("고등학생"));
			
		Course<Worker> workerCourse = new Course<Worker>("직장인과정", 5);
			workerCourse.add(new Worker("직장인"));
			
		Course<TStudent> studentCourse = new Course<TStudent>("학생과정", 5);
			studentCourse.add(new TStudent("학생"));
			studentCourse.add(new HighStudent("고등학생"));
			
		Course<HighStudent> highStudentCourse = new Course<HighStudent>("고등학생과정", 5);
			highStudentCourse.add(new HighStudent("고등학생"));	
		
		registerCourse(personCourse);
		registerCourse(workerCourse);
		registerCourse(studentCourse);
		registerCourse(highStudentCourse);
		System.out.println();
		
		//registerCourseStudent(personCourse); 			(x)
		//registerCourseStudent(workerCourse); 			(x)
		registerCourseStudent(studentCourse);
		registerCourseStudent(highStudentCourse);	
		System.out.println();
		
		registerCourseWorker(personCourse);
		registerCourseWorker(workerCourse);
//		registerCourseWorker(studentCourse); 			(x)
		//registerCourseWorker(highStudentCourse); 		(x)
	}
}