package selenium_Basics_4.custom_Listener_InSelenium_19_customListener;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import selenium_Basics_4.custom_Listener_InSelenium_19_TestCustomListener.TestBase;

public class Listener_In_Selenium extends TestBase implements ITestListener
{
 
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub]
		
		
	}

	public void onTestFailure(ITestResult arg0) {
		
		if(!arg0.isSuccess())
		{
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			String methodName = arg0.getName();
			try {
			File srcFile = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
			String pathDest = new File(System.getProperty("user.dir")).getAbsolutePath()+"\\src\\main\\java\\screenShots";
			File destFile = new File(pathDest+"\\Test_Failure\\"+methodName+"_"+formater.format(cal.getTime())+".png");
			
			Reporter.log("<a href='"+destFile.getAbsolutePath()+"'> <img src='"+destFile.getAbsolutePath()+"' width='100' height='100'/></a>");
		
			FileUtils.copyFile(srcFile, destFile);
			} catch (Exception e) {
				
				System.err.println(e);
			}
			
		}
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		Reporter.log("Test Started:-"+arg0.getName());
		
	}

	public void onTestSuccess(ITestResult arg0) {
		if(arg0.isSuccess())
		{
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			String methodName = arg0.getName();
			try {
			File srcFile = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
			String pathDest = new File(System.getProperty("user.dir")).getAbsolutePath()+"\\src\\main\\java\\screenShots";
			File destFile = new File(pathDest+"\\Test_success\\"+methodName+"_"+formater.format(cal.getTime())+".png");
			
			Reporter.log("<a href='"+destFile.getAbsolutePath()+"'> <img src='"+destFile.getAbsolutePath()+"' width='100' height='100'/></a>");
		
			FileUtils.copyFile(srcFile, destFile);
			} catch (Exception e) {
				
				System.err.println(e);
			}
			
		}
		
		
	}
	
	

}
