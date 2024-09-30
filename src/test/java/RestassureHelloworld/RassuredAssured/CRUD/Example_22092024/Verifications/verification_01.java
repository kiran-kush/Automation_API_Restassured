package RestassureHelloworld.RassuredAssured.CRUD.Example_22092024.Verifications;

import org.testng.Assert;
import org.testng.annotations.Test;

public class verification_01 {

    @Test
    public void test_verify_response(){

                String response= "Andrew";
        Assert.assertEquals("Andrew",response);


    }
}
