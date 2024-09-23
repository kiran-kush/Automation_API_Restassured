package TestNG_Examples;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG02 {

    @Severity(SeverityLevel.NORMAL)
    @Description ("this is to test test1")
    @Test
    void test1(){

        System.out.println("test1");

    }
         @Severity(SeverityLevel.NORMAL)
         @Test
        void test2(){// this will be ignored by testng and never be used

        System.out.println("test2");
    }

    String name= "Kiran";
    SoftAssert softAssert= new SoftAssert();




}
