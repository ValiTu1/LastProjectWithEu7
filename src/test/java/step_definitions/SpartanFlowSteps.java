package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.junit.Assert.*;
import pages.pojo.Spartan;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.*;

public class SpartanFlowSteps {

    String spartanUrl  = ConfigurationReader.get("spartan.apiUrl");
    String mockUrl = ConfigurationReader.get("mock.apiUrl");
    Response mockSpartanJSON;
    Response postResponse;
    Response getResponse;
    Spartan mySpartan;

    @Given("user sends a request to Mock API for mock Spartan Data")
    public void userSendsARequestToMockAPIForMockSpartanData() {
         mockSpartanJSON = given().accept(ContentType.JSON)
                .and().header("X-Api-Key", "2b113750")// I am sending authorization with headers
                .when().get(mockUrl);
        assertEquals(200, mockSpartanJSON.statusCode());
    }

    @When("User uses Mock Data to create a Spartan")
    public void userUsesMockDataToCreateASpartan() {
        mySpartan = new Spartan();
        mySpartan.setName(mockSpartanJSON.path("name"));
        mySpartan.setGender(mockSpartanJSON.path("gender"));
        Long phone = Long.valueOf(mockSpartanJSON.path("phone").toString());
        mySpartan.setPhone(phone);

        System.out.println("mySpartan.toString() = " + mySpartan);

        postResponse = given().accept(ContentType.JSON)// I want JSON response
                .contentType(ContentType.JSON)//I send JSON body
                .and().body(mySpartan)//serialize from JAVA to JSON
                .when().post(spartanUrl + "/api/spartans");

        postResponse.prettyPrint();
        assertEquals(201, postResponse.statusCode());


    }

    @When("Users send a request to Spartan API id {int}")
    public void users_send_a_request_to_spartan_api_id(int id) {
        if(id==0){
            id = postResponse.path("data.id");

        }
        getResponse = given().accept(ContentType.JSON)
                .and().pathParam("id", id)
                .when().get(spartanUrl + "/api/spartans/{id}");
        assertEquals(200, getResponse.statusCode());
    }

    @Then("Created Spartan has the same information with POST request")
    public void createdSpartanHasTheSameInformationWithPOSTRequest() {
        String expectedName = postResponse.path("data.name");
        String actualName = getResponse.path("name");

        assertEquals(expectedName, actualName);

    }

    @And("User Updates all the fields of created Spartan")
    public void userUpdatesAllTheFieldsOfCreatedSpartan() {
        mySpartan.setName("Oscar");
        mySpartan.setGender("Male");
        mySpartan.setPhone(55512356L);
        Response putResponse = given().accept(ContentType.JSON)
                .and().pathParam("id", postResponse.path("data.id"))
                .and().body(mySpartan)
                .when().put(spartanUrl + "/api/spartans/{id}");

        assertEquals(204, putResponse.statusCode());
    }
}
