package hw.translator;

import java.util.Scanner;

public class MainTranslator {

	public static void main(String[] args) {		
	menu();
	} // main

	public static void menu() {
		while(true) {
		PapagoAPI tr = new PapagoAPI();
		System.out.println("다음 중 한국어를 번역할 언어를 선택하세요.");
		System.out.println("--------------------------------------");
		System.out.println("1. 영어");
		System.out.println("2. 중국어");
		System.out.println("3. 일본어");
		System.out.println("4. 스페인어");
		System.out.println("5. 베트남어");
		System.out.println("6. 종료");
		System.out.println("--------------------------------------");
		System.out.println("언어 선택> ");
		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();
		
		switch (no) {
		case 1: tr.translate("en"); break; 
		case 2: tr.translate("zh-CN"); break;
		case 3: tr.translate("ja"); break;
		case 4: tr.translate("es"); break;
		case 5: tr.translate("vi"); break; 
		case 6: quit();
		default: return;
		}
		}
	}
	
	public static void quit() {
		System.exit(0);
	}
}
