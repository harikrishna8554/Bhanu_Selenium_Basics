package selenium_Scripting_3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;



public class Select_Box_In_Selenium_2 {
	
	WebDriver d;
	@Test
	public void testCreateLeads() throws Exception
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		d.get("http://localhost:8888/");
		d.findElement(By.xpath("//input[@name='user_name' and @type='text']")).sendKeys("admin");
		d.findElement(By.xpath("//input[@name='user_password' and @type='password']")).sendKeys("password");
		d.findElement(By.id("submitButton")).click();
		//Leads
		d.findElement(By.linkText("Leads")).click();
		d.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		Select sel = new Select(d.findElement(By.xpath("//select[@name='salutationtype']")));
		sel.selectByIndex(1);
		d.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Hanish krishna");
		
		Thread.sleep(3000);
		d.quit();
		
		
		
		
	}
}
