package CreateProject;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericLibrabry.BaseAPIClass;
import GenericLibrabry.EndpointUtility;
import POJO_Libraries.Project_Library;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateProjectandVerifyinDB extends BaseAPIClass
{
	
	@Test
	public void createProject() throws Throwable
	{
		//step:1  create prerequisite
		Project_Library plib= new Project_Library("nikita", "framework", "on Going", 10);
		
		//step:2  send  post request 
		Response resp = given()
		.body(plib)
		.contentType(ContentType.JSON)
		.when()
		.post(EndpointUtility.createProject);
		
		//capture the project ID
		String expData = rlib.getJsonData(resp, "projectId");
		System.out.println(expData);
		
		
		//verify the project ID in database
		String query="select* from project;";
		String actData = dlib.ExecuteQueryandReturnData(query, 1, expData);
		Assert.assertEquals(actData, expData);
	}

}
