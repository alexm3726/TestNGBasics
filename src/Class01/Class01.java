package Class01;

import org.testng.annotations.*;

public class Class01 {

    @BeforeTest
    public void beforeTestMethod(){
        System.out.println("I am before test");
    }
    @AfterTest
    public  void afterTest(){
        System.out.println("I am after test");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am before method function which will execute before every test");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after method function which will execute before every test");
    }

    @Test(groups = "sprint4")
    public void firstFunction(){
        System.out.println("I am first test");
    }
    @Test(groups = "sprint4")
    public void secondFunction(){
        System.out.println("I am second test");
    }
    @Test
    public void thirdFunction(){
        System.out.println("I am third test");
    }

}
