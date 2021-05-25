package Class02;

import org.testng.annotations.Test;

public class PriorityBatch9 {

    @Test(priority = 3)
    public void logOutMetghod(){
        System.out.println("This execution should come third");
    }
    @Test(priority = 1, groups = "smoke")
    public void logInMethod(){
        System.out.println("This execution should come first");
    }
    @Test(priority = 2,groups = "smoke")
    public void credentialsMethod(){
        System.out.println("This execution should come second");
    }
    @Test(priority = 4)
    public void enterInvalidCredentials(){
        System.out.println("This execution should come fourth");
    }
    @Test(priority = 5)
    public void anotherTestMethod(){
        System.out.println("This execution should come at the end");
    }
}
