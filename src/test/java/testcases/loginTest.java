package testcases;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import Utlity.DataProvider;
import pages.LoginPage;

public class loginTest extends BaseClass

{

	@Test
	public void loginvalidate() throws IOException, InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		Map<String, String> emailMap = DataProvider.getemail();
	    Map<String, String> passwordMap = DataProvider.getpassword();
	    System.out.println(emailMap.get("username1"));
	   // System.out.println(passwordMap.get("password1"));
	   int counter=DataProvider.getRowCount();
	   for(int i=1;i<=counter;i++)
	   {
	   lp.login(emailMap.get("username"+i), passwordMap.get("password"+i));
	   
	  Assert.assertTrue(lp.isSignOutDisplayed(),"Login failed: Sign Out button not visible");
	  lp.clickSignOut();
	   }
	    driver.close();
	}
}

