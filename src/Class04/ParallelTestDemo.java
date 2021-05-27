package Class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.CommonMethods;

import java.util.concurrent.TimeUnit;

public class ParallelTestDemo extends CommonMethods {

    @Test
    public void validLogin(){

        driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        WebElement welcomeAttribute=driver.findElement(By.xpath("//*[text()='Welcome Admin']"));
        if(welcomeAttribute.isDisplayed()){
            System.out.println("Test is valid and Passed");
        }else{
            System.out.println("Test is failed");
        }
    }

    @Test
    public void validationOfTitle(){
        String expectedTitle="Human Management System";//failed on purpose
        String actualTitle=driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);
        if(expectedTitle.equals(actualTitle)){
            System.out.println("Test is final and title is same");
        }else{
            System.out.println("test is failed");
        }
    }

}
