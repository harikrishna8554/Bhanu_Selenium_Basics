package naveenAutomoation_final;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FIleDownload_RobotClass_2 {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}
	@Test
	public void testFIleDownload() throws AWTException
	{
		driver.get("https://www.eclipse.org/downloads/download.php?file=/oomph/epp/oxygen/R2/eclipse-inst-win64.exe");
		
		Robot robot = new Robot();
		robot.setAutoDelay(2000);
		
		
		driver.findElement(By.xpath(".//*[@id='novaContent']/div[1]/div[1]/div/div/a")).click();
		robot.setAutoDelay(2000);
		
		//Press tab to click save
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
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
