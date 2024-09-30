package TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class TestNG06 {

    @Test(groups = {"sanity", "QA"})
    public void sanityRun(){

        System.out.println("Sanity");
        System.out.println("QA");
    }
    @Test(groups = {"PreProd"})
    public void Regrun(){
       System.out.println("Reg");
    }
    @Test(groups = {"Dev"})
    public void smokerun(){
        System.out.println("smoke");
        Assert.assertTrue(false);
    }
}
