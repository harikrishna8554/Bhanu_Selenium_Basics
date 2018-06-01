package selenium_Basics_4.custom_Listener_InSelenium_19_TestCustomListener;

import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;


public class Login extends TestBase { 
	
	@Test
	public void testLogin()
	{
		d.get("https://www.facebook.com/");
		//username and password
		d.findElement(By.id("email")).clear();
		d.findElement(By.id("email")).sendKeys("hari251993@gmail.com");
		
		d.findElement(By.id("pass")).clear();
		d.findElement(By.id("pass")).sendKeys("harikrishna");
		
		d.findElement(By.id("loginbutton")).click();	
	}
	@AfterSuite
	public void tearDown()
	{
		d.quit();
	}

}
