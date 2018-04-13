package testNG_Concepts_For_Selenium_1.testNG;

import org.testng.annotations.Test;

public class EnableAndDisableTest {
	@Test(enabled=true,description="i'm the login Test!")
	public void test()
	{
		System.out.println("test1()");
	}
	@Test(enabled=false,description="i'm the Login Test!")
	public void test1()
	{
		System.out.println("test2()");
	}

}
