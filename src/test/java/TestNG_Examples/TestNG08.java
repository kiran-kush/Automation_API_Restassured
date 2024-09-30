package TestNG_Examples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG08 {

    @Parameters ("browser")
    @Test
    void demo(String value ){

        System.out.println("browser is:"+ value);
    }
}
