package selenium_Basics_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class How_To_Verify_Common_Text_In_Selenium_2 {
	
	WebDriver d;
	@Test
	public void testVerify_Common_Text()
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		d=new FirefoxDriver();
		d.get("https://www.hdfcbank.com/htdocs/nri_banking/payments/BillPay/BillPay.htm");
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		ArrayList<String> expectedData=new ArrayList<String>();
		expectedData.add("Features & Benefits");
		expectedData.add("Mobile Phone Bills");
		expectedData.add("Electricity and Telephone Bills");
		expectedData.add("Insurance Premium");
		expectedData.add("How to register for BillPay");
		expectedData.add("FAQs");
		
		List<WebElement> ele = d.findElements(By.xpath("//div[@id='nre_savings_acc']/ul/li"));
		ArrayList<String> actualData = new ArrayList<String>();
		Iterator<WebElement> itr = ele.iterator();
		while(itr.hasNext())
		{
			actualData.add(itr.next().getText());
		}
		
		Assert.assertEquals(actualData,expectedData);
		System.out.println(actualData);
		System.out.println(expectedData);
		d.quit();
		
		
		
		
	}

}
