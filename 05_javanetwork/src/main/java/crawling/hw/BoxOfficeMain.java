package crawling.hw;

import java.util.Scanner;

public class BoxOfficeMain {
	public static void main(String[] args) {
		while(true) {
			Scanner sc = new Scanner(System.in);
			MovieRank mr = new MovieRank();
			PersonRank pr = new PersonRank();
			TicketReserveRank tr = new TicketReserveRank();
			menu();
			while(true) {
				switch(sc.nextInt()) {
				case 1: mr.Rank(); ; break;
				case 2: pr.Rank() ; break;
				case 3: tr.Rank() ; break;
				case 0: sc.close(); quit(); 
				} // switch
				menu();
			} // inner-while
		} // out-while
	} // main 

	public static void menu() {
		System.out.println("---------------------------------------------------");
		System.out.println("-= 한국 영화 랭킹 =-");
		System.out.println("---------------------------------------------------");
		System.out.println("1. 영화 랭킹");
		System.out.println("2. 영화인 랭킹");
		System.out.println("3. 예매율 랭킹");
		System.out.println("0. 종료");
		System.out.println("---------------------------------------------------");
		System.out.println("번호로 메뉴를 선택하세요> ");
	}

	public static void quit() {
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}
}
