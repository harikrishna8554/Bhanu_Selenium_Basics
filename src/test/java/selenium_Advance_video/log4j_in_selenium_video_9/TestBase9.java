package selenium_Advance_video.log4j_in_selenium_video_9;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeTest;

public class TestBase9 {
	
	private static final Logger log = Logger.getLogger(TestBase9.class.getName());
	
	@BeforeTest
	public void setLog4j()
	{
	
		
		String log4jProperties = System.getProperty("user.dir")+"\\src\\test\\java\\selenium_Advance_video\\log4j_in_selenium_video_9\\Log4J.properties";
		PropertyConfigurator.configure(log4jProperties);
		
	}

}
