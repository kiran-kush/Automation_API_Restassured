package RestassureHelloworld.RassuredAssured.CRUD.Post_REQUEST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ra_Post_Non_BDD {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @BeforeTest
    public void prePostRequest(){

        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
    }
    @Test
    public void PostRequest1() {
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
    }

    @Test
    public void PostRequest2() {// nagative test case with
        String payload= "{\n"  +
                "      \"username\": \"admin2\",\n" +
                "       \"password\" : \"password1234\"\n" +

                "}";
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);
        requestSpecification.post();
        response= requestSpecification.post();
        String responseString= response.asString();
        System.out.println(responseString);
        validatableResponse= response.then();
        validatableResponse.statusCode(404);

    }
}
