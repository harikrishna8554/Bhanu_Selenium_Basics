package selenium_Basics_4;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Count_NumberOf_LinksIn_SeleniumIn_GivenPage_3 {
	WebDriver d;
	@Test
	public void testCount_NumberOf_Links()
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		d=new FirefoxDriver();
		d.get("https://www.facebook.com/");
		
		List<WebElement> links = d.findElements(By.xpath("//a"));
		System.out.println(links.size());
		assertEquals(links.size(),58);
		d.quit();
		
	}

}
