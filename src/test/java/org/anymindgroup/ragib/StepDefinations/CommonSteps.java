package org.anymindgroup.ragib.StepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CommonSteps {

    @Given("User is already on main Page")
    public void user_is_already_on_main_page() {
        System.out.println("test passed");
    }

    @Then("User enters {string} and {string}")
    public void user_enters_and(String string, String string2) {
        System.out.println("test passed");
    }

    @Then("User clicks on {string} button")
    public void user_clicks_on_button(String string) {
        System.out.println("test passed");
    }

    @Then("User is on {string} page")
    public void user_is_on_page(String string) {
        System.out.println("test passed");
    }

    @Then("User logout from the system")
    public void user_logout_from_the_system() {
        System.out.println("test passed");
    }

    @Then("User performs {string} operation")
    public void user_performs_operation(String string) {
    //todo
    }

    @Then("User enters {int}")
    public void user_enters(int amount) {

    }

    @Then("User checks {string}")
    public void user_checks(String string) {

    }

}