package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager 
{
	public static ExtentReports extent;
	public static ExtentReports getInstances()
	{
		 if (extent == null) {
		
		String path= System.getProperty("user.dir")+"/test-output/ExtentReport.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Test Results");
		reporter.config().setDocumentTitle("Selenium Framework Report");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Nipun");
        extent.setSystemInfo("Environment", "QA");
		 }
		return extent;
	}

}
