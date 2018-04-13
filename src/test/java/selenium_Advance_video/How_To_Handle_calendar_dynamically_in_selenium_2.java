package selenium_Advance_video;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class How_To_Handle_calendar_dynamically_in_selenium_2 {
	WebDriver d;
	String month;
	String day;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		d=new FirefoxDriver();
		//d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		
	}
	
	@Test
	public void testHandle_calendar_dynamically() throws Exception
	{
		String datte = "07/27/2018";
		Date dt=new Date(datte);
		SimpleDateFormat formate = new SimpleDateFormat("MMMM/dd/yyyy");
		String date = formate.format(dt);
		System.out.println(date);
		
		if(date.contains("/"))	
		{
			String[] split = date.split("/");
			System.out.println("split:---"+split[0]+split[1]+split[2]);
			 month = split[0]+" "+split[2];
		
		}
		
		SimpleDateFormat formater = new SimpleDateFormat("LL/dd/yyyy");
		String date1 = formater.format(dt);
		System.out.println(date1);
		
		if(date1.contains("/"))
		{
			String[] split1 = date1.split("/");
			System.out.println("split1-"+split1[0]+split1[1]+split1[2]);
			day = split1[2]+split1[0]+split1[1];
		}
		
		d.get("https://www.goibibo.com/");
		Thread.sleep(4000);
		d.findElement(By.xpath(".//*[@id='searchWidgetCommon']/div/div[3]/div[1]/div[1]/div/i")).click();
		Thread.sleep(3000);
		while(true)
		{
			try {
				
				d.findElement(By.xpath("//div[contains(text(),'"+month+"')]")).isDisplayed();
				//20180625
				String p1 = "//div[@id='fare_";
				String p2 = "']";
				d.findElement(By.xpath(p1+day+p2)).click();
				break;
				
			}
			catch(Exception e)
			{
				
				d.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next' and @role='button']")).click();
				
				
			}
			
		}
		Thread.sleep(5000);
		
		
	}
	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}

}
