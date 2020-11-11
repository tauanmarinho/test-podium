package com.podium.test.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EnterprisePage extends BaseWebComponent {

    @FindBy(id = "FirstName")
    private WebElement firstNameInput;

    @FindBy(id = "LastName")
    private WebElement lastNameInput;

    @FindBy(id = "Email")
    private WebElement emailInput;

    @FindBy(id = "No_of_Locations__c")
    private WebElement noOfLocationsInput;

    @FindBy(id = "Company")
    private WebElement companyInput;

    @FindBy(id = "MobilePhone")
    private WebElement mobilePhoneInput;

    @FindBy(xpath = "//*[@id=\"mktoForm_2463\"]/div[5]/span/button")
    private WebElement requestInfoButton;

    protected EnterprisePage(WebDriver webDriver) {
        super(webDriver);
    }

    public EnterprisePage firstNameInputVisible() {
        waitForVisible(firstNameInput);
        return this;
    }

    public EnterprisePage lastNameInputVisible() {
        waitForVisible(lastNameInput);
        return this;
    }

    public EnterprisePage emailInputVisible() {
        waitForVisible(emailInput);
        return this;
    }

    public EnterprisePage noOfLocationsInputVisible() {
        waitForVisible(noOfLocationsInput);
        return this;
    }

    public EnterprisePage companyInputVisible() {
        waitForVisible(companyInput);
        return this;
    }

    public EnterprisePage mobilePhoneInputVisible() {
        waitForVisible(mobilePhoneInput);
        return this;
    }

    public EnterprisePage requestButtonVisible() {
        waitForVisible(requestInfoButton);
        return this;
    }
}
