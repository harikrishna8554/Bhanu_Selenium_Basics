package selenium_Basics_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Delete_AllEmailsFrom_InboxInSelenium_13 {
	WebDriver d;
	@Test
	public void testDelete_AllEmailsFrom_Inbox() throws Exception
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		d=new FirefoxDriver();
		
		d.get("https://www.sharklasers.com/");
		
		//edit email-id
		d.findElement(By.xpath("//span[@id='inbox-id']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//span[@id='inbox-id']/input")).sendKeys("test");
		d.findElement(By.xpath("//span[@id='inbox-id']/button[1]")).click();
		Thread.sleep(10000);
		//delete all emails
		int rowSize = d.findElements(By.xpath("//table[@id='email_table']/tbody/tr/td[1]/input")).size();
		for(int i=1;i<=rowSize;i++)
		{
			
			String fPart = "//table[@id='email_table']/tbody/tr[";
			String sPart = "]/td[1]/input";
			System.out.println(fPart+i+sPart);
			d.findElement(By.xpath(fPart+i+sPart)).click();
		}
		Thread.sleep(4000);
		d.findElement(By.xpath("//input[@id='del_button']")).click();
		Thread.sleep(2000);
		d.quit();
		
	}

}
