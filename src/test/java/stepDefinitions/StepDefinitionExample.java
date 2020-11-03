package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class StepDefinitionExample {

    @Given("^User is on landing page$")
    public void user_is_on_landing_page() throws Throwable {
        //get landing page
        System.out.println("Navigated to Login url");
    }

    @When("^User login into application with \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_login_into_application_with_and_password(String arg1, String arg2) throws Throwable {
        System.out.println("User logged in with username: " + arg1);
    }

    @Then("^Home page is populated$")
    public void home_page_is_populated() throws Throwable {
        //home page is populated
        System.out.println("Main page is populated");
    }

    @Then("^Cards are displayed are \"([^\"]*)\"$")
    public void cards_are_displayed_are(String arg1) throws Throwable {
        System.out.println("Cards are displayed: " + arg1);
    }
}
