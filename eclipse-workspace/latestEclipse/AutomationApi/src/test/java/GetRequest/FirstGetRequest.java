package GetRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstGetRequest {

	Response response;
	@Test
	void testCase01() {
		 response = RestAssured.get("https://reqres.in/api/users/2");
		 System.out.println(response.asString());
		 System.out.println("Status Code "+response.getStatusCode());
	}
}
	