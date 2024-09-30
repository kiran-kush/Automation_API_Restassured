package TestNG_Examples;

import org.testng.annotations.Test;

public class TestNg07 {

     @Test
    public void serverstartedOK(){

        System.out.println("Server_Statred_Ok");


    }
    @Test(dependsOnMethods = "serverstartedOK")
    public void test1(){

        System.out.println("method_1");
    }
}
