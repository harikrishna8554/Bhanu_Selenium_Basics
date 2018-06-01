package selenium_Basics_4;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class How_To_Verify_Filter_Test_In_Selenium_9 {
	WebDriver d;
	@Test
	public void testVerify_Filter() throws Exception
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		d=new ChromeDriver(); 
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		d.get("https://www.olx.in/bangalore");
		d.findElement(By.id("cityField")).click();
		d.findElement(By.id("filterCities")).sendKeys("Bengaluru");
		Thread.sleep(2000);
		d.findElement(By.id("choosecat")).click();
		d.findElement(By.xpath(".//*[@id='a-category-5']")).click();
		d.findElement(By.xpath("//input[@id='search-text']")).clear();
		d.findElement(By.xpath("//input[@id='search-text']")).sendKeys("swift");
		Thread.sleep(3000);
		d.findElement(By.xpath("//div[@id='autosuggest-div']/ul/li[1]/a")).click();
		Thread.sleep(3000);
		
		
		
		List<WebElement> allData = d.findElements(By.xpath("//table[@id='offers_table']/tbody/tr/td/table/tbody/tr/td/h3/a/span"));
		Iterator<WebElement> itr = allData.iterator();
		while(itr.hasNext())
		{
			String data = itr.next().getText();
			
			if(data.toLowerCase().contains("swift"))
			{
				System.out.println("offered cars :"+data);
			}
			else if(!data.toLowerCase().contains("swift"))
			{
				System.out.println("UN-wanted : "+data);
			}
		
			
		}
		
		 allData = d.findElements(By.xpath("//table[@id='promotedAd']/tbody/tr/td/table/tbody/tr/td/h3/a/span"));
		itr = allData.iterator();
		while(itr.hasNext())
		{
			String data = itr.next().getText();
			if(data.toLowerCase().contains("swift"))
			{
				System.out.println("promoted cars :"+data);
			}
			else if(!data.toLowerCase().contains("swift"))
			{
				System.out.println("UN-wanted : "+data);
			}
			
		}
		Thread.sleep(3000);
		d.quit();
	
	}

}
