/*
	json: array([]), object({})
		- object: java에서 vo처럼 변환 
		- pair of name and value 
		- name must be double-quoted
		
		EX1) 
		 {
		 	name: "Won Choi" (x)
		 	"name": "Won Choi", (O)
		 	"age": 11, (O)
		 }
		 
		 class Member {
		 	String name;
		 	int age;
		 }
		 
		EX2)
		 [
		 	"aaa",
		 	"bbb",
		 ]
		 
		 List<String> 
		 
		 EX3)
		 {
		 	"name": "hara",
		 	"hobbies": ["shopping","직방","diet"]
		 }
		 
		 class Celeb{
		 	private String name;
		 	private List<String> hobbies;
		 }

		 EX4)
		 {
		 	"name": "hara",
		 	"addr": {"basic": "서울", "detail": "강남구"}.
		 	"hobbies": ["shopping","직방","diet"]
		 }
		 
		 class Address{
		 	String basic;
		 	String detail;
		 }
		 
		 class Celeb{
		 	private String name;
		 	private Address addr;
		 	private List<String> hobbies;
		 }
		 
		EX5)
		{
			"name": "hara",
			"addr": {"basic": "서울", "detail": "강남구"}.
			"hobbies": ["shopping","직방","diet"]
			"items": [{"name":"시계","price":"100만원"},{"name":"차", "price":"5000만원"},
		}
		
		 class Address{
		 	String basic;
		 	String detail;
		 }
		 
		 class Item{
		 	String name;
		 	String price;
		 	
		 }
		 
		 class Celeb{
		 	private String name;
		 	private Address addr;
		 	private List<String> hobbies;
		 	private List<Item> items;
		 }
		 
		 
*/
package json;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Test01 {
	
	private static void test01() {
		Member m = new Member();
		m.setName("won");
		m.setAge(11);
		/*
		String xml = "<member>"+
				     " <name>"+m.getName()+"</name>" +
				     " <age>"+m.getAge()+"</age>" +
				     "</member>";
		*/
		
		// 직접은 고생많이 하고 google님이 해결해줌 
		String json = "{\"name\":\""+m.getName()+"\",\"age\":"+m.getAge()+"}";
		System.out.println(json);
	}
	
	// gson 활용하기: 객체의 내용을 JSON 문자열로 변환하기 
	private static void test02() {
		Member m = new Member();
		m.setName("won");
		m.setAge(11);
		
		Address addr = new Address();
		addr.setBasic("seoul");
		addr.setDetail("gangnam-gu");
		m.setAddr(addr);
		
		List<String> hobbies = new ArrayList<>();
		hobbies.add("pingpong");
		hobbies.add("baseball");
		hobbies.add("drone");
		m.setHobbies(hobbies);
		
		List<Item> items = new ArrayList<>();
		Item i1 = new Item();
		i1.setName("차");
		i1.setPrice("100만원");
		items.add(i1);
		Item i2 = new Item();
		i2.setName("차");
		i2.setPrice("50000만원");
		items.add(i2);
		m.setItems(items);

//		List<Item> items = new ArrayList<>();
//		items.add
//		
//		Gson gson = new Gson();
//		String data = gson.toJson(m);
//		System.out.println(data);
		 
		System.out.println(new Gson().toJson(m));
			
	}
	
	//gson 활용: json 문자열의 내용을 객체로 변환 
	private static void test03() {
		String data = "{\"name\":\"won\",\"age\":11,\"addr\":{\"basic\":\"seoul\",\"detail\":\"gangnam-gu\"},\"hobbies\":[\"pingpong\",\"baseball\",\"drone\"],\"items\":[{\"name\":\"차\",\"price\":\"100만원\"},{\"name\":\"차\",\"price\":\"50000만원\"}]}\n";
		
		Gson gson = new Gson();
		Member m = gson.fromJson(data, Member.class);
		System.out.println(m.getName());
		System.out.println(m.getAge());
		System.out.println(m.getHobbies());
		
		
	}
	
	public static void main(String[] args) {
		//JSON 관련 처리: API 활용....() 
//		test01();
//		test02();
		test03();
	}
} // end class
