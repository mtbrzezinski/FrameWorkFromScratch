package com.tests.openmrs.stepdefinitions;

import com.tests.openmrs.pages.LoginPage;
import com.tests.openmrs.utils.ConfigReader;
import com.tests.openmrs.utils.DriverHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class LoginFunctionality_StepDef {
    WebDriver driver=DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    @Given("User navigates to the OpenMrs website and provides credentials")
    public void user_navigates_to_the_open_mrs_website_and_provides_credentials() {
    loginPage.loginInpatient(ConfigReader.readProperty("QA_username"),
                             ConfigReader.readProperty("QA_password"));
    }
    @Then("User validates tittle {string} and url {string}")
    public void user_validates_tittle_and_url(String title, String url) {
        Assert.assertEquals(title, driver.getTitle().trim());
        Assert.assertEquals(url, driver.getCurrentUrl().trim());

    }

    @Given("User navigates to the OpenMrs website and provides credentials {string} and {string}")
    public void user_navigates_to_the_open_mrs_website_and_provides_credentials_and(String username, String password) {
    loginPage.loginInpatient(username, password);
    }
    @Then("User validates the message {string}")
    public void user_validates_the_message(String message) {
        Assert.assertEquals(message, loginPage.getErrorMessage());

    }


}
