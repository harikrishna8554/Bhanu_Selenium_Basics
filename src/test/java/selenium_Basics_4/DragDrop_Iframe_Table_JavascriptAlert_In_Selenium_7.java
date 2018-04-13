package selenium_Basics_4;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragDrop_Iframe_Table_JavascriptAlert_In_Selenium_7 {
	WebDriver d;
	@Test(priority=0)
	public void testIframe() throws Exception
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		d=new FirefoxDriver();
		
		d.get("file:///C:/Users/Harikrishna/Desktop/BhanuPratap/iframe.htm");
		//you can locate the frame in 3ways--> frameName,frameIndex,frame Xpath.
		//Frame -Name
		//d.switchTo().frame("test");
		
		//Frame -Index
		//d.switchTo().frame(3);
		
		//Frame -Xpath
		d.switchTo().frame(d.findElement(By.xpath("//iframe[@name='test']")));
		d.findElement(By.xpath("//a[contains(text(),'Sign in') and @class='login']")).click();
		Thread.sleep(4000);
		System.out.println("working");
		d.quit();
	}
	@Test(priority=1)
	public void testDroppable() throws Exception
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		d=new FirefoxDriver();
		
		d.get("http://jqueryui.com/droppable/");
		d.switchTo().frame(d.findElement(By.xpath("//iframe[@class='demo-frame']")));
		WebElement drag = d.findElement(By.id("draggable"));
		WebElement drop = d.findElement(By.id("droppable"));
		
		Actions act=new Actions(d);
		act.dragAndDrop(drag, drop).perform();
		Thread.sleep(4000);
		d.quit();
	}
	@Test(priority=2)
	public void testAlerts() throws Exception
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		d=new FirefoxDriver();
		d.get("file:///C:/Users/Harikrishna/Desktop/BhanuPratap/alert.htm");
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		d.findElement(By.xpath("html/body/button")).click();
		Thread.sleep(3000);
		String okAlert = d.switchTo().alert().getText();
		System.out.println(okAlert);
		assertEquals(okAlert,"I am an alert box!");
		d.switchTo().alert().accept();
		Thread.sleep(4000);
		
		d.get("file:///C:/Users/Harikrishna/Desktop/BhanuPratap/alert1.htm");
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		d.findElement(By.xpath("html/body/button")).click();
		String okCancell = d.switchTo().alert().getText();
		assertEquals(okCancell,"Press a button!");
		System.out.println(okCancell);
		Thread.sleep(4000);
		d.switchTo().alert().dismiss();
		Thread.sleep(4000);
		d.quit();
	}
	@Test(priority=3)
	public void testTable()
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		d=new FirefoxDriver();
		d.get("file:///C:/Users/Harikrishna/Desktop/BhanuPratap/Table.htm");
		
		 int rows = d.findElements(By.xpath("html/body/table/tbody/tr")).size();
		 for(int i=2;i<=rows;i++)
		 {
			 String fPart = "html/body/table/tbody/tr[";
			 String sPart = "]/td[2]";
			 String text = d.findElement(By.xpath(fPart+i+sPart)).getText();
			 System.out.println(text);
		 }
		 d.quit();
	}

}





















