package unicycle;

public abstract class Wheel {
	//필드
	Frame frame;
	int wheelSize;
	
	public Frame getFrame() {
		return frame;
	}


	public void setFrame(Frame frame) {
		this.frame = frame;
	}


	public int getWheelSize() {
		return wheelSize;
	}


	public void setWheelSize() {
		this.wheelSize = wheelSize;
	}

	
	
	//생성자
	
	//메소드
	public abstract void roll();
}
