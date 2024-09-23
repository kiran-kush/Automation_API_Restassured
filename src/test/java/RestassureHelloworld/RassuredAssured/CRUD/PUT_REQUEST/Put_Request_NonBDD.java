package RestassureHelloworld.RassuredAssured.CRUD.PUT_REQUEST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Put_Request_NonBDD {
    // get a token- post
    // create a booking and get id
    // id and token in put request
    // update the booking

    // make a post request to the auth- get the token
    //pass the token to the put request
    // id-
    //123
    //make put request with the token and validate.
        RequestSpecification requestSpecification;
        Response response;
        ValidatableResponse validatableResponse;
        @Description ("This is for test")
        @Test
        public void get_Token(){


        }
        public void get_booking_ID(){



        }


    public void test_putPositive_tc(){
        String payload_token= "{\n" +
                "      \"username\": \"admin2\",\n" +
                "       \"password\" : \"password1234\"\n" +

                "}";
        String token = "63f0b93ed93c740";
        String booking_id=  "817";
        String payload_put= "{\n" +

                "      \"firstname\" : \"Joe\",\n" +
                "       \"lastname\" : \"Barden\", \n" +
                "      \"totalprice\" : 111, \n" +
                "      \"depositpaid\" : false,\n" +
                "      \"bookingdates\" : {\n" +
                "  \"checkin\" : \"2024-01-01\",\n" +
                "      \"checkout\" : \"2024-01-01\" \n" +
                "  },\n" +

                "       \"additionalneeds\" : \"Breakfast\" \n" +
                "}";

        requestSpecification= RestAssured.given();
               requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
               requestSpecification.basePath("/booking/"+ booking_id);
               requestSpecification.contentType(ContentType.JSON);
               requestSpecification.cookie("token", token);
               requestSpecification.body(payload_put).log().all();

               response= requestSpecification.when().put();

               validatableResponse= response.then().log().all();
               validatableResponse.statusCode(200);

    }
}
