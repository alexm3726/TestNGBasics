package Class01.tasks;

import org.testng.annotations.*;

public class Task1 {

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before test case");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After test case");
    }
    @BeforeMethod
    public void beforeMethodTest(){
        System.out.println("before every single test");
    }
    @AfterMethod
    public void afterMethodTest(){
        System.out.println("after every single test");
    }

    @Test(groups = "sprint4")
    public void firstTest(){
        System.out.println("I am the first");
    }

    @Test(groups = "sprint4")
    public void secondTest(){
        System.out.println("I am the second");
    }

    @Test
    public void thirdTest(){
        System.out.println("I am the third");
    }
}
