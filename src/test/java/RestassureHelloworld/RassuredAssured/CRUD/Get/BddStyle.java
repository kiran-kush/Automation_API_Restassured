package RestassureHelloworld.RassuredAssured.CRUD.Get;

import io.restassured.RestAssured;

public class BddStyle {
    // given
    // base uri= https://api.zippopotam.us/
    // base path= "IN/110092"
     // when.log.all.get()
    // then. log.all.statuscode(201// )
    public static void main(String[] args) {

        test1();
        test2();

    }
        public static void test2(){

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us/")
                .basePath("IN/110092")
                .when()
                .log().all().get()
                .then()
                .log().all().statusCode(200);

        }

        public static void test1(){
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

