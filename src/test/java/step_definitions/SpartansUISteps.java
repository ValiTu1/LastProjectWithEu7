package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.SpartanMainPage;
import pages.SpartanViewPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class SpartansUISteps {

    @Given("Commander is at the main page")
    public void commander_is_at_the_main_page() {
        Driver.get().get(ConfigurationReader.get("spartan.webUrl"));
    }
    @When("Commander clicks on view button with the ID number {string}")
    public void commander_clicks_on_view_button_with_the_id_number(String id) {
            new SpartanMainPage().getSpartanView(id).click();
    }
    @Then("Verifies the name of the spartan is {string}")
    public void verifies_the_name_of_the_spartan_is(String expectedName) {
            String actualName = new SpartanViewPage().getValue("name");
        Assert.assertEquals(expectedName, actualName);
    }
}
