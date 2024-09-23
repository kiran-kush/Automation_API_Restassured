package TestNG_Examples;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.*;

public class TestNG01 {
    @Severity( SeverityLevel.NORMAL)
    @Description ("This is test")
    @BeforeSuite
    void demo1(){

        System.out.println("before suit");
    }
    @Severity(SeverityLevel.NORMAL)
    @Description ("This is test")
    @BeforeMethod
    void demo4(){

        System.out.println("this is before method");
    }

    @Test
    void test1(){

        System.out.println("test1");
    }

    @Test

    void test2(){

        System.out.println("test2");
    }

    @AfterMethod
    void demo6(){

        System.out.println("this is after method");
    }

    @AfterSuite
    void demo9(){

        System.out.println("this is after suit");
    }

}
