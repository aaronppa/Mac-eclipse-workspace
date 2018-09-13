package unicycle;

public class Rider {
	//필드
	String name;
	UniCycle unicycle;
	Direction direction;
	Wheel wheel;
	Frame frame;
	int height;
	
	
	//생성자
	Rider(String name, int height){
		this.name = name;
		this.height = height;
		frame = new FrameGold();
		if(height>=180) {
			this.wheel=new WheelBig();
			this.frame.seat= new SeatHigh();
			System.out.println("Wheel size는 " + this.wheel.wheelSize + " & Seat 높이는" + this.frame.seat.height + " 입니다.");
			System.out.println("장착된 프레임 재질은 " + this.frame.material + " 입니다.");
		} else {
			this.wheel=new WheelSmall();
			this.frame.seat= new SeatShort();
			System.out.println("Wheel size는 " + this.wheel.wheelSize + " & Seat 높이는" + this.frame.seat.height + " 입니다.");
			System.out.println("장착된 프레임 재질은 " + this.frame.material + " 입니다.");
		} // if-else
	}
	
	//메소드
	void sitDown() {
		System.out.println("외발자전거에 앉았습니다. 자, 준비하세요!");
	} //sitdown method
	
	void paddling(int direction) {
		switch(direction) {
		case 1:
			System.out.print("앞으로 ");
			wheel.roll();
			break;
		case 2:
			System.out.print("뒤로 ");
			wheel.roll();
			break;
		case 3:
			System.out.print("왼쪽으로 ");
			wheel.roll();
			break;
		case 4:
			System.out.print("오른쪽으로 ");
			wheel.roll();
			break;
		} // switch 
		
	} // go method
	

	void stop() {
		System.out.println("멈춥니다.");
	} // stop method
	
	
	void getOff() {
		System.out.println("외발자전거에서 내립니다.");
		System.exit(0);
	} // getoff method
	
	
	void changePart() {
		
	} // changePart Method
	
}//end class