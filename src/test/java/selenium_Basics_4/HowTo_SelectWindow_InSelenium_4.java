package selenium_Basics_4;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class HowTo_SelectWindow_InSelenium_4 {
	WebDriver d;
	@Test
	public void testSelectWindow() throws Exception
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		d.get("https://www.hdfcbank.com/htdocs/common/onlineservices/netbankingloginsafe_nri.htm");
		d.findElement(By.xpath("//div[@class='middle']/ul/li[1]/a")).click();
		
		Set<String> handles = d.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		String parentHandle = itr.next();
		String childHandle = itr.next();
		
		d.switchTo().window(childHandle);
		Thread.sleep(2000);
		d.findElement(By.xpath("//input[@id='netbanking']")).click();
		Thread.sleep(3000);
		d.close();
		d.switchTo().window(parentHandle);
		d.findElement(By.xpath("//div[@class='button']/a/img")).isDisplayed();
		
		d.quit();
		
	}

}
