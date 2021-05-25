package Class03.HW;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Adding5Emp {

    WebDriver driver;
    @DataProvider
    public Object[][] names(){
        Object[][] names= new Object[5][4];
        names[0][0]= "Potato1";
        names[0][1]= "Barbs";
        names[0][2]= "Potato1";
        names[0][3]= "jOsh1$$gh";

        names[1][0]= "Potato12";
        names[1][1]= "Maryys";
        names[1][2]= "Potato12";
        names[1][3]= "Bill2$gh";

        names[2][0]= "Potato123";
        names[2][1]= "Georgess";
        names[2][2]= "Potato123";
        names[2][3]= "Jupiter!$gh456W";

        names[3][0]= "Potato1234";
        names[3][1]= "Russels";
        names[3][2]= "Potato1234";
        names[3][3]= "Macc1$$gh";

        names[4][0]= "Potato12345";
        names[4][1]= "Zions";
        names[4][2]= "Potato12345";
        names[4][3]= "Salmon1!G$YZ";


        return names;
    }
    @DataProvider
    public Object[][] loginData(){
        Object[][] data= new Object[5][2];
        data[0][0]= "Potato1";
        data[0][1]= "jOsh1$$gh";
        data[1][0]= "Potato12";
        data[1][1]= "Bill2$gh";
        data[2][0]= "Potato123";
        data[2][1]= "Jupiter!$gh456W";
        data[3][0]= "Potato1234";
        data[3][1]= "Macc1$$gh";
        data[4][0]= "Potato12345";
        data[4][1]= "Salmon1!G$YZ";

        return data;
    }


    @BeforeMethod(alwaysRun = true)
    public void openBrowserAndLaunchApp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();

        //launch the application
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void login(){
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @Test(groups = "bacon",dataProvider = "names")
    public void addEmployees(String firstName, String lastName, String username, String password) {
        login();
        WebElement PIM= driver.findElement(By.id("menu_pim_viewPimModule"));
        Actions actions= new Actions(driver);
        actions.moveToElement(PIM).perform();
        WebElement addEmp= driver.findElement(By.linkText("Add Employee"));
        actions.click(addEmp).perform();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.name("firstName")).sendKeys(firstName);
        driver.findElement(By.name("lastName")).sendKeys(lastName);

        driver.findElement(By.id("chkLogin")).click();
        driver.findElement(By.name("user_name")).sendKeys(username);
        driver.findElement(By.id("user_password")).sendKeys(password);
        driver.findElement(By.id("re_password")).sendKeys(password);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("welcome")).click();
        driver.findElement(By.linkText("Logout")).click();



    }
    @Test(dependsOnMethods = "addEmployees",groups = "bacon",dataProvider = "loginData")
    public void validLogin(String username, String password){

        driver.findElement(By.id("txtUsername")).sendKeys(username);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        TakesScreenshot ts= (TakesScreenshot) driver;
        File sourceFile= ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile, new File("screenshots/AddEmployeesHW/Login"+username+".png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
