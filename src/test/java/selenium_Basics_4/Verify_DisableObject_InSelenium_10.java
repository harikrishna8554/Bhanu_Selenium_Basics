package selenium_Basics_4;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Verify_DisableObject_InSelenium_10 {
	WebDriver d;
	@Test
	public void testDisableObject()
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		d=new FirefoxDriver();
		
		d.get("https://www.olx.in/bangalore/cars/q-swift/");
		
		String className = d.findElement(By.xpath("//li [@id='param_model']")).getAttribute("class");
		System.out.println(className);
		
		assertEquals(className, "param paramSelect disabled");
		
		d.quit();
	}

}
