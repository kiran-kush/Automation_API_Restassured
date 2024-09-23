package TestNG_Examples;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG03 {

    String token;
    String Bookingid;

    @BeforeTest
    public String get_Token(){
        token= "123";
        return  token;

    }
    @BeforeTest
    public void get_bookingidAndToken(){
          token= get_Token();
          Bookingid= "123";
        }
    @Test
    public void testPUT_Req1(){
        System.out.println(token);
        System.out.println(Bookingid);

    } @Test
    public void testPUT_Req2(){
        System.out.println(token);
        System.out.println(Bookingid);

    } @Test
    public void testPUT_Req3(){
        System.out.println(token);
        System.out.println(Bookingid);

    }
}
