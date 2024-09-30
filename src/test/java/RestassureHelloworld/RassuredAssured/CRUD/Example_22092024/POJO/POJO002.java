package RestassureHelloworld.RassuredAssured.CRUD.Example_22092024.POJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class POJO002 {


        RequestSpecification requestSpecification;
        ValidatableResponse validatableResponse;
        Response response;
         String token;
         String bookingId;

        @Test
        public void test_post_with_hashmap() {

            // {
            //    "firstname" : "sally",
            //    "lastname" : "brown",
            //    "totalprice" : 111,
            //    "depositpaid" : true,
            //    "bookingdates" : {
            //        "checkin" : "2018-01-01",
            //        "checkout" : "2019-01-01"
            //    },
            //    "additionalneeds" : "Breakfast"
            //}

            // Hashmap ->
            // {} - map
            Map<String, Object> jsonBodyUsingMap= new LinkedHashMap<>();
            jsonBodyUsingMap.put("firstName", "sally");
            jsonBodyUsingMap.put("lastName", "brown");
            jsonBodyUsingMap.put("totalprice", "111");
            jsonBodyUsingMap.put("depositepaid", "true");

            Map<String, Object> bookingDatesMap= new LinkedHashMap<>();

            bookingDatesMap.put("checkin", "2018-01-01");
            bookingDatesMap.put("checkout", "2019-01-01");
            jsonBodyUsingMap.put("bookingdates",bookingDatesMap);
            jsonBodyUsingMap.put("additionalneeds", "Breakfast");
            System.out.println(jsonBodyUsingMap);

            requestSpecification= RestAssured.given();
            requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
            requestSpecification.basePath("/booking/");
            requestSpecification.contentType(ContentType.JSON);
            requestSpecification.body(jsonBodyUsingMap).log().all();

            response= requestSpecification.when().post();

            validatableResponse= response.then().log().all();
            validatableResponse.statusCode(200);
            bookingId= response.jsonPath().getString("bookingid");




        }
    }
