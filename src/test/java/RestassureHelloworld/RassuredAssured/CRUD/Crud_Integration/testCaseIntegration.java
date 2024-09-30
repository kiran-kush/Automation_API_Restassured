package RestassureHelloworld.RassuredAssured.CRUD.Crud_Integration;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testCaseIntegration {
    // Create a token
    // Create a booking
    // perform a patch request
    //verify that put is success by get request
    //Delete the Id
    // Verify it does'nt exist
    static RequestSpecification requestSpecification;
    static Response response;
    static ValidatableResponse validatableResponse;
    String token;
    String bookingID;
    String fName;
    String lName;
    @Description ("This is get token id")
    @BeforeTest
    public String getToken(){
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        String payload = "{\n" +
                "      \"username\": \"admin\",\n" +
                "       \"password\" : \"password123\"\n" +

                "}";
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);
        requestSpecification.post();
        response = requestSpecification.post();
        String responseString = response.asString();
        System.out.println(responseString);
        validatableResponse = response.then();
        validatableResponse.statusCode(200);
        token= response.jsonPath().getString("token");
        System.out.println(token);
        return token;


    }
     @Description ("To get the bookingId")
     @Severity(SeverityLevel.NORMAL)
     @BeforeTest(dependsOnMethods = "getToken")
    public String getBookingId(){
        String payload_Post= "{\n" +

                "      \"firstname\" : \"Amit\",\n" +
                "       \"lastname\" : \"Verma\", \n" +
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
        requestSpecification.basePath("/booking/");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        requestSpecification.body(payload_Post).log().all();

        response= requestSpecification.when().post();

        validatableResponse= response.then().log().all();
        validatableResponse.statusCode(200);
        bookingID= response.jsonPath().getString("bookingid");


        return bookingID;
    }
     @Description ("to update the booking")
     @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testUpdateRequestPut01(){

        getBookingId();
        getToken();
        String payload_put= "{\n" +

                "      \"firstname\" : \"Sumit\",\n" +
                "       \"lastname\" : \"Verma\", \n" +
                "      \"totalprice\" : 502, \n" +
                "      \"depositpaid\" : false,\n" +
                "      \"bookingdates\" : {\n" +
                "  \"checkin\" : \"2024-01-01\",\n" +
                "      \"checkout\" : \"2024-01-01\" \n" +
                "  },\n" +

                "       \"additionalneeds\" : \"Lunch\" \n" +
                "}";

        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+ bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        requestSpecification.body(payload_put).log().all();

        response= requestSpecification.when().put();

        validatableResponse= response.then().log().all();
        validatableResponse.statusCode(200);




    }
    @Description ("to get the updated booking detail")
    @Test(dependsOnMethods = "testUpdateRequestPut01")
    public void testUpdateRequestget02(){


        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+ bookingID);
         response= requestSpecification.when().get();

        validatableResponse= response.then().log().all();
        validatableResponse.statusCode(200);

        String fName= response.jsonPath().getString("firstname");
        String lName= response.jsonPath().getString("lastname");
        Assert.assertEquals(fName, "Sumit");
        Assert.assertEquals(lName, "Verma");
     }
     @Description ("To delete the booking ")
    @Test(dependsOnMethods ="testUpdateRequestget02" )
       public void testDeleteBooking03(){

        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+ bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);

        response= requestSpecification.when().delete();

        validatableResponse= response.then().log().all();
        validatableResponse.statusCode(201);


    }
    @Description ("To fetch deleted booking id")
    @Test(dependsOnMethods = "testDeleteBooking03")
    public void testafterDeleteRequestget04(){
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+ bookingID);
        response= requestSpecification.when().get();

        validatableResponse= response.then().log().all();
        validatableResponse.statusCode(404);

        System.out.println(bookingID);

    }
// we can either set the priority or name the test as test01. test02 for the correct execution sequence
// also we can use depends upon method where one method execution depends on other.
// or in testNG file we can mention the method name to exlude/include in a sequence to be executed
}
