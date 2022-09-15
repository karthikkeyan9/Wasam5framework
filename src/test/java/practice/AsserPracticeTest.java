package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AsserPracticeTest {
	@Test
	public void asserrtion()
	{
		System.out.println("------test pass1-------");
		System.out.println("------test pass2-------");
		System.out.println("------test pass3-------");
	//	Assert.assertEquals("b", "a");
		System.out.println("------test pass4-------");
		System.out.println("------test pass5-------");
		
	}
	@Test
	public void assertion2()
	{ 
		SoftAssert sa=new SoftAssert();
		System.out.println("------test pass1()-------");
		sa.assertFalse(false);
		System.out.println("------test pass2 ()-------");
		System.out.println("------test pass3 ()-------");
		
		sa.assertEquals("a", "a");
		System.out.println("------test pass4 ()-------");
	//	sa.assertEquals(0, 1);
		System.out.println("------test pass5 ()-------");
		sa.assertAll();
	}

}
