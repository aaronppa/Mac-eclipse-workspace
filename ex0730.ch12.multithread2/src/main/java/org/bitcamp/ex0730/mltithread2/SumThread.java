package org.bitcamp.ex0730.mltithread2;

public class SumThread extends Thread{

	private long sum;
	
	public long getSum() {
		return sum;
		
	} // getSum
	
	public void setSum(long sum) {
		this.sum = sum;
	} // setSum
	
	@Override
	public void run() {
		for(int i=1; i<=100; i++) {
			sum+=i;
		}
		
		try {
			Thread.sleep(1000*10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // run
	
} // end class
