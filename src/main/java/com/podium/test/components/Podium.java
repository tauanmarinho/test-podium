package com.podium.test.components;

import org.openqa.selenium.WebDriver;

public class Podium extends BaseWebComponent {

    public Podium(WebDriver webDriver) {
        super(webDriver);
    }

    public PodiumMainPage navigateTo(String url) {
        webDriver.get(url);
        return new PodiumMainPage(webDriver);
    }
}
