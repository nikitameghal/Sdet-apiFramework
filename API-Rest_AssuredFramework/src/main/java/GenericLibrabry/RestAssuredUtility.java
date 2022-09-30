package GenericLibrabry;

import io.restassured.response.Response;

public class RestAssuredUtility {
	
	
	/**
	 * this method willl fetch the data based on json path
	 * @param resp
	 * @param path
	 * @return
	 */
	public String getJsonData(Response resp,String path) 
	{
		String jsonData = resp.jsonPath().get(path);
		return jsonData;
	}

}
