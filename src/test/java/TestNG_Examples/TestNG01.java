package TestNG_Examples;

import org.testng.annotations.*;

public class TestNG01 {

    @BeforeSuite
    void demo1(){

        System.out.println("before suit");
    }
    @BeforeMethod
    void demo4(){

        System.out.println("this is before method");
    }
    @Test
    void test1(){

        System.out.println("test1");
    } @Test
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
