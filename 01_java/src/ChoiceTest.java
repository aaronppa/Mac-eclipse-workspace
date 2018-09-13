import java.util.Random;

public class ChoiceTest {
	public static void main(String[] args) throws Exception {
		System.out.println("누가 풀까요?");
		Thread.sleep(2000);
		System.out.println(new Random().nextInt(27) + 1 + "번");
	}
}
