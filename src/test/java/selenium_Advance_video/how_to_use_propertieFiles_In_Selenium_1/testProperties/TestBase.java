package selenium_Advance_video.how_to_use_propertieFiles_In_Selenium_1.testProperties;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	public static Properties properties;
	public static void loadData() throws IOException
	{
		properties=new Properties();
		
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\java\\selenium_Advance_video\\how_to_use_propertieFiles_In_Selenium_1\\properties\\config.properties");
		FileReader reader=new FileReader(file);
		properties.load(reader);
		
		 file = new File(System.getProperty("user.dir")+"\\src\\test\\java\\selenium_Advance_video\\how_to_use_propertieFiles_In_Selenium_1\\properties\\or.properties");
		 reader=new FileReader(file);
		properties.load(reader);
		
	}
	public String getObject(String Data) throws Exception
	{
		loadData();
		String data = properties.getProperty(Data);
		
		return data;
		
		
	}

}
