package day2;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.Map;


/*
5 Different ways to create POST request body
1) Post request body using Hashmap
2) Post request body creation using Org.JSON
3) Post request body creation using POJO class
4) Post request body using external json file data
*/

// we can use hashmap,map,pojo class, external json file to create post request body

public class DiffwaysTocreatePost {
	
	
	@Test
		
	void createUserPojo() {
	    String courseArray[] = {"Java", "Python"};
	    Pojo student = new Pojo(null, "Himmat", "singh", "Male", courseArray);

	    given()
	        .baseUri("http://localhost:3000")
	        .basePath("/students")
	        .contentType(ContentType.JSON)
	        .body(student)
	    .when()
	        .post("")
	    .then()
	        .statusCode(201)
	        .body("firstName", equalTo("Himmat"))
	        .body("gender", equalTo("Male")) 
	        .log().all();
	}
 
	@Test
    void createUser() {
		String courseArray[] = {"Java","Python"};
        given()
            .baseUri("http://localhost:3000")
            .basePath("/students")          // set once
            .contentType(ContentType.JSON)
            .body(Map.of(
            	"courses",   courseArray,
                "firstName", "Himmat",
                "lastName",  "singh",
                "email",     "junaid@example.com",
                "gender",    "Male"
            
            ))
        .when()
            .post("")                        
        .then()
            .statusCode(201)                
            .body("firstName", equalTo("Himmat"))
            .body("gender", equalTo("Male"))
            .log().all();
    }
	@Test
	  void deleteUsers() {
	    String[] ids = {"cf7b", "cb5d", "dfe3"};

	    for (String id : ids) {
	      given()
	          .baseUri("http://localhost:3000")
	      .when()
	          .delete("/students/{id}", id)
	      .then()
	          .statusCode(anyOf(is(200), is(204))); 
	    }
	    
	  }
	

}
