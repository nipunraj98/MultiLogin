package TestNG;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test1 
{
	
	@Test
	@Parameters({"username", "password"})
	public void sample( @Optional ("abc" )String name, @Optional ("8888") String pass)
	{
		System.out.println("name is:"+name);
		System.out.println("password is:"+pass);
	}
	
	@Test
	@Parameters({"username", "password"})
	public void samp1( @Optional ("abc" )String name, @Optional ("8888") String pass)
	{
		System.out.println("name is:"+name);
		System.out.println("password is:"+pass);
	}

	@Test
	public void samp2()
	{
		System.out.println("sample");
	}
	
	
}
