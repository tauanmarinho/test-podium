package com.podium.test.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PodiumHomePage extends BaseWebComponent {

    @FindBy(xpath = "//*[contains(text(), 'Login')]")
    private WebElement loginButton;

    protected PodiumHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public Login clickLogin() {
        click(loginButton);
        return new Login(webDriver);
    }
}
