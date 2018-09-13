package unicycle;

public class UniBicycleEx {

	public static void main(String[] args) {
		
		Rider rider = new Rider("Black Panther", 170);
		
		rider.sitDown();
		rider.paddling(1);
		rider.stop();
//		rider.getOff();
		rider.paddling(1);
		rider.paddling(2);
	}
}
