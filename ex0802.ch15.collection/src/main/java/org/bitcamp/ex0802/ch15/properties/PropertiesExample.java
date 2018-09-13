package org.bitcamp.ex0802.ch15.properties;

import java.io.FileReader;
import java.net.URLDecoder;
import java.util.Properties;

public class PropertiesExample {

	public static void main(String...args) throws Exception{
		// Properties instantiation using default constructor
		Properties properties = new Properties();
		
		// Searching for XXX.properties when loading from the instance
		// the classpath is in the same folder as the source file
		String path = PropertiesExample.class.getResource("database.properties").getPath();

		// decoding to utf-8
		path = URLDecoder.decode(path, "utf-8");

		
		properties.load(new FileReader(path));

		
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");

		System.out.println("driver: "+ driver);
		System.out.println("url: "+url);
		System.out.println("username: "+ username);
		System.out.println("password: "+password);
			
	}
 } // end class
