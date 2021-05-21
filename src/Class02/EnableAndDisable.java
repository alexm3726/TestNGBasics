package Class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EnableAndDisable {

    WebDriver driver;

    @Test(enabled = false)
    public void logOutMetghod(){
        System.out.println("This execution should come third");
    }
    @Test(priority = 1,enabled = false)
    public void logInMethod(){
        System.out.println("This execution should come first");
    }
    @Test(priority = 2, enabled = false)
    public void credentialsMethod(){
        System.out.println("This execution should come second");
    }

    @BeforeMethod
    public void openBrowserAndLaunchApp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();

        //launch the application
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void validLogin(){ /* WebElement username= driver.findElement(By.id("txtUsername"));
        username.sendKeys();
        username.clear();
        username.click();*/

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        WebElement welcomeAttribute = driver.findElement(By.xpath("//*[text()='Welcome Admin']"));
        if (welcomeAttribute.isDisplayed()) {
            System.out.println("Test is valid and Passed");
        } else {
            System.out.println("Test is failed");
        }
    }


    @Test(priority = 1, enabled = false)
    public void invalidLogin(){
       /* WebElement username= driver.findElement(By.id("txtUsername"));
        username.sendKeys();
        username.clear();
        username.click();*/

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        WebElement errorText=driver.findElement(By.xpath("//*[@id='spanMessage']"));

        String DisplayedText= errorText.getText();
        String expectedText= "Password cannot be empty";

        Assert.assertEquals(DisplayedText, expectedText);
        System.out.println("Test is valid and Passed and \""+DisplayedText+"\" is displayed");

       /* if(DisplayedText.equals(expectedText)){
            System.out.println("Test is valid and Passed and \""+DisplayedText+"\" is displayed");
        }else{
            System.out.println("Test is failed \""+DisplayedText+"\" is displayed");
        }*/
    }
    @Test(priority = 2,enabled = true, dependsOnMethods = "validLogin")
    public void validationOfTitle(){
        String expectedTitle="Human Management System";
        String actualTitle=driver.getTitle();
        if(expectedTitle.equals(actualTitle)){
            System.out.println("Test is final and title is same");
        }else{
            System.out.println("test is failed");
        }
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

