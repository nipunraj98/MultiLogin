package TestNG;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class amazon
{
	

	public static WebDriver driver;
    
	  
    public static void main(String args[])throws InterruptedException
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.in/");
        WebElement element=driver.findElement(By.xpath("//a[text()='Mobiles']"));
        Actions ab=new Actions(driver);
        ab.keyDown(Keys.CONTROL).click(element).keyUp(Keys.CONTROL).perform();
        List<String> windows= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        
    }
}  
