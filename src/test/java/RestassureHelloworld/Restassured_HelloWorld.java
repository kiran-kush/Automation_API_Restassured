package RestassureHelloworld;

import io.restassured.RestAssured;

public class Restassured_HelloWorld {
    public static void main(String[] args) {
       // System.out.println("hello world");
        // get request
        // fetch url
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com/ping")
                   .when().get()
                   .then().log().all().statusCode(201);
    }

}
