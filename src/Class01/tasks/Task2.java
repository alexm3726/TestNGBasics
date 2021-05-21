package Class01.tasks;

import org.testng.annotations.*;

public class Task2 {
    @BeforeClass
    public void beforeTest(){
        System.out.println("Before class");
    }
    @AfterClass
    public void afterTest(){
        System.out.println("After class");
    }
    @BeforeMethod
    public void beforeMethodTest(){
        System.out.println("before every single test");
    }
    @AfterMethod
    public void afterMethodTest(){
        System.out.println("after every single test");
    }

    @Test
    public void firstTest(){
        System.out.println("I am the first");
    }

    @Test
    public void secondTest(){
        System.out.println("I am the second");
    }

}
