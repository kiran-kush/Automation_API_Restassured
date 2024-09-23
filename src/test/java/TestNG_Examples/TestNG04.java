package TestNG_Examples;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG04 {

    @BeforeTest
    public void get_booking() {
        System.out.println("1");
    }

    @BeforeTest
    public void get_bookingid() {
        System.out.println("2");
    }

    @Test
    public void testPUT_Req1() {
        System.out.println("3");
    }
}