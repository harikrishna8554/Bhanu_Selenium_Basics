package selenium_Basics_4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class Page_Scrolling_InSelenium_14 {
	WebDriver d;
	@Test
	public void testPage_Scrolling_InSelenium() throws Exception
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		d=new FirefoxDriver();
		
		d.get("http://automationpractice.com/index.php");
		Thread.sleep(3000);
		
		// To scroll Down completely
		((JavascriptExecutor)d).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(5000);
		
		//To scroll Up completely
		((JavascriptExecutor)d).executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		Thread.sleep(5000);
		
		//To scroll down to given length
		((JavascriptExecutor)d).executeScript("window.scrollBy(0,1500)");
		Thread.sleep(5000);
		
		//To scroll Up to given length
		((JavascriptExecutor)d).executeScript("window.scrollBy(0,-1500)");
		Thread.sleep(5000);
		
		//To scroll to particular Object
		((JavascriptExecutor)d).executeScript("arguments[0].scrollIntoView(true);",d.findElement(By.xpath("//h3[contains(text(),'Come Visit Us')]")));
		System.out.println("scroll into view to 'come visit us!'");
		Thread.sleep(2000);
		d.quit();
		
	}
	
	

}
