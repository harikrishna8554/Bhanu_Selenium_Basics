package selenium_Basics_4.properties_file_in_selenium_18.propertyFiles;

import org.testng.annotations.Test;

public class Login extends TestBase {
	
	@Test
	public void testLogin()
	{ 
		System.out.println(OR.getProperty("browser")+"----login");
		System.out.println(OR.getProperty("url"));
		System.out.println(OR.getProperty("userName"));
		System.out.println(OR.getProperty("password"));
		System.out.println(OR.getProperty("email"));
		System.out.println(OR.getProperty("password1"));
		System.out.println(OR.getProperty("signin")+"----login");
		System.out.println(OR.get("browser"));
		
	}

}
