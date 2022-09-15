package vtiger_Generic_Library;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
/**
 * This class contains all the database related methouds will helps in performing the operations 
 * @author saikrishna
 *
 */
public class DatabaseUtility {
	Driver diverref;
	Connection con =null;
	Statement state;
	
	/**
	 * This methoud is used to create connection to DB
	 * @throws SQLException
	 */
	public void toCreateCOnnection() throws SQLException
	{
		diverref=new Driver();
		
		DriverManager.registerDriver(diverref);
		 con = DriverManager.getConnection(ConstantsUtility.dburl,ConstantsUtility.dbusername,ConstantsUtility.dbpassword);
		state = con.createStatement();
	}
	/**
	 * This methoud is used to create connection by passing values and excute passed query and
	 *  check for the expected data passed if the expected data will pass the data or will return null
	 * gives return as Resultset 
	 * @return
	 * @throws SQLException
	 */
	public String executequery(String query,int coolindex,String expdata) throws SQLException
	{  
		boolean flag=false;
	    ResultSet re = state.executeQuery(query);
	    while(re.next())
	    {
	    	String actdata = re.getString(coolindex);
	    if(actdata.equals(expdata))
	    {
	    	flag=true;
	    	break;
	    }
	    }
	    if(flag)
	    {
	    	System.out.println("data present"+expdata);
	    	return expdata;
	    }
	    else
	    {
	    	System.out.println("data not present"+expdata);
	    	return " " ;
	    	}
	}
	/**
	 * This methoud is used to create connection by passing values and excute passed update 
	 * Return the updated values in int
	 * @return
	 * @throws SQLException
	 */
	public int wxcuteupdate() throws SQLException
	{
		 diverref=new Driver();
		 DriverManager.registerDriver(diverref);
		 con = DriverManager.getConnection(ConstantsUtility.dburl,ConstantsUtility.dbusername,ConstantsUtility.dbpassword);
		state = con.createStatement();
		int rowsupdated = state.executeUpdate(null);
		return rowsupdated;
	}
	public void closeDb() throws SQLException {
		 diverref=new Driver();
		 DriverManager.registerDriver(diverref);
		 con = DriverManager.getConnection(ConstantsUtility.dburl,ConstantsUtility.dbusername,ConstantsUtility.dbpassword);
		
	}
	

}
