package TestNG_Examples;

import io.qameta.allure.Description;
import org.testng.annotations.*;

public class TestNG01 {
    @Description
    @BeforeSuite
    void demo1(){

        System.out.println("before suit");
    }
    @Description
    @BeforeMethod
    void demo4(){

        System.out.println("this is before method");
    }
    @Description
    @Test
    void test1(){

        System.out.println("test1");
    }
    @Description("this for test")
    @Test

    void test2(){

        System.out.println("test2");
    }
    @Description
    @AfterMethod
    void demo6(){

        System.out.println("this is after method");
    }
    @Description
    @AfterSuite
    void demo9(){

        System.out.println("this is after suit");
    }

}
