package RestassureHelloworld.RassuredAssured.CRUD.Post_REQUEST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class BDD_Style_Post {

    // URL- post URL
    // Payload
//    {
//        "username" : "admin",
//            "password" : "password123"
//    }
    // Header- Content type- application/json
    @Description ("Verify the post request")
    @Test
    public void BddStyle_Post() {
           String payload= "{\n" +
                   "      \"username\": \"admin\",\n" +
                   "       \"password\" : \"password123\"\n" +

                   "}";

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON).log()
                .all().body(payload).when()
                .post().then().log().all()
                .statusCode(200);





    }


}
