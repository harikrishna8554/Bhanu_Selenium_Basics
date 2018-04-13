package testNG_Concepts_For_Selenium_1.testNG;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersInTestNG {
	
	@Test
	@Parameters({"userName","password"})
	public void testlogin(@Optional("Optional User Name")String userName,@Optional("Optional Password")String password)
	{
		System.out.println("username is :"+userName+"  password is:"+password);
	}

}
