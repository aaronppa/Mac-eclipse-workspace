package org.bitcamp.ex11;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarTable1 {
	public static void main(String[] args){

		Calendar c = Calendar.getInstance(); // Calendar 객체 생성

		//		System.out.println("today is "+c.getTime()); // 현재시각을 알려주는 메소드 입니다.		

		Scanner scan = new Scanner(System.in);

		System.out.print("연도를 입력하세요 : ");
		String year = scan.nextLine();
		
		// 대소문자 구분없이 입력값을 today로 받으면,
		if(year.equalsIgnoreCase("today")) {
			// 오늘 날짜 셋
			int nowYear = c.get(Calendar.YEAR); 
			int nowMonth = (c.get(Calendar.MONTH)+1);
			int nowDay = c.get((Calendar.DATE));
			
			// 이번달의 달력을 출력하기위해서 이번달의 첫일을 1로 셋팅하는데 안하면 이번달의 날짜는 24일로 남아있어서 
			// 달력을 Display 할때 첫번째 주의 요일이 제대로 처리 안됌.
			c.set(Calendar.DAY_OF_MONTH, 1); // 처음 시작일 셋

			// 오늘의 달의 첫번째 날의 요일을 셋팅 한다 
			int dayofweek = c.get(Calendar.DAY_OF_WEEK);


			// 일 = 1 월 =2 화 =3 ..

//			c.set(Calendar.DAY_OF_MONTH, 32); //32 이상일땐 마지막 요일로 자동 설정
//			System.out.println(c.get(Calendar.DAY_OF_MONTH));
			
			// 
//			int lastday = 32 - c.get(Calendar.DAY_OF_MONTH);
//			System.out.println(lastday);
			
			// 해당 달 마지막 날을 설정할때 위에 보다 그냥 getActualMaximum 을 사용하면 대체 가능 
			int lastday = c.getActualMaximum(Calendar.DAY_OF_MONTH);
			int i=0;
			
			System.out.printf("--------------------- " + nowYear + "년 " + nowMonth + "월 ---------------------%n");
			System.out.printf("  일\t 월\t 화\t 수\t 목\t 금\t 토%n");

			// 
			for(;i<dayofweek - 1; i++) {
				System.out.print("\t");

			} // for		

			int day = 1;

			for(day=1; day<=lastday; day++,i++) {
				if(i % 7 == 0){
					System.out.println("");
				} // if

				if(nowDay == day) {
					System.out.print("(" + day + ")" + "\t");
					day++;
					i++;
				} // if

				System.out.printf("%1$3d", day);
				System.out.print("\t");
			} // for

		} else {

			System.out.print("월을 입력하세요 : ");
			String month = scan.nextLine();

			// set메소드를 통해 연도 월 일 을 설정

			c.set(Calendar.YEAR, Integer.valueOf(year)); 
			c.set(Calendar.MONTH, Integer.valueOf(month)-1); // 시작 일이 1이 아닌 0부터 시작하여  1을 빼줌니다
			c.set(Calendar.DAY_OF_MONTH, 1); // 처음 시작요일설정		

			int dayofweek = c.get(Calendar.DAY_OF_WEEK);

			// 일 = 1 월 =2 화 =3 ..

//			c.set(Calendar.DAY_OF_MONTH, 32); //32 이상일땐 마지막 요일로 자동 설정

//			int lastday = 32 - c.get(Calendar.DAY_OF_MONTH);
			int lastday = c.getActualMaximum(Calendar.DAY_OF_MONTH);
			int i = 0;

			System.out.printf("--------------------- " + year + "년 " + month + "월 ---------------------%n");
			System.out.printf("일\t월\t화\t수\t목\t금\t토%n");

			for(;i<dayofweek - 1; i++) {
				System.out.print("\t");

			} // for		

			for(int day=1; day<=lastday; day++,i++) {
				if(i % 7 == 0){
					System.out.printf("%n");
				} // if

				System.out.print(day + "\t");
			} // for

		} // if-else

	} // main
}
