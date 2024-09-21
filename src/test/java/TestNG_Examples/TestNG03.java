package TestNG_Examples;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG03 {

    @Test
    void test1(){

        System.out.println("test1");
    }
        void test2(){// this will be ignored by testng and never be used

        System.out.println("test2");
    }

    String name= "Kiran";
    SoftAssert softAssert= new SoftAssert();




}
