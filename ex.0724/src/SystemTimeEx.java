
public class SystemTimeEx {

	public static void main(String[] args) {
		long start = System.nanoTime();

		int sum = 0;
		for (int i = 1; i <= 1000000; i++) {
			sum += 1;

		} // for

		long end = System.nanoTime();

		System.out.println("1~10000000까지의 합: " + sum);
		System.out.println("계산에 " + ((double) (end - start) / Math.pow(10.0, 9)) + " 나노초가 소요되었습니다.");
	}
}
