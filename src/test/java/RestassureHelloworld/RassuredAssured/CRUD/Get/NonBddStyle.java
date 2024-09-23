package RestassureHelloworld.RassuredAssured.CRUD.Get;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBddStyle {

    static RequestSpecification r= RestAssured.given();

    public static void main(String[] args) {

        r.baseUri("https://api.zippopotam.us");
        test1();
        test2();
    }
    public static void test1(){
        r.basePath("/IN/110092");
        r.when().get();
        r.then().log().all().statusCode(200);

    }
    public static void test2(){
        r.basePath("/IN/-1");
        r.when().get();
        r.then().log().all().statusCode(4004);
    }

}
