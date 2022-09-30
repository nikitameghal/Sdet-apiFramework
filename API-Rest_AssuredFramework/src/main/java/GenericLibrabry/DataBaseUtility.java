package GenericLibrabry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility 
{
	Driver driverRef;
	Connection conn;
	
	
	/**
	 * this method establish the connection with database
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException 
	{
		driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		conn = DriverManager.getConnection(IconstantUtility.dbURL, IconstantUtility.dbUsername, IconstantUtility.dbPassword);
		
	}
	
	/**
	 * this method is used close database connection
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException 
	{
		conn.close();
	}
	
	/**this method is used to excute query
	 * @author nikita
	 * @param query
	 * @param coloumIndex
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
	public String ExecuteQueryandReturnData(String query,int coloumIndex,String expData) throws Throwable
	{
		ResultSet result = conn.createStatement().executeQuery(query);
		boolean flag = false;
		while(result.next())
		{
			String actData = result.getString(coloumIndex);
			if(expData.equalsIgnoreCase(actData))
			{
				flag=true;
				break;
			}
			
		}
		if(flag)
		{
			System.out.println("data is varified");
			return expData;
			
		}
		else 
		{
			System.out.println("varification failed");
			return "";
		}
		
	}
	
	
	
	
	
	
	
	
	
}
