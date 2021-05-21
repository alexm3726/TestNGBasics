package Class02.HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Task {
    /*
     HRMS Add Employee:
        Open chrome browser
        Go to “http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login”
        Login into the application
        Click on Add Employee
        Verify labels: Full Name, Employee Id, Photograph are displayed
        Provide Employee First and Last Name
        Add a picture to the profile
        Verify Employee has been added successfully
        Close the browser
    */
    WebDriver driver;
    String url= "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
    @BeforeMethod
    public void browserLaunch(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void LogIn(){
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("logged In");
    }

    @Test(dependsOnMethods = "LogIn")
    public void addEmployee(){
        LogIn();
        WebElement PIM= driver.findElement(By.id("menu_pim_viewPimModule"));
        Actions actions= new Actions(driver);
        actions.moveToElement(PIM).perform();
        System.out.println("hovering baby");
        WebElement addEmp= driver.findElement(By.linkText("Add Employee"));
        actions.click(addEmp).perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement fullName= driver.findElement(By.xpath("//*[text()='Full Name']"));
        WebElement empID= driver.findElement(By.xpath("//*[@for='employeeId']"));
        WebElement pic= driver.findElement(By.xpath("//*[@for='photofile']"));
        Assert.assertTrue(fullName.isDisplayed() && empID.isDisplayed() && pic.isDisplayed());
        System.out.println("verified");
        driver.findElement(By.name("firstName")).sendKeys("I");
        driver.findElement(By.name("middleName")).sendKeys("Am");
        driver.findElement(By.name("lastName")).sendKeys("Lord Voldemort");
        driver.findElement(By.id("photofile")).sendKeys("/Users/alex/Downloads/IAMLORDVOLDEMORT.png");
        driver.findElement(By.id("btnSave")).click();
        WebElement personalDetails= driver.findElement(By.className("personalDetails"));
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertTrue(personalDetails.isDisplayed());
        softAssert.assertAll();



    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}
