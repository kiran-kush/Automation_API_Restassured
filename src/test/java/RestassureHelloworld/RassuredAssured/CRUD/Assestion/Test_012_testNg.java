package RestassureHelloworld.RassuredAssured.CRUD.Assestion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static org.assertj.core.api.Assertions.*;
public class Test_012_testNg {

//    @Test
//    public void hardassert_Example(){
//
//        Assert.assertTrue(false);
//        System.out.println("This will not be executed");
//    }
    @Test
    public void softassert_Example(){

        SoftAssert softAssert= new SoftAssert();
        softAssert.assertTrue(false);
        System.out.println("This will always be executed with soft assert");
    }


}
