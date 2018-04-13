package testNG_Concepts_For_Selenium_1.testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {
	
	@DataProvider(name="data")
	public Object[][] login() {
		
		Object obj[][]=new Object[5][2];
		obj[0][0]="Manager1";
		obj[0][1]="Admin1";
		
		obj[1][0]="Manager2";
		obj[1][1]="Admin2";
		
		obj[2][0]="Manager3";
		obj[2][1]="Admin3";
		
		obj[3][0]="Manager4";
		obj[3][1]="Admin4";
		
		obj[4][0]="Manager5";
		obj[4][1]="Admin5";
		
		return obj;
	}
	
	@Test(dataProvider="data")
	public void testLogin(String name,String password)
	{
		System.out.println("userName:"+name+"    password:"+password);
	}

}
