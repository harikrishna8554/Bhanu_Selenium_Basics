package selenium_Basics_4;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Verify_DisableObject_InSelenium_10 {
	WebDriver d;
	@Test
	public void testDisableObject()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		d.get("https://www.olx.in/bangalore/cars/q-swift/");
		
		String className = d.findElement(By.xpath("//li [@id='param_model']")).getAttribute("class");
		System.out.println(className);
		
		assertEquals(className, "param paramSelect disabled");
		
		d.quit();
	}

}
