package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.ConfigurationReader;
import utilities.Driver;

import static io.restassured.RestAssured.*;

public class Hooks {

   /* @Before(order = 0)
    public void setUpTest(){
        baseURI = ConfigurationReader.get("spartan.apiUrl");
    }*/

    /*@Before(order = 1)
    public void setUpTest(){
        baseURI = ConfigurationReader.get("spartan.apiUrl");
    }*/

    @Before
    public void setUp(){
        System.out.println("SOme methods before Test Cases");
    }

    @After
    public void tearDown(){
        Driver.closeDriver();
    }
}
