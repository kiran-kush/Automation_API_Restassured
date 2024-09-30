package TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG09 {

    @Test
    public void tes1(){

        System.out.println("test1");
        Assert.assertTrue(true);
    }
    @Test(enabled = false)
     void test2(){

        System.out.println("test2");
        Assert.assertTrue(false);
    }
    @Test
     void test3(){

        System.out.println("test3");
        Assert.assertTrue(true);
    }

}
