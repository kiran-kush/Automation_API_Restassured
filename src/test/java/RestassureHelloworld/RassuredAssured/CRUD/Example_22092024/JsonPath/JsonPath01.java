package RestassureHelloworld.RassuredAssured.CRUD.Example_22092024.JsonPath;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.assertj.core.api.Assertions.*;
import org.testng.annotations.Test;

public class JsonPath01 {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    @Test
    public void verify_JsonPath(){
        String payload_Post= "{\n" +

                "      \"firstname\" : \"Henry\",\n" +
                "       \"lastname\" : \"Jerry\", \n" +
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
        requestSpecification.body(payload_Post).log().all();

        response= requestSpecification.when().post();
        System.out.println(response.asString());
        JsonPath jsonpath= new JsonPath(response.asString());

        String bookingid= jsonpath.getString("bookingid");
        String name= jsonpath.getString("booking.firstname");
        String totalprice= jsonpath.getString("booking.totalprice");
        System.out.println(bookingid);
        System.out.println(name);
        System.out.println(totalprice);

        assertThat(bookingid).isEqualTo("3581").isNotEmpty().isNotNull();
        assertThat(name).isEqualTo("Henry").isNotEmpty();



    }
}
