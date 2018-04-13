package selenium_Scripting_3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Creating_New_Lead_V_Tiger_Complete_Code_4 {
	WebDriver d;
	@Test
	public void testCreateLeads() throws Exception
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		d.get("http://localhost:8888/");
		d.findElement(By.xpath("//input[@name='user_name' and @type='text']")).sendKeys("admin");
		d.findElement(By.xpath("//input[@name='user_password' and @type='password']")).sendKeys("password");
		d.findElement(By.id("submitButton")).click();
		//Leads
		d.findElement(By.linkText("Leads")).click();
		//Add
		d.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		//details
		Select sel = new Select(d.findElement(By.xpath("//select[@name='salutationtype']")));
		sel.selectByIndex(1);
		d.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Hanish krishna");
		d.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Thavidaboina");
		d.findElement(By.xpath("//input[@name='company']")).sendKeys("wave9IT");
		d.findElement(By.id("designation")).sendKeys("Its my Life.....");
		WebElement leadsource = d.findElement(By.xpath("//select[@name='leadsource']"));
		sel = new Select(leadsource);
		sel.selectByVisibleText("Employee");
		
		WebElement industry = d.findElement(By.xpath("//select[@ name='industry']"));
		sel = new Select(industry);
		sel.selectByVisibleText("Construction");
		
		d.findElement(By.xpath("//input[@name='annualrevenue']")).sendKeys("100000");
		d.findElement(By.id("noofemployees")).sendKeys("100");
		d.findElement(By.id("secondaryemail")).sendKeys("hari@gmail.com");
		d.findElement(By.xpath("//textarea[@name='lane']")).sendKeys("new patel nager,hyderabad.");
		d.findElement(By.id("code")).sendKeys("500013");
		d.findElement(By.id("country")).sendKeys("India");
		d.findElement(By.xpath("//textarea[@class='detailedViewTextBox' and @name='description']")).sendKeys("MY LIFE....MY RULES!!");
		
		d.findElement(By.id("phone")).sendKeys("040-2574658");
		d.findElement(By.id("mobile")).sendKeys("9291509904");
		d.findElement(By.id("fax")).sendKeys("fax25");
		d.findElement(By.id("email")).sendKeys("krishna@gmail.com");
		d.findElement(By.xpath("//input[@class='detailedViewTextBox' and @name='website']")).sendKeys("automation.com");
		
		WebElement status = d.findElement(By.xpath("//select[@class='small' and @name='leadstatus']"));
		sel = new Select(status);
		sel.selectByVisibleText("Contacted");
		
		WebElement rating = d.findElement(By.xpath("//select[@class='small' and @name='rating']"));
		sel = new Select(rating);
		sel.selectByVisibleText("Active");
		
		d.findElement(By.xpath("//input[@name='assigntype' and @value='T']")).click();
		d.findElement(By.id("pobox")).sendKeys("PO-8554");
		d.findElement(By.id("city")).sendKeys("hyderabad");
		d.findElement(By.id("state")).sendKeys("Telangana");
		d.findElement(By.xpath("//input[@class='crmbutton small save' and @title='Save [Alt+S]']")).click();
		
		Thread.sleep(3000);
		d.quit();
		
		
		
		
		
		
	}


}
