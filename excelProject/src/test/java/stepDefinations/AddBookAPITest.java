package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resources.ReusableMethods;

public class AddBookAPITest 
{

	@Test
	public void addBook() throws IOException
	{
		HashMap<String, Object> payloadmap = new HashMap<String, Object>();
		payloadmap.put("name", "nitintajane16");
		payloadmap.put("isbn", "test16");
		payloadmap.put("aisle", "1234516");
		payloadmap.put("author", "vikrant16");
		
		
// example 2 see below json 
		
		/*{
			"name":"nitintajane1",
			"location":{
						"lat" : 1.1,
						"lng" : 1.2
						}
			}
		
		HashMap<String, Object> locationvalue = new HashMap<String, Object>();
		locationvalue.put("lat", 1.1);
		locationvalue.put("lng", 1.2);
		
		HashMap<String, Object> payloadmap2 = new HashMap<String, Object>();
		payloadmap2.put("name", "nitintajane16");
		payloadmap2.put("location", locationvalue);*/
		
		RestAssured.baseURI="http://216.10.245.166";
		Response resp=given().
				header("Content-Type","application/json").
		body(payloadmap).
		when().
		post("/Library/Addbook.php").
		then().assertThat().statusCode(200).
		extract().response();
		 JsonPath js= ReusableMethods.rawToJson(resp);
		   String id=js.get("ID");
		   System.out.println(id);
	
	

	}
}
