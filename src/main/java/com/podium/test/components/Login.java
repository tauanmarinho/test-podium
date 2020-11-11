package com.podium.test.components;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BaseWebComponent {

    @FindBy(css = "input[type='password']")
    private WebElement passwordHideText;

    @FindBy(css = "input[type='text']")
    private WebElement passwordShowText;

    @FindBy(xpath = "//*[contains(text(), 'Email or mobile number')]")
    private WebElement emailOrPhoneText;

    @FindBy(xpath = "//*[contains(text(), 'Invalid email address')]")
    private WebElement invalidEmailAddressText;

    @FindBy(id = "forgotPasswordText")
    private WebElement forgotPasswordButton;

    @FindBy(id = "signInButton")
    private WebElement nextSignInButton;

    @FindBy(xpath = "//*[contains(text(), 'Next')]")
    private WebElement nextButton;

    @FindBy(xpath = "//*[contains(text(), 'Show')]")
    private WebElement showButton;

    @FindBy(xpath = "//*[contains(text(), 'Hide')]")
    private WebElement hideButton;

    @FindBy(xpath = "//*[contains(text(), 'Sign in')]")
    private WebElement signInButton;

    @FindBy(xpath = "//*[contains(text(), 'Password')]")
    private WebElement passwordText;

    @FindBy(xpath = "//*[contains(text(), 'Password is required')]")
    private WebElement passwordRequiredText;

    @FindBy(id = "passwordInput")
    private WebElement passwordInput;

    @FindBy(id = "emailOrPhoneInput")
    private WebElement emailOrPhoneInput;

    protected Login(WebDriver webDriver) {
        super(webDriver);
    }

    public Login emailFieldVisible() {
        waitForVisible(emailOrPhoneText);
        waitForVisible(emailOrPhoneInput);
        return this;
    }

    public Login passwordRequiredVisible() {
        waitForVisible(passwordRequiredText);
        return this;
    }

    public Login passwordFieldVisible() {
        waitForVisible(passwordText);
        waitForVisible(passwordInput);
        waitForClickable(showButton);
        return this;
    }

    public Login showButtonVisible() {
        waitForVisible(passwordShowText);
        waitForClickable(showButton);
        return this;
    }

    public Login typePassword(String password) {
        sendKeys(passwordInput, password);
        return this;
    }

    public Login nextButtonVisible() {
        waitForClickable(nextSignInButton);
        waitForVisible(nextButton);
        return this;
    }

    public Login signInButtonVisible() {
        waitForClickable(nextSignInButton);
        waitForVisible(signInButton);
        return this;
    }

    public Login clickSignInButton() {
        click(nextSignInButton);
        return this;
    }

    public Login forgotPasswordVisible() {
        waitForVisible(forgotPasswordButton);
        waitForClickable(forgotPasswordButton);
        return this;
    }

    public Login invalidMessageVisible() {
        waitForVisible(invalidEmailAddressText);
        return this;
    }

    public Login emailType(String user) {
        sendKeys(emailOrPhoneInput, user);
        return this;
    }

    public Login cleanInput() {
        sendKeys(emailOrPhoneInput, Keys.CONTROL + "a");
        sendKeys(emailOrPhoneInput, Keys.DELETE);
        return this;
    }

    public Login clickNext() {
        click(nextSignInButton);
        return this;
    }
}
