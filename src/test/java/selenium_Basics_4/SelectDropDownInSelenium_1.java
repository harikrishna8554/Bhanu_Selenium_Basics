package selenium_Basics_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectDropDownInSelenium_1 {
	WebDriver d;
	@Test
	public void testSelectDropDown() throws Exception
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		d=new FirefoxDriver();
	
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
