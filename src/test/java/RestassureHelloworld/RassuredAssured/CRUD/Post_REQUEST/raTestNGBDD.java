package RestassureHelloworld.RassuredAssured.CRUD.Post_REQUEST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class raTestNGBDD {
     @Test
     public void getRequest_Positive() {

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com/ping")
                .when().get()
                .then().log().all().statusCode(201);
    }
        // make a request()
        // base url: "https://restful-booker.herokuapp.com/ping"
        // base path: "/ping"

       // payload
       // content type
       // Http method: post

     // verify
     //  status code
     // token should not be null
    @Test
    public void PostRequest() {

         String payload= "{\n"  +
                 "      \"username\": \"admin\",\n" +
                 "       \"password\" : \"password123\"\n" +

         "}";
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)
                .when().body(payload).post()
                .then().log().all().statusCode(200);
    }
}
