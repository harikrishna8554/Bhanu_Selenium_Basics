package selenium_Advance_video.Image_Comparison_InSelenium_7;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ImageComparisonInSelenium_7 {

	public WebDriver driver;

	@BeforeClass
	public void setUp() throws Exception {
	
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
	}

	@Test
	public void testImageComparison() throws IOException, InterruptedException {

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Thread.sleep(3000);
		FileUtils.copyFile(screenshot, new File("ImageOutput.jpg"));

		File fileInput = new File("ImageInput.jpg");
		File fileOutPut = new File("ImageOutput.jpg");

		BufferedImage bufferfileInput = ImageIO.read(fileInput);
		DataBuffer bufferfileInput1 = bufferfileInput.getData().getDataBuffer();
		int sizefileInput = bufferfileInput1.getSize();
		System.out.println(sizefileInput);

		BufferedImage bufferfileOutPut = ImageIO.read(fileOutPut);
		DataBuffer bufferfileOutPut1 = bufferfileOutPut.getData().getDataBuffer();
		int sizefileOutPut = bufferfileOutPut1.getSize();
		System.out.println(sizefileOutPut);
		
		Boolean matchFlag = true;
		if (sizefileInput == sizefileOutPut) {
			Assert.assertTrue(matchFlag, "Images are same");
		} else {
			matchFlag = false;
			Assert.assertTrue(matchFlag, "Images are not same");
		}
		
	}
	

	@AfterSuite
	public void tearDown() throws Exception {
		driver.quit();
	}

}
