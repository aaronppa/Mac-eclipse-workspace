package unicycle;

public class WheelSmall extends Wheel {
	//필드
	
	//생성자
	WheelSmall(){
		super.wheelSize=30;
	}
	//메소드
	@Override
	public void roll() {
		System.out.println(super.getWheelSize() + "cm 갑니다.");
	}

}
