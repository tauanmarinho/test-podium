package com.podium.test.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PodiumHomePage extends BaseWebComponent {

    @FindBy(xpath = "//*[contains(text(), 'Login')]")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"colophon\"]/section/div[1]/div[2]/div[3]/a[6]")
    private WebElement enterpriseButton;

    protected PodiumHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public Login clickLogin() {
        click(loginButton);
        return new Login(webDriver);
    }

    public EnterprisePage clickEnterpriseButton() {
        click(enterpriseButton);
        return new EnterprisePage(webDriver);
    }
}
