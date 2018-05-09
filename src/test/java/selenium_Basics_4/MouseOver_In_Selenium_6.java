package selenium_Basics_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseOver_In_Selenium_6 {
	WebDriver d;
	@Test
	public void testMouseOver_In_Selenium() throws Exception
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		d=new FirefoxDriver();
		
		d.get("https://www.flipkart.com/");
		WebElement babykids = d.findElement(By.xpath("//*[@id='container']/div/header/div[3]/div/ul/li[5]/a"));
		Thread.sleep(3000);
		//un-wanted pop-up
		d.findElement(By.xpath("//div[@class='mCRfo9']/div/div/button")).click();
		Actions act=new Actions(d);
		act.moveToElement(babykids).build().perform();
		Thread.sleep(5000);
		d.quit();
	}

}
