package RestassureHelloworld.RassuredAssured.CRUD.Assestion;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.MatcherAssert.assertThat;

public class Test011 {
     RequestSpecification requestSpecification;
     Response response;
     ValidatableResponse validatableResponse;

    @Test
    public void create_Booking() {
         String token= "9872abb5e3b78f2";

        String payload_Post = "{\n" +

                "      \"firstname\" : \"John\",\n" +
                "       \"lastname\" : \"Jerry\", \n" +
                "      \"totalprice\" : 111, \n" +
                "      \"depositpaid\" : false,\n" +
                "      \"bookingdates\" : {\n" +
                "  \"checkin\" : \"2024-01-01\",\n" +
                "      \"checkout\" : \"2024-01-01\" \n" +
                "  },\n" +

                "       \"additionalneeds\" : \"Breakfast\" \n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        requestSpecification.body(payload_Post).log().all();

        response = requestSpecification.when().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("booking.firstname", Matchers.equalTo("Amit"));
        Assertions.assertThat("bookingId").isNotEmpty();
        Map<String, Integer> ages= new HashMap<>();
        ages.put("Varun", 25);
        ages.put("James", 30);
        Assertions.assertThat(ages).hasSize(2).containsEntry("Varun",25).isNotEmpty();

    }
}