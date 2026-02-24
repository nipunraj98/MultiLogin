package TestNG;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class selenium 
{
	  public static WebDriver driver;
	    
	  
	    public static void main(String args[])throws InterruptedException
	    {
	        driver=new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	        String[] itemsNeeded = {"Brocolli","Cucumber","Beetroot"};

	        List<String> itemsList = Arrays.asList(itemsNeeded);
	       List<WebElement>products = driver.findElements(By.xpath("//h4[@class='product-name']"));
	       System.out.println(products .size());
	       int size=products .size();
	       for(int i=0;i<size;i++)
	       {
	    	   String name=products.get(i).getText();
	    	   String vegname=name.split("-")[0].trim();
	    	 
	    	   if(itemsList.contains(vegname))
	    	   {
	    		   driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
	    	   }
	    	   
	       }	
	       //WebElement element=dr
	      // driver.switchTo().newWindow(WindowType.TAB);
	     //  driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}

}
