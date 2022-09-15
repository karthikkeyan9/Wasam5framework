package vtiger_Generic_Library;

import java.util.Date;
import java.util.Random;
/**
 * This class Contains all the java specfic methouds
 * @author saikrishna
 *
 */

public class JavaUtlity {
	
	public int getRandumnuber()
	/**
	 * This methoud gives a random number
	 */
	{
		Random r=new Random();
		int random=r.nextInt(1000);
		return random;
	}
	/**
	 * This methoud gives present date as returntype
	 * @return
	 */
	public String getSystemdate()
	{
		Date d=new Date();
		String date=d.toString();
		return date;
	}
	/**
	 * This methoud gives the date in formate of date-month-year-time
	 * @return
	 */
	public String getSystemdateInFormate() {
		Date d=new Date();
		String[] dr = d.toString().split(" ");
		String date= dr[2];
		String month=dr[1];
		String year=dr[dr.length-1];
		String time=dr[3].replaceAll(":", "_");
		String currentdatetimemonth=date+" "+month+" "+year+" "+time;
		return currentdatetimemonth;
	}
}
