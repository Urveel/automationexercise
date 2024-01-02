package com.automationexercise.steps;

import com.automationexercise.pages.LoginPage;
import io.cucumber.java.en.And;
import org.testng.Assert;

public class LoginUserSteps {
    @And("Verify {string} is visible")
    public void verifyIsVisible(String verifyText) {
        Assert.assertEquals(new LoginPage().getTextLoginToYourAccount(), verifyText, "'Login to your account' text is not visible");
    }

    @And("I enter email: {string} and password: {string}")
    public void iEnterEmailAndPassword(String userName, String password) {
        new LoginPage().enterEmailAndPassword(userName, password);
    }

    @And("I click {string} button")
    public void iClickButton(String btnText) {
        new LoginPage().clickOnLoginBtn();
    }

    @And("Verify that user is navigated to login page")
    public void verifyThatUserIsNavigatedToLoginPage() {
        Assert.assertEquals("https://automationexercise.com/login", getClass());
    }
}
