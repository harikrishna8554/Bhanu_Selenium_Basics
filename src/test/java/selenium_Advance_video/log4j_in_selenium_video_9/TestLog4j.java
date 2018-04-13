package selenium_Advance_video.log4j_in_selenium_video_9;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class TestLog4j extends TestBase9 {
	private static final Logger log = Logger.getLogger(TestLog4j.class.getName());
	@Test
	public void testScriptLog()
	{
		
		log.info("Test stated...");
		log.info("Login");
		log.info("username entered");
		log.info("password entered");
		log.info("clicked on submit button.....");
	}

}
