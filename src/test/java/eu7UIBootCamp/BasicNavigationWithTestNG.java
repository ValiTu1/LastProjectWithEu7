package eu7UIBootCamp;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class BasicNavigationWithTestNG {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.get("webTable.url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDOwn(){
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {


        //there are some other methods that we can use that are not covered in teh class
        //System.out.println("driver.findElement(By.name(\"username\")).getLocation() = " + driver.findElement(By.name("username")).getLocation());

        //size of the web element
        //System.out.println(driver.findElement(By.name("username")).getSize());

        //to send some value to the webpage we use .sendKeys()
        driver.findElement(By.name("username")).sendKeys(ConfigurationReader.get("web.table.username"));
        driver.findElement(By.name("password")).sendKeys(ConfigurationReader.get("web.table.password"));
        driver.findElement(By.xpath("//button[.='Login']")).click();

        String expectedUrl = "https://web-table-2.cydeo.com/orders";
        String actualUrl = driver.getCurrentUrl();

        Thread.sleep(2);
        assertEquals(actualUrl, expectedUrl, "Url is not as expected");

    }


    @Test
    public void Test2(){
        //Test Scenario: Check the order of WebElement boxes UserName-> Password
        Point locationUsernameBox = loginPage.usernameBox.getLocation();
        int yCoordinateOfUsernameBox = locationUsernameBox.getY();

        int yCoordinateOfPasswordBox = loginPage.passwordBox.getLocation().getY();
        int yCoordinateOfButton = loginPage.button.getLocation().getY();

        assertTrue(yCoordinateOfUsernameBox< yCoordinateOfPasswordBox);
        assertTrue(yCoordinateOfPasswordBox < yCoordinateOfButton);

    }
}
