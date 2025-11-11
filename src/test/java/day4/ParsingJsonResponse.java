package day4;


import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
public class ParsingJsonResponse {

//    @Test
//    void testJsonResponse1() {
//        given()
//            .contentType(ContentType.JSON)
//        .when()
//            .get("http://localhost:3000/book")
//        .then()
//            .statusCode(200)
//            .body("[3].title", equalTo("Foundation"));
//    } 
//    
  //Approach2
  @Test
  void testJsonResponse2() {
      // Step 1: Send GET request and capture response
      Response res = given()
          .contentType(ContentType.JSON)
      .when()
          .get("http://localhost:3000/book");

      // Step 2: Convert response to String
      String responseBody = res.asString();

      // Step 3: Since the root element is an array, parse it as JSONArray
      JSONArray booksArray = new JSONArray(responseBody);

      // Step 4: Iterate through each book and print the title
      for (int i = 0; i < booksArray.length(); i++) {
          JSONObject book = booksArray.getJSONObject(i);
          String title = book.getString("title");
          System.out.println(title);
      }
  }

}

