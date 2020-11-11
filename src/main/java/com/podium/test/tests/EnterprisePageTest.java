package com.podium.test.tests;

import com.podium.test.UiBaseTest;
import com.podium.test.components.EnterprisePage;
import com.podium.test.components.Podium;
import com.podium.test.driver.SetupDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EnterprisePageTest extends UiBaseTest {

    private EnterprisePage enterprisePage;
    private static WebDriver webDriver;
    protected Podium podium;

    @BeforeClass
    private void navigateEnterprise() {
        this.webDriver = loadWebDriver();
        enterprisePage = new Podium(webDriver)
            .navigateTo(BASE_URL)
            .clickEnterpriseButton();
    }

    @AfterClass
    private void quit() {
        quitWebDriver(webDriver);
    }

    @Test(priority = 1, description = "Validate all main fields Enterprise Page")
    public void mainFieldsTest() {
        enterprisePage
            .firstNameInputVisible()
            .lastNameInputVisible()
            .emailInputVisible()
            .companyInputVisible()
            .mobilePhoneInputVisible();
    }
}
