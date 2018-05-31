package naveenAutomoation_final;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Handling_JavaScript_Alert_and_Popup_5 {
	WebDriver driver;
	@Test(priority = 0)
	public void testJSAlerts() throws Exception
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
		Thread.sleep(5000);
		
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
		
		if(text.equals("Please enter a valid user name"))
		{
			System.out.println("correct error msg");
		}
		else
		{
			System.out.println("Not correct");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority = 1)
		public void testFileUpload1() throws Exception
		{
			//1.Alerts -- JavaScript Pop-Up -->Alert API(accept,dismiss)
			//2.File upload pop-up -- Browse button -->type="File" sendKeys(filepath)
			//3.Browser window pop-up -- Advertisement pop up -->Window handler API -getWindowHandles()
		
			//Upload file through send keys
			//Make sure Type='file' for browse file/attach file/upload file
			driver.get("file:///C:/Users/Harikrishna/Desktop/file%20upload.html");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("html/body/input")).sendKeys("C:\\Users\\Harikrishna\\Desktop\\ImportData.txt");
			Thread.sleep(5000);
			driver.quit();
		}
	
}
