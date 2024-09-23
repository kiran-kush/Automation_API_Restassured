package RestassureHelloworld.RassuredAssured.CRUD.Post_REQUEST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Non_BDD_Style_Post {

    // URL- post URL
    // Payload
//    {
//        "username" : "admin",
//            "password" : "password123"
//    }
    // Header- Content type- application/json
    @Test
    public static void NonBdd() {
           String payload= "{\n" +
                   "      \"username\": \"admin\",\n" +
                   "       \"password\" : \"password123\"\n" +

                   "}";

                RequestSpecification r= RestAssured.given();
                r.baseUri("https://restful-booker.herokuapp.com");
                r.basePath("/auth");
                r.contentType(ContentType.JSON).log().all();
                r.body(payload);
                // preparing for request contain base uri, base path, content type and payload
                Response res= r.when().post();// making a request
                ValidatableResponse valires= res.then();
                        valires.statusCode(200); // validating the reponse





    }


}
