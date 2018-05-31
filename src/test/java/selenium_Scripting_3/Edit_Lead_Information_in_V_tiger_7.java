package selenium_Scripting_3;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Edit_Lead_Information_in_V_tiger_7 {
	WebDriver d;
	@Test
	public void testEditData()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		d.get("http://localhost:8888/");
		d.findElement(By.xpath("//input[@name='user_name' and @type='text']")).sendKeys("admin");
		d.findElement(By.xpath("//input[@name='user_password' and @type='password']")).sendKeys("password");
		d.findElement(By.id("submitButton")).click();
		//Leads
		d.findElement(By.linkText("Leads")).click();
		
		d.findElement(By.xpath("//a[contains(text(),'Hanish krishna') and @title='Leads']/parent::td/following-sibling::td[6]/child::a[1]")).click();
		d.findElement(By.xpath("//td[@class='dvtCellInfo']/input[@name='company']")).clear();
		d.findElement(By.xpath("//td[@class='dvtCellInfo']/input[@name='company']")).sendKeys("Infosys");
		d.findElement(By.xpath("//input[@class='crmbutton small save' and @title='Save [Alt+S]']")).click();
		d.findElement(By.xpath("//a[contains(text(),'Hanish krishna') and @title='Leads']")).click();
		String company = d.findElement(By.id("mouseArea_Company")).getText();
		assertEquals(company.substring(2),"Infosys");
		System.out.println("*******End********");
		d.quit();
		
		
	}
	

}
