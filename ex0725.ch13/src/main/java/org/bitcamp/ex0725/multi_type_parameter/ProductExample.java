package org.bitcamp.ex0725.multi_type_parameter;

import junit.framework.TestCase;

public class ProductExample extends TestCase{
	public void testPrductExample() {
		Product<Tv, String> product1 = new Product<>();
		product1.setKind(new Tv());
		product1.setModel("스마트 Tv");
		Tv tv = product1.getKind();
		String tvModel = product1.getModel();
		System.out.println(tv+" "+tvModel);
		
		Product<Car, String> product2 = new Product<>();
		product2.setKind(new Car());
		product2.setModel("디젤");
		Car car = product2.getKind();
		String carModel = product2.getModel();
		System.out.println(car+" "+carModel);
	}

}
