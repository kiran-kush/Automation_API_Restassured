package TestNG_Examples;

import org.testng.annotations.Test;

public class TestNG05 {

    @Test(priority = 1)
    public void testPUT_Req1() {
        System.out.println("1");
    }

@Test(priority = 0)
    public void testPUT_Req2() {
        System.out.println("2");
    }
    @Test(priority = 2)
    public void testPUT_Req3() {
        System.out.println("3");
    }
}


