package TestNG;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class link 
{
	
	@Test
	public void verifylink()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		List <WebElement>links=driver.findElements(By.tagName("a"));
		for(WebElement link:links)
		{
			String url=link.getAttribute("href");
			System.out.println(url);
			if(url==null||url.isEmpty())
			{
				continue;
			}
			try
			{
				URL linkurl=new URL(url);
				
			HttpURLConnection conn=(HttpURLConnection)linkurl.openConnection();
			conn.connect();
			int responsecode=conn.getResponseCode();
			if(responsecode>=400)
			{
				System.out.println(url +":invalid link");
					
			}
			else
			{
				System.out.println(url +":valid link");
			}
		}
			catch(Exception e) {
				System.out.println(url +":exception occured");
			}
			
		}
		
		driver.close();
		
	}

}
