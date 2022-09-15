package practice;

import java.util.Random;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class To_Generate_random_NUmberTest {
@Test
	public  void rannum() {
		Random r=new Random();
		int randomnum=r.nextInt(1000);
		
		Reporter.log("rand num created"+randomnum, true);

	}

}
