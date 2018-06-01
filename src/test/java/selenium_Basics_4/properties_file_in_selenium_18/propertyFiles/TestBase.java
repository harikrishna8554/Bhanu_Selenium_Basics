package selenium_Basics_4.properties_file_in_selenium_18.propertyFiles;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.testng.annotations.BeforeClass;

public class TestBase {
	
	public Properties OR;
	private File file;
	private FileReader fileReader;
	
	public void loadProperties() throws Exception
	{
		 OR = new Properties();
		 file = new File(System.getProperty("user.dir")+"\\src\\test\\java\\selenium_Basics_4\\properties_file_in_selenium_18\\config\\config.properties");
		 fileReader = new FileReader(file);
		 OR.load(fileReader); 
		 
		 file = new File(System.getProperty("user.dir")+"\\src\\test\\java\\selenium_Basics_4\\properties_file_in_selenium_18\\config\\or.properties");
		 fileReader = new FileReader(file);
		 OR.load(fileReader);
	}
	
	@BeforeClass
	public void setUp() throws Exception
	{
		loadProperties();
	}

}
