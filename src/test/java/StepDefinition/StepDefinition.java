package StepDefinition;

import cucumber.api.junit.Cucumber;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class StepDefinition {

    @Given("^User is on landing page$")
    public void user_is_on_landing_page() throws Throwable {
        //get landing page
        System.out.println("Navigated to Login url");
    }

    @When("^User login into application with username and password$")
    public void user_login_into_application_with_username_and_password() throws Throwable {
        //login with user and pass
        System.out.println("logged in successfully");
    }

    @Then("^Home page is populated$")
    public void home_page_is_populated() throws Throwable {
        //home page is populated
        System.out.println("Main page is populated");
    }

    @And("^Cards are displayed$")
    public void cards_are_displayed() throws Throwable {
        //cards displayed
        System.out.println("Validated cards");
    }
}
