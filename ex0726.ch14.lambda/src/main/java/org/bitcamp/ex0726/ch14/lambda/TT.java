package org.bitcamp.ex0726.ch14.lambda;

public class TT {
	public static void main(String[] args) {
		I impl = new I() {

			@Override
			public void forYou() {
				// TODO Auto-generated method stub
			}
		}; // 익명 구현 객체
		System.out.println("- impl: "+impl);
		
		IFunctional impl2 = () -> {
			System.out.println("No, man. I'm STRAIGHT");
		};
		impl2.doYouLoveMe();
		
		System.out.println(impl2);
	} // main

} // end class
