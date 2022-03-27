package step_definitions;

import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class SpartanFlowSteps {


    @When("Users send a request to Spartan API id {int}")
    public void users_send_a_request_to_spartan_api_id(int id) {

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", id)
                .when().get("/api/spartans/{id}");

        response.prettyPrint();

    }
}
