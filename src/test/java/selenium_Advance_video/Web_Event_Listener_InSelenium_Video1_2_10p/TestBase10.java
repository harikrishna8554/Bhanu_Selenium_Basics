package selenium_Advance_video.Web_Event_Listener_InSelenium_Video1_2_10p;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBase10 {
	
	public WebDriver dr;
	public EventFiringWebDriver driver;
	public WebEventListener eventListener;
	
    @BeforeTest
	public void setUp(){
    System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
    	//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
    	// For Window OS
    	// System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe");
    dr = new FirefoxDriver();
    //	dr = new FirefoxDriver();
    	driver = new EventFiringWebDriver(dr);
    	eventListener = new WebEventListener();  
    	driver.register(eventListener);
    	}

	@Test
	public void testEventListener() throws InterruptedException {
	driver.get("http://automationpractice.com/index.php");
	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
	Thread.sleep(3000);
	WebDriverWait wait = new WebDriverWait(driver, 200);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a"))));
	driver.findElement(By.xpath("//*[@id='email']")).sendKeys("testCode");
	driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys("testpass");
	driver.findElement(By.xpath("//*[@id='SubmitLogin']")).click();
	}

}
