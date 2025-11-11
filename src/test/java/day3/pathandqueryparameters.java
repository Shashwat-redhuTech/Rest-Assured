package day3;


import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class pathandqueryparameters {
	

	@Test
	void testPathParameters()
	{
		given()
	    .pathParam("mypath", "users")
	    .pathParam("userid", 5)
	    .header("x-api-key", "reqres-free-v1")   // <<-- add this
	    .log().all()
	.when()
	    .get("https://reqres.in/api/{mypath}/{userid}")
	.then()
	    .log().all()
	    .statusCode(200);
	}
	
	
	
	
	
}
