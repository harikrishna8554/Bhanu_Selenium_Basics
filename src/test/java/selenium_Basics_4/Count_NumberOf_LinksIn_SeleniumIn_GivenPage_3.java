package selenium_Basics_4;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Count_NumberOf_LinksIn_SeleniumIn_GivenPage_3 {
	WebDriver d;
	@Test
	public void testCount_NumberOf_Links()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		d=new ChromeDriver();
		
		d.manage().window().maximize();
		d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 
		d.get("https://www.facebook.com/");
		
		List<WebElement> links = d.findElements(By.xpath("//a"));
		System.out.println(links.size());
		assertEquals(links.size(),54);
		d.quit();
		
	}

}
