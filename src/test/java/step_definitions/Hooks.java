package step_definitions;

import io.cucumber.java.Before;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.*;

public class Hooks {

    @Before
    public void setUpTest(){
        baseURI = ConfigurationReader.get("spartan.apiUrl");
    }
}
