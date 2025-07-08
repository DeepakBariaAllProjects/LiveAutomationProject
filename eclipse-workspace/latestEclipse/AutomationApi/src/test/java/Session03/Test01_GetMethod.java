package Session03;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class Test01_GetMethod {
	Response response;
	@Test(priority = 1)
	public void Test01() {
		 response = get("https://reqres.in/api/users?page=2");
		System.out.println("Response Code:: "+response.asString());
		System.out.println("Response Body:: "+response.getBody().asString());
		System.out.println("Response Time:: "+response.getTime());
		System.out.println("Response Header:: "+response.getHeader("Content-Type"));
		System.out.println("Response Time:: "+response.getStatusCode());
		
		int ExpectedStatusCode = 200;
		int ActualStatusCode = response.getStatusCode();
		Assert.assertEquals(ExpectedStatusCode, ActualStatusCode);
	}
	@Test(priority = 2)
	public void Test02() {
		baseURI = "https://reqres.in/api/users";
		given().queryParam("page", "2").when().get().then().statusCode(200);
	}
}
