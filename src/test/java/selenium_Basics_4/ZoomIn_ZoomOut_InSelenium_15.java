package selenium_Basics_4;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ZoomIn_ZoomOut_InSelenium_15 {
	
	WebDriver d;
	@Test
	public void testZoomIn_ZoomOut() throws Exception
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		d=new ChromeDriver();
		
		d.get("http://automationpractice.com/index.php");
		Thread.sleep(3000);
	
		//Zoom out by 30%
		((JavascriptExecutor)d).executeScript("document.body.style.zoom='30%'");
		
		Thread.sleep(4000);
		
		//Back to normal
		((JavascriptExecutor)d).executeScript("document.body.style.zoom='100%'");
		Thread.sleep(2000);
		d.quit();
		
	}

}
