package selenium_Advance_video;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class How_To_Handel_Dynamic_Table_In_Selenium_Video_1_2___3p {
	WebDriver d;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		d=new FirefoxDriver();
		d.manage().timeouts().pageLoadTimeout(120,TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		d.manage().deleteAllCookies();
		
	}
	@Test
	public void testHandel_Dynamic_Table_In_Selenium() throws Exception
	{
		
		d.get("http://localhost/user/submit_tt.do");
		
		String Scheduled = "04/27/2018";
		Date dt=new Date(Scheduled);
		SimpleDateFormat formater = new SimpleDateFormat("MMM/dd/YYYY");
		String date = formater.format(dt);
		System.out.println(date);
		String[] split = date.split("/");
		String month = split[0];
		String day = split[1];
		String year = split[2];
		System.out.println(month);
		System.out.println(day);
		System.out.println(year);
				
		
		
		
		//Login
		d.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		d.findElement(By.xpath("//table[@id='loginFormContainer']/tbody/tr[1]/td/table/tbody/tr[2]/td/input")).sendKeys("manager");
		d.findElement(By.xpath("//a[@id='loginButton']/div")).click();
		Thread.sleep(3000);
		
		//new
		d.findElement(By.xpath(".//*[@id='enterTTMainContent']/table[1]/tbody/tr[3]/td[1]/table/tbody/tr/td[7]/nobr/span")).click();
		Thread.sleep(3000);
		//select customer
		d.findElement(By.xpath(" //div[@id='createTasksPopup_customerSelector']/child::table/descendant::tr/td[1]/following-sibling::td[1]/child::*/child::*")).click();
		d.findElement(By.xpath("//*[contains(text(),'- New Customer -')]")).click();
		
		d.findElement(By.xpath("//input[@id='createTasksPopup_newCustomer']")).sendKeys("Hari Krishna");
		d.findElement(By.xpath("//input[@id='createTasksPopup_newProject']")).sendKeys("Steel Exports");
		Thread.sleep(2000);
		
		int count = d.findElements(By.xpath("//thead[@id='createTasksPopup_createTasksTableTHead']/following-sibling::tbody/tr")).size();
		
		for(int i=1;i<=count;i++)
		{
		String firstPart = "//thead[@id='createTasksPopup_createTasksTableTHead']/following-sibling::tbody/tr[";
		String secondPart = "]";
		String finalPart=firstPart+i+secondPart;
		
		//Enter Task Name
		String entertaskName=finalPart+"/td[1]/input";
		d.findElement(By.xpath(entertaskName)).sendKeys("Task:"+i);
		
		//DeadLine
		String setDeadLine = finalPart+"/td[3]/div/child::table/descendant::tbody/tr/child::td[2]/child::*/child::*";
		d.findElement(By.xpath(setDeadLine)).click();
		
		if(i>=1)
		{
		d.findElements(By.xpath("//*[@class='x-date-picker x-unselectable atap-base-date-picker atap-date-picker']/table/tbody/tr/td[2]/table/tbody/tr/td[2]/em/button")).get(i-1).click();
		
		}
		Thread.sleep(2000);
		
		if(i>=1)
		{
			d.findElements(By.xpath("//a[contains(text(),'"+month+"')]")).get(i-1).click();
			d.findElements(By.xpath("//a[contains(text(),'"+year+"')]")).get(i-1).click();
		}
		
		
		if(i>=1) {
			 d.findElements(By.xpath("//button[@class='x-date-mp-ok']")).get(i-1).click();
		}
		
		//Date Selection
		if(i==1) {
		d.findElements(By.xpath("//span[contains(text(),'"+day+"')]")).get(1).click();
		}
		if(i==2)
		{
			d.findElements(By.xpath("//span[contains(text(),'"+day+"')]")).get(3).click();
		}
		if(i==3)
		{
		d.findElements(By.xpath("//span[contains(text(),'"+day+"')]")).get(5).click();
		}
		
		//Type of Work
		String typeofwork = finalPart+"/td[4]/div/table/tbody/tr/td[2]/em/button";
		
		d.findElement(By.xpath(typeofwork)).click();
		
		if(i==1)
		{
		 d.findElements(By.xpath("//div[@class='x-layer x-menu at-dropdown-list-btn-menu billingTypeSelectorMenu addNewTasks']/ul/li")).get(1).click();
		}
		if(i==2)
		{
		 d.findElements(By.xpath("//div[@class='x-layer x-menu at-dropdown-list-btn-menu billingTypeSelectorMenu addNewTasks']/ul/li")).get(13).click();
		}
		if(i==3)
		{
		 d.findElements(By.xpath("//div[@class='x-layer x-menu at-dropdown-list-btn-menu billingTypeSelectorMenu addNewTasks']/ul/li")).get(21).click();
		}
		
		}
		
		
		
	}
	

}
