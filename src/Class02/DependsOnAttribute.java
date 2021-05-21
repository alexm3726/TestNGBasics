package Class02;

import org.testng.annotations.Test;

public class DependsOnAttribute {
    @Test
    public void launchAppTest(){
        System.out.println("This is my login test");
    }
    @Test(dependsOnMethods = "launchAppTest")
    public void enterCredentials(){
        System.out.println("This is my dependent method");
    }
}
