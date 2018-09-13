package org.bitcamp.ex11;

import junit.framework.TestCase;

public class ProductEx extends TestCase{
	public void testProductEx() {
		Product<Tv, String> product1 = new Product<>();
		product1.setKind(new Tv());
		product1.setModel("스마트Tv");
		Tv tv = product1.getKind();
		String TvModel = product1.getModel();
		
		Product<TCar, String> product2 = new Product<>();
		product2.setKind(new TCar());
		product2.setModel("디젤");
		TCar car = product2.getKind();
		String carModel = product2.getModel();
	}
	
}
