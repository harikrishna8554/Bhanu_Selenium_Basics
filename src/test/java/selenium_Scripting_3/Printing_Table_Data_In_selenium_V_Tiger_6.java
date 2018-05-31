package selenium_Scripting_3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Printing_Table_Data_In_selenium_V_Tiger_6 {
	WebDriver d;
	@Test
	public void testTableData() throws Exception
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		d.get("http://localhost:8888/");
		d.findElement(By.xpath("//input[@name='user_name' and @type='text']")).sendKeys("admin");
		d.findElement(By.xpath("//input[@name='user_password' and @type='password']")).sendKeys("password");
		d.findElement(By.id("submitButton")).click();
		//Leads
		d.findElement(By.linkText("Leads")).click();
		
		int rowCount = d.findElements(By.xpath("//table[@class='lvtBg']/tbody/tr/td/div/table/tbody/tr")).size();
		int colCount = d.findElements(By.xpath("//table[@class='lvtBg']/tbody/tr/td/div/table/tbody/tr[3]/td")).size();
		System.out.println(rowCount+" "+colCount);
		for(int i=3;i<=rowCount;i++)
		{
			for(int j=1;j<colCount+1;j++)
			{
				 String fpart = "//table[@class='lvtBg']/tbody/tr/td/div/table/tbody/tr[";
				 String spart = "]/td[";
				 String tpart = "]";
				 String data = d.findElement(By.xpath(fpart+i+spart+j+tpart)).getText();
				 System.out.print(data);
				 System.out.print(" | ");
			}
			System.out.println();
		}
		Thread.sleep(3000);
		d.quit();
	}

}
