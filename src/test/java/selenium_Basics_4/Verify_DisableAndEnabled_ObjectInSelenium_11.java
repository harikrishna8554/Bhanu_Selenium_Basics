package selenium_Basics_4;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Verify_DisableAndEnabled_ObjectInSelenium_11 {
	WebDriver d;
	@Test
	public void testDisableAndEnabled() throws Exception
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		d.get("https://www.olx.in/bangalore/cars/q-swift/");
		
		String className = d.findElement(By.xpath("//li[@id='param_model']")).getAttribute("class");
		System.out.println(className);
		assertEquals(className, "param paramSelect disabled");		
		
		//brand Name
		d.findElement(By.xpath("//*[@id='param_subcat']/div[2]/a/span[1]")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath(".//*[@id='param_subcat']/div[2]/ul/li[2]/a")).click();
		Thread.sleep(2000);
		//verify class attribute value to find disable or enabled
		 className = d.findElement(By.xpath("//li[@id='param_model']")).getAttribute("class");
		System.out.println(className);
		assertNotEquals(className, "param paramSelect disabled");	
		
		d.quit();
	}

}
