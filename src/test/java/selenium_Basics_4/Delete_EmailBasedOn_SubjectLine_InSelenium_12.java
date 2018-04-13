package selenium_Basics_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Delete_EmailBasedOn_SubjectLine_InSelenium_12 {
	WebDriver d;
	@Test
	public void testDelete_EmailBasedOn_SubjectLine() throws Exception
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		d=new FirefoxDriver();
		
		d.get("https://www.sharklasers.com/");
		
		//set mail-id
		d.findElement(By.xpath("//span[@id='inbox-id']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//span[@id='inbox-id']/input")).sendKeys("test");
		d.findElement(By.xpath("//span[@id='inbox-id']/button[1]")).click();
		Thread.sleep(10000);
		
		d.findElement(By.xpath("//td[contains(text(),'hari251993@gmail.com')]/preceding-sibling::td[1]/input")).click();
		Thread.sleep(4000);
		//delete
		d.findElement(By.xpath("//input[@id='del_button']")).click();
		Thread.sleep(1000);
		d.quit();
		
		
	}

}
