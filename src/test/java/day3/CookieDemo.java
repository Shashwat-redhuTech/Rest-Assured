package day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;



public class CookieDemo {
   	
	@Test
	void testCookies()
	{

	    given()

	    .when()
	        .get("https://www.google.com/")

	    .then()
	        .cookie("AEC", "AakniGOLxRQC9fG16mjPYfT76_mMHEZC-z_5xRB2ApP18Ag2HZDJvBWMxZU")
	        .log().all();
	} 
	
	@Test
    void getCookiesInfo()
    {
        Response res = given()
    
        .when()
            .get("https://www.google.com/");
    
        //get single cookie info
        String cookie_value = res.getCookie("AEC");
        System.out.println("Value of cookie is===>" + cookie_value);
    }
	
	
	
}
