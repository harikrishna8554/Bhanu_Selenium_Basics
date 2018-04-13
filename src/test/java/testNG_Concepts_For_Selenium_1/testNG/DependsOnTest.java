package testNG_Concepts_For_Selenium_1.testNG;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class DependsOnTest {

	@Test
	public void login()
	{
		System.out.println("login");
	}
	@Test(dependsOnMethods={"login","logout"})
	public void test2()
	{
		System.out.println("test2");
	}
	@Test(dependsOnMethods="login")
	public void logout()
	{
		System.out.println("logout");
		assertTrue(false);
	}

}
