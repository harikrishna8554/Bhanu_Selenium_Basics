package naveenAutomoation_final;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoIT_FileUpload_MukeshOtwani_1 {
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		//http://learn-automation.com/upload-file-in-selenium-webdriver-using-autoit/
	}
	
	@Test
	public void fileUpload() throws Exception
	{
		driver.get("file:///C:/Users/Harikrishna/Desktop/file%20upload.html");
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/input")).click();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\Harikrishna\\Desktop\\AutoIT\\file upload.exe");
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void tearDown()
	{
		
		driver.quit();
	}

}
