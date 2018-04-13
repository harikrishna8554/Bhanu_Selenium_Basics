package selenium_Advance_video.how_to_use_propertieFiles_In_Selenium_1.testProperties;

import org.testng.annotations.Test;

public class TestScript1 extends TestBase{
	
	@Test
	public void testProperties() throws Exception
	{
		System.out.println(getObject("url"));
		System.out.println(getObject("pin"));
		System.out.println(getObject("userName"));
		System.out.println(getObject("passCode"));
		
	}

}
