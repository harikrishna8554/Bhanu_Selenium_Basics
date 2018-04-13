package testNG_Concepts_For_Selenium_1.testNG;



import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("beforeClass()");
	}
	@Test
	public void test1()
	{
		System.out.println("test1()");
	}
	@Test
	public void test2()
	{
		System.out.println("test2()");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("beforeMethod()");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("afterMethod()");
	}
	@BeforeSuite
	public void beforesuite()
	{
		System.out.println("beforesuite()");
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("afterSuite()");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("afterClass()");
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("beforeTest()");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("afterTest()");
	}
	
	
	
}
