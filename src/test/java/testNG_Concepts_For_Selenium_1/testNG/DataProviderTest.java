package testNG_Concepts_For_Selenium_1.testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@DataProvider(name="data")
	public Object[][] test()
	{
		Object[][] obj=new Object[2][2];
		obj[0][0]="user1";
		obj[0][1]="password1";
		
		obj[1][0]="user2";
		obj[1][1]="password2";
		
		return obj;
		
	}
	@Test(dataProvider="data")
	public void testDataProvider(String a,String b)
	{
		System.out.println("username:"+a+"  password:"+b);
	}

}
