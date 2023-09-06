package com.co.seguimietos.stepsdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.LoginCredentials;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import tasks.LoginTaskCorrect;

import java.util.List;

public class LoginStepDefiniton {

    @Managed
    WebDriver hisBroswer;

    @Before
    public void setUp()
    {
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("User");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(hisBroswer));

    }

    @Given("^that enter to the website$")
    public void thatEnterToTheWebsite() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://seguimientos.cloudsenactpi.net/#/public"));
    }


    @When("^he enter the correct credentials$")
    public void heEnterTheCorrectCredentials(List<LoginCredentials> credentialsList) {
        LoginCredentials datacredentials;
        datacredentials=credentialsList.get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(LoginTaskCorrect.inThePage(datacredentials));

    }

    @Then("^he will login correctly$")
    public void heWillLoginCorrectly() {

    }
}
