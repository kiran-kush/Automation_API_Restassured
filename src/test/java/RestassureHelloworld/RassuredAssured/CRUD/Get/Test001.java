package RestassureHelloworld.RassuredAssured.CRUD.Get;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Test001 {

    @Test
    public void get(){
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us/")
                .basePath("IN/110092")
                .when()
                .log().all().get()
                .then()
                .log().all().statusCode(200);



    }
}
