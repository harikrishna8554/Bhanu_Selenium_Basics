package selenium_Basics_4;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Verify_CollapsedAndExpanded_ObjectInSelenium_5 {
	WebDriver d;
	@Test
	public void testCollapsedAndExpanded() throws Exception
	{
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		d.get("https://www.hdfcbank.com/htdocs/nri_banking/payments/BillPay/BillPay.htm");
		String bg_status = d.findElement(By.xpath("//h3[contains(text(),'Electricity and Telephone Bills')]")).getCssValue("background-image");
		System.out.println(bg_status);
		if(bg_status.contains("bg_collapsed_panel"))
		{
			assertTrue(true, bg_status);
		}else
		{
			assertTrue(false, bg_status);
		}
		d.findElement(By.xpath("//h3[contains(text(),'Electricity and Telephone Bills')]")).click();
		Thread.sleep(5000);
		bg_status = d.findElement(By.xpath("//h3[contains(text(),'Electricity and Telephone Bills')]")).getCssValue("background-image");
		System.out.println(bg_status);
		if(bg_status.contains("bg_expanded_panel"))
		{
			assertTrue(true, bg_status);
		}else
		{
			assertTrue(false, bg_status);
		}
		
		Thread.sleep(5000);
		d.quit();

		
		}
}
