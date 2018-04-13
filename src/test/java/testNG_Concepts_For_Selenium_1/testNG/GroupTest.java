package testNG_Concepts_For_Selenium_1.testNG;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GroupTest {
	
	@BeforeClass(groups= {"regression","sanity","database"})
	public void setUp()
	{
		System.out.println("setUp");
	}
	@Test(groups= {"regression","sanity"})
	public void test1()
	{
		System.out.println("(groups= {regression,sanity})");
	}
	@Test(groups= {"sanity","database"})
	public void test2()
	{
		System.out.println("(groups= {sanity,database})");
	}
	@Test(groups="regression")
	public void test3()
	{
		System.out.println("(groups=regression)");
	}
	@Test(groups="database")
	public void test4()
	{
		System.out.println("(groups=database)");
	}

}
