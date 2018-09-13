package unicycle;

public class WheelBig extends Wheel {
	//필드
	
	//생성자
	WheelBig(){
		super.wheelSize=60;
	}
	
	//메소드
	@Override
	public void roll() {
		System.out.println(super.getWheelSize() + "cm 갑니다.");
	}

}//end class
