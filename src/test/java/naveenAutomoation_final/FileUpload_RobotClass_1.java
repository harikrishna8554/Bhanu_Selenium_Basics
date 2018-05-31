=package naveenAutomoation_final;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUpload_RobotClass_1 {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}
	@Test
	public void testFileUpload() throws AWTException
	{
		driver.get("file:///C:/Users/Harikrishna/Desktop/file%20upload.html");
		driver.findElement(By.xpath("html/body/input")).click();
		
		Robot robot = new Robot();
		robot.setAutoDelay(1000);
		
		//copying to clipboard
		StringSelection stringSelection = new StringSelection("C:\\Users\\Harikrishna\\Desktop\\Props.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
		robot.setAutoDelay(1000);
		//ctrl + v
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		//Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.setAutoDelay(2000);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	

}
