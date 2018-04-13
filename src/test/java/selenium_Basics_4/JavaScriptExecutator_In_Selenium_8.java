package selenium_Basics_4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JavaScriptExecutator_In_Selenium_8 {
	WebDriver d;
	@BeforeClass
	public void setUp()
	{
		if(System.getProperty("os.name").contains("Windows 10"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		}
		else if(System.getProperty("os.name").contains("mac os"))
		{
			System.setProperty("webdriver.firefox.marionette",System.getProperty("user.dir")+"\\drivers\\geckodriver");
		}
		d=new FirefoxDriver();	
	}
	@Test
	public void testJavaScriptExecutator() throws Exception
	{
		d.get("https://www.facebook.com/");
		JavascriptExecutor js = (JavascriptExecutor)d;
		//Through Xpath and pure javaScript
		js.executeScript("arguments[0].value=\"selenium\"", d.findElement(By.id("email")));
		js.executeScript("document.getElementById('u_0_l').value=\"hari krishna\"");
		js.executeScript("arguments[0].click()",d.findElement(By.id("loginbutton")));
		js.executeScript("document.getElementsByName(\"reg_passwd__\")[0].value=\"krishna@gmail.com\"");
		//Select Box
		js.executeScript("document.getElementById('day').value=\"12\"");
		Thread.sleep(3000);
		//js.executeScript("document.getElementsByName(\"birthday_day\")[0].value=\"5\"");
		
		
		
		Thread.sleep(3000);
		d.quit();
	}

}
