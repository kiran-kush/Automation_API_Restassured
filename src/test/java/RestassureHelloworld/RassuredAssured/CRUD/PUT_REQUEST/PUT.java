package RestassureHelloworld.RassuredAssured.CRUD.PUT_REQUEST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PUT {

     // get a token- post
    // create a booking and get id
    // id and token in put request
    // update the booking

    // make a post request to the auth- get the token
    //pass the token to the put request
    // id-
    //123
    //make put request with the token and validate.
    RequestSpecification r;
    Response res;
    ValidatableResponse VR;

      @BeforeTest
      public void prePostRequest(){

       r= RestAssured.given();
       r.baseUri("https://restful-booker.herokuapp.com/ping");
       r.basePath("/auth");

    }
     public void postrequest() {
         String payload = "{\n" +
                 "      \"username\": \"admin2\",\n" +
                 "       \"password\" : \"password1234\"\n" +

                 "}";
         r.body(payload);
         r.contentType(ContentType.JSON);
         res = r.when().post();
         String responsString = res.asString();
         VR = res.then().log().all();
         VR.statusCode(200);


         String token = res.then().extract().path("token");
         System.out.println(token);
         String payload_patch = "{\n" +

                 "      \"firstname\" : \"Sandra\",\n" +
                 "       \"lastname\" : \"Brown\", \n" +
                 "      \"totalprice\" : 111, \n" +
                 "      \"depositpaid\" : true,\n" +
                 "      \"bookingdates\" : {\n" +
                 "  \"checkin\" : \"2018-01-01\",\n" +
                 "      \"checkout\" : \"2019-01-01\" \n" +
                 "  },\n" +

                 "       \"additionalneeds\" : \"Breakfast\" \n" +
                 "}";

         // name and id need to b updated
         // name= sandra from james
         // booking id= 4637
         r.basePath("booking");
         r.body(payload_patch);
         VR= res.then().log().all();
         VR.statusCode(200);

         Integer bookingid= res.then().extract().path("bookingid");
}


     }


