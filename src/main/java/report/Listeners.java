package report;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Base.BaseClass;

public class Listeners  extends BaseClass implements  ITestListener
{

	 ExtentReports extent = ExtentManager.getInstances();
	    ExtentTest test;
	    Logger log = LogManager.getLogger(Listeners.class);
	    
	    @Override
	    public void onTestStart(ITestResult result) {
	        test = extent.createTest(result.getMethod().getMethodName());
	        log.info("TEST STARTED: " + result.getMethod().getMethodName());     
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	    	test.pass("Test Passed");
	        log.info("TEST PASSED: " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {

	    	test.fail(result.getThrowable());
	        log.error("TEST FAILED: " + result.getMethod().getMethodName());
	        log.error(result.getThrowable());

	        WebDriver driver = null;

	        // ⭐ Get driver from failed test class (IMPORTANT)
	        try {
	            driver = (WebDriver) result.getTestClass()
	                    .getRealClass()
	                    .getField("driver")
	                    .get(result.getInstance());
	        } catch (Exception e) {
	            log.error("Unable to fetch WebDriver: " + e.getMessage());
	        }

	        // Screenshot
	        String path = BaseClass.captureScreenshot(driver, result.getMethod().getMethodName());

	        try {
	            test.addScreenCaptureFromPath(path);
	            log.info("Screenshot captured: " + path);
	        } catch (Exception e) {
	            log.error("Screenshot attach failed");
	        }
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	    	extent.flush();
	        log.info("Extent report generated");
	    }
}
