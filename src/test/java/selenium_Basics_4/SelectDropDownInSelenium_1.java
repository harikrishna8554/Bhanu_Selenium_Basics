package selenium_Basics_4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectDropDownInSelenium_1 {
	WebDriver d;
	@Test
	public void testSelectDropDown() throws Exception
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
		//URL
		d.get("https://www.facebook.com/");
		
		Select select = new Select(d.findElement(By.xpath("//select[@aria-label='Day' and @name='birthday_day']")));
		select.selectByVisibleText("25");
		
		select = new Select(d.findElement(By.id("month")));
		select.selectByIndex(2);
		
		
		
		select=new Select(d.findElement(By.cssSelector("select[aria-label='Year'][name='birthday_year']")));
		select.selectByVisibleText("1992");
		
		Thread.sleep(2000);
		d.quit();
		
		
		
	}
}
