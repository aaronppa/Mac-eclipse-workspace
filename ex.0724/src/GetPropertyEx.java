import java.util.Properties;
import java.util.Set;

public class GetPropertyEx {

	public static void main(String[] args) {
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("user.home");
		
		System.out.println("OS Name: "+osName);
		System.out.println("User Name: "+userName);
		System.out.println("User Home Directory: "+userHome);
	
		System.out.println("-------------------------");
		System.out.println(" [key] value ");
		System.out.println("-------------------------");
		
		Properties props = System.getProperties();
		Set keys = props.keySet();
		for(Object objKey : keys) {
			String key = (String) objKey;
			String value = System.getProperty(key);
			System.out.println("[ "+key+"] "+value);
		}
	}
} // end class
