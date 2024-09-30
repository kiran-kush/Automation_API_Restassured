package RestassureHelloworld.RassuredAssured.CRUD.Example_22092024.POJO;

import io.restassured.RestAssured;

public class POJO001 {

    public static void main(String[] args) {
        // string payload- done
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

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us/")
                .basePath("IN/-1")
                .when()
                .log().all().get()
                .then()
                .log().all().statusCode(404);

    }


}
