package TestNG_Examples;

import org.testng.annotations.*;

public class All_Annotations {

    @BeforeSuite
    void demo1(){

        System.out.println("this is before suit");
    }
    @BeforeTest
    void demo2(){

        System.out.println("this is before test");
    }
    @BeforeClass
    void demo3(){

        System.out.println("this is before class");
    }
    @BeforeMethod
    void demo4(){

        System.out.println("this is before method");
    }
    @Test
    void demo5(){

        System.out.println("this is test");
    }
    @AfterMethod
    void demo6(){

        System.out.println("this is after method");
    }
    @AfterClass
    void demo7(){

        System.out.println("this is After class");
    }
    @AfterTest
    void demo8(){

        System.out.println("this is after test");
    }
    @AfterSuite
    void demo9(){

        System.out.println("this is after suit");
    }
}
