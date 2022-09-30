package GenericLibrabry;

import java.sql.SQLException;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

/**
 * this class contains basic configuration annotation
 * @author hp
 *
 */
public class BaseAPIClass {
	
	public DataBaseUtility dlib=new DataBaseUtility();
	public JavaUtility jlib=new JavaUtility();
	public RestAssuredUtility rlib=new RestAssuredUtility();
	
	@BeforeSuite
	public void bsconfig() throws SQLException
	{
		dlib.connectToDB();
		Reporter.log("===DB connection successful==",true);
		
		baseURI=IconstantUtility.apiURL;
		port=IconstantUtility.apiPort;
		
	}
	
	@AfterSuite
	public void asconfig() throws Throwable 
	{
		dlib.closeDB();
		Reporter.log("==db connection close",true);
	}

}
