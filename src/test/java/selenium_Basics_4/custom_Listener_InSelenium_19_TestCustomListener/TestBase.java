package selenium_Basics_4.custom_Listener_InSelenium_19_TestCustomListener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

public class TestBase {
	
	public static WebDriver d;
	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		d=new FirefoxDriver();
		
	}

}
