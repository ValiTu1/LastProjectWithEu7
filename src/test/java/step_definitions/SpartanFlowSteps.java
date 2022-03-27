package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pages.pojo.Spartan;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.*;

public class SpartanFlowSteps {

    String spartanUrl  = ConfigurationReader.get("spartan.apiUrl");
    String mockUrl = ConfigurationReader.get("mock.apiUrl");
    Response mockSpartanJSON;
    Response postResponse;


    @Given("user sends a request to Mock API for mock Spartan Data")
    public void userSendsARequestToMockAPIForMockSpartanData() {
         mockSpartanJSON = given().accept(ContentType.JSON)
                .and().header("X-Api-Key", "2b113750")
                .when().get(mockUrl);
    }

    @When("User uses Mock Data to create a Spartan")
    public void userUsesMockDataToCreateASpartan() {
        Spartan mySpartan = new Spartan();
        mySpartan.setName(mockSpartanJSON.path("name"));
        mySpartan.setGender(mockSpartanJSON.path("gender"));
        Long phone = Long.valueOf(mockSpartanJSON.path("phone").toString());
        mySpartan.setPhone(phone);

        System.out.println("mySpartan.toString() = " + mySpartan);

        postResponse = given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)// I want JSON response
                .and().body(mySpartan)
                .when().post(spartanUrl + "/api/spartans");

        postResponse.prettyPrint();


    }

    @When("Users send a request to Spartan API id {int}")
    public void users_send_a_request_to_spartan_api_id(int id) {

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", id)
                .when().get(spartanUrl + "/api/spartans/{id}");

        //response.prettyPrint();

    }
}
