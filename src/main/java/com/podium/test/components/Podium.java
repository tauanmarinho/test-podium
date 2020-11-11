package com.podium.test.components;

import org.openqa.selenium.WebDriver;

public class Podium extends BaseWebComponent {

    public Podium(WebDriver webDriver) {
        super(webDriver);
    }

    public PodiumHomePage navigateTo(String url) {
        webDriver.get(url);
        return new PodiumHomePage(webDriver);
    }
}
