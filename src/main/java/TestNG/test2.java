package TestNG;

import org.testng.annotations.Test;

public class test2 
{
	
	@Test(groups= {"smoke"})
	
	public void hello()
	{
		System.out.println("Thread: " + Thread.currentThread().threadId());
		
		System.out.println("Hello");
	}

	
@Test(groups= {"smoke"})
	
	public void hello2()
	{
		System.out.println("Thread: " + Thread.currentThread().threadId());
		
		System.out.println("Hello2");
	}

@Test(groups= {"regression"})

public void hello3()
{
	System.out.println("Thread: " + Thread.currentThread().threadId());
	
	System.out.println("Hello3");
}
}
