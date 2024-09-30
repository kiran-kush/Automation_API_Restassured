package RestassureHelloworld.RassuredAssured.CRUD.Example_22092024.gsonSerialization;

import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class GsonDeSerialization {

    @Description("TC#1 - Verify that create booking is working with valid payload")
    @Test
    public void testNonBDDStylePOSTPositive() {
        RequestSpecification r = RestAssured
                .given();

        Response response;

        ValidatableResponse validatableResponse;


        Booking booking = new Booking();
        booking.setFirstname("James");
        booking.setLastname("Brown");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);
      //   Java Object -> JSON String (byteStream) - Serlization
        Gson gson = new Gson();
        String jsonStringpayload = gson.toJson(booking);
        System.out.println(jsonStringpayload);




          String BASE_URL = "https://restful-booker.herokuapp.com";
          String BASE_PATH = "/booking";

         r.baseUri(BASE_URL);
         r.basePath(BASE_PATH);
         r.contentType(ContentType.JSON).log().all();
         r.body(jsonStringpayload);

         response = r.when().log().all().post();
         String responseString = response.asString();
         System.out.println(responseString);


         validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Parse - DeSerilization
        BookingResponse bookingResponse= gson.fromJson(responseString, BookingResponse.class);
        System.out.println(bookingResponse.getbookingid());
        System.out.println(bookingResponse.getBooking().getFirstname());
        System.out.println(bookingResponse.getBooking().getLastname());
        System.out.println(bookingResponse.getBooking().getLastname());
        System.out.println(bookingResponse.getBooking().getTotalprice());
        System.out.println(bookingResponse.getBooking().getAdditionalneeds());
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("James").isNotEmpty().isNotEmpty();






    }



}
