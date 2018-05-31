package selenium_Scripting_3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login_Script_In_Selenium_1 {
	
	WebDriver d;
	@Test
	public void loginScript() throws Exception
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		d=new ChromeDriver();
		d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		d.get("http://localhost:8888/");
		d.findElement(By.xpath("//input[@name='user_name' and @type='text']")).sendKeys("admin");
		d.findElement(By.xpath("//input[@name='user_password' and @type='password']")).sendKeys("password");
		d.findElement(By.id("submitButton")).click();
		
		Thread.sleep(3000);
		d.quit();
	}

}
