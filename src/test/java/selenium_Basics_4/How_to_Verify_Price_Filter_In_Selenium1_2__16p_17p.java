package selenium_Basics_4;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class How_to_Verify_Price_Filter_In_Selenium1_2__16p_17p {
	WebDriver d;
	@Test
	public void testVerify_Price_Filter() throws Exception
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		d.get("http://automationpractice.com/index.php");
		
		//click on dresses
		d.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a")).click();
		
		//select price
		Select select = new Select(d.findElement(By.id("selectProductSort")));
		select.selectByIndex(1);
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(d,60);
		wait.until(ExpectedConditions.visibilityOf(d.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/h5/a"))));
		
		List<WebElement> allprices = d.findElements(By.xpath("//div[@id='center_column']/ul/li/div/div[2]/div[1]/span[1]"));
		ArrayList<Integer> al=new ArrayList<Integer>();
		Iterator<WebElement> itr = allprices.iterator();
		while(itr.hasNext())
		{
			String price = itr.next().getText();
			System.out.println(price);
			if(price.contains("$"))
			{
				String p = price.substring(1);
				System.out.println(p);
				double p1 = Double.parseDouble(p);
				int prices = (int)(p1);
				al.add(prices);
			}
			
		}
		for(int i=0;i<al.size()-1;i++)
		{
			
			if(al.get(i)<al.get(i+1))
			{
				System.out.println(al.get(i));
				System.out.println(al.get(i+1));
			}
			else
			{
				assertTrue(false);
			}
		}
	
		d.quit();
	}
	
	

}
