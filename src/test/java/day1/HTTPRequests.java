package day1;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;


import java.util.Map;




/*
given()
  content type, set cookies, add auth, add param, set headers info etc...

when()
  get, post, put, delete

then()
  validate status code, extract response, extract headers cookies & response body...
*/



public class HTTPRequests {
	
	@Test
	void getUsers()
	{
	    given()

	      .when()
	        .get("https://reqres.in/api/users?page=2")

	      .then()
	        .statusCode(200)
	        .body("page", equalTo(2))
	        .log().all();

	}
	
	
	
	
	String userId;

	    @Test
		void createUser() {
		  userId = given()
		            .baseUri("https://reqres.in")
		            .basePath("/api")
		            .contentType(ContentType.JSON)
		            .header("x-api-key", "reqres-free-v1")
		            .body(Map.of("name","Abdullah","job","Maqsad"))
		        .when()
		            .post("/users")
		        .then()
		            .statusCode(201)
		            .body("id", notNullValue())         // sanity check
		            .extract()
		            .path("id");                         // <- capture it

		    System.out.println("Created user id: " + userId);
		}
	    
	
	    @Test(dependsOnMethods = "createUser")
	    void updateData() {
	        given()
	            .baseUri("https://reqres.in")
	            .basePath("/api")
	            .contentType(ContentType.JSON)
	            .header("x-api-key", "reqres-free-v1")
	            .pathParam("id", userId)
	            .body(Map.of("name","Abdullah","job","QA Lead"))
	        .when()
	            .put("/users/{id}")
	        .then()
	            .statusCode(200)
	            .body("name", equalTo("Abdullah"))
	            .body("job", equalTo("QA Lead"))
	            .body("updatedAt", notNullValue())
	            .log().all();
	    }
	    
	    
	    @Test(dependsOnMethods = "createUser")
	    void deleteUser() {
	        given()
	            .baseUri("https://reqres.in")
	            .basePath("/api")
	            .header("x-api-key", "reqres-free-v1")
	            .pathParam("id", userId)
	        .when()
	            .delete("/users/{id}")
	        .then()
	            .statusCode(204)
	            .log().all();
	    }
          
   
}  



