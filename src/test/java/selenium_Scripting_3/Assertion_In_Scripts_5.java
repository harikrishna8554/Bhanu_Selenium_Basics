package selenium_Scripting_3;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Assertion_In_Scripts_5 {
	WebDriver d;
	@Test
	public void testCreateLeads() throws Exception
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		d=new ChromeDriver();
		d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		d.manage().window().maximize();
		d.get("http://localhost:8888/");
		
		d.findElement(By.xpath("//input[@name='user_name' and @type='text']")).sendKeys("admin");
		d.findElement(By.xpath("//input[@name='user_password' and @type='password']")).sendKeys("password");
		d.findElement(By.id("submitButton")).click();
		//Leads
		d.findElement(By.linkText("Leads")).click();
		d.findElement(By.linkText("Hanish krishna")).click();
		
		//Assrtions
		String name = d.findElement(By.id("mouseArea_First Name")).getText();
		assertEquals(name,"Mr.   Hanish krishna");
		
		String company = d.findElement(By.id("mouseArea_Company")).getText();
		assertEquals(company.substring(2),"wave9IT");
		
		String salary = d.findElement(By.id("mouseArea_Annual Revenue")).getText();
		assertEquals(salary.substring(2),"100,000");
		
		String mobile = d.findElement(By.id("mouseArea_Mobile")).getText();
		assertEquals(mobile.substring(2),"9291509904");
		
		String email = d.findElement(By.id("mouseArea_Email")).getText();
		assertEquals(email,"krishna@gmail.com");
		
		String descp = d.findElement(By.id("mouseArea_Description")).getText();
		assertEquals(descp.substring(1)," MY LIFE....MY RULES!!");
		
		Thread.sleep(3000);
		d.quit();
		
		
		
		
		
	}

}
