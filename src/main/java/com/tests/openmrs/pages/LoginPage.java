package com.tests.openmrs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="username")
    private WebElement username;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(id="Inpatient Ward")
    private WebElement location;

    @FindBy(id="loginButton")
    private WebElement loginButton;

    @FindBy(id="error-message")
    private WebElement errorMessage;

    public void loginInpatient(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        location.click();
        loginButton.click();
    }
    public String getErrorMessage(){
        return errorMessage.getText().trim();
    }
}
