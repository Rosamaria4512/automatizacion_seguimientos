package com.co.izy.stepsdefinitions;

import com.co.izy.models.Credentials;
import com.co.izy.tasks.LoginTaskCorrect;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class LoginStepDefintion {

    @Managed
    WebDriver hisBroswer;

    @Before
    public void setUp() {
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("User");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(hisBroswer));

    }


    @Given("^that enter to the website$")
    public void thatEnterToTheWebsite() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://seguimientos.cloudsenactpi.net/#/public"));

    }

    @When("^he enter the correct credentials$")
    public void heEnterTheCorrectCredentials(List<Credentials> credentialsList) {
        Credentials credentials;
        credentials = credentialsList.get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(LoginTaskCorrect.inThePage(credentials));

    }

    @Then("^he will login correctly$")
    public void heWillLoginCorrectly() {


    }
}
