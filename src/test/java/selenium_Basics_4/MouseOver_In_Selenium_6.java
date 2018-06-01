package selenium_Basics_4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseOver_In_Selenium_6 {
	WebDriver d;
	@Test
	public void testMouseOver_In_Selenium() throws Exception
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().pageLoadTimeout(160, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		d.get("https://www.flipkart.com/");
		WebElement babykids = d.findElement(By.xpath("//*[@id='container']/div/header/div[3]/div/ul/li[5]/a"));
		Thread.sleep(3000);
		//un-wanted pop-up
		boolean status = d.findElement(By.xpath("//div[@class='mCRfo9']/div/div/button")).isDisplayed();
		if(status == true)
		{
			d.findElement(By.xpath("//div[@class='mCRfo9']/div/div/button")).click();
		}
		Actions act=new Actions(d);
		act.moveToElement(babykids).build().perform();
		Thread.sleep(5000);
		d.quit();
	}

}
