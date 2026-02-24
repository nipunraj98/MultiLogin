package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClass 
{
	private static Properties prop;
	public static WebDriver driver;
	public static Logger log = LogManager.getLogger(BaseClass.class);
	
	@BeforeTest
	public void setup() throws IOException
	{
		log.info("========== Test Execution Started ==========");
		String path= System.getProperty("user.dir")+"/src/main/resources/file.properties";
		FileInputStream fis=new FileInputStream(path);
		prop=new Properties();
		prop.load(fis);
		String url=prop.getProperty("url");
		log.info("Launching Chrome browser");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log.info("Opening URL: " + url);
		driver.get(url);
		
		//System.out.println(url);
	}
	  @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            log.info("Closing browser");
	            driver.quit();
	        }
	        log.info("========== Test Execution Finished ==========");
	    }
	  
	  
	   public static String captureScreenshot(WebDriver driver, String testName) 
	   {

	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	        String path = System.getProperty("user.dir")
	                + "/test-output/screenshots/" + testName + ".png";

	        try {
	            FileUtils.copyFile(src, new File(path));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return path;
	    }
	
	  
	
}
