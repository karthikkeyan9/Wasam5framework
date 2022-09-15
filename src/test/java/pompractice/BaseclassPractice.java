package pompractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseclassPractice {
	@BeforeSuite
	public void bsconfig()
	{
		System.err.println("before suit");
	}
	/*@BeforeTest
	public void btconfig()
	{
		System.out.println("before test");
	}*/
	@BeforeClass
	public void bcconfig()
	{
		System.out.println("before class");
	}
	@BeforeMethod
	public void bmconfig()
	{
		System.out.println("before methoud");
	}
	@Test
	public void test()
	{
		System.out.println("test");
	}
	@Test
	public void test1()
	{
		System.out.println("test1");
	}
	@AfterMethod
	public void amconfig() {
		System.out.println("after methoud");
	}
	@AfterClass
	public void acconfig()
	{
		System.out.println("after class");
	}
	@AfterSuite
	public void asconfig()
	{
		System.out.println("after suit");
	}
}

