package com.podium.test.tests;

import com.podium.test.UiBaseTest;
import com.podium.test.components.Login;
import com.podium.test.components.Podium;
import com.podium.test.data.DataDriven;
import com.podium.test.data.DataDrivenProvider;
import org.testng.annotations.*;

public class LoginPageTest extends UiBaseTest {

    private Login podiumLoginPage;
    protected Podium podium;

    @BeforeClass
    private void navigateLogin() {
        webDriver = loadWebDriver();
        podiumLoginPage = new Podium(webDriver).navigateTo(BASE_URL).clickLogin();
    }

    @AfterClass
    private void quit() {
        quitWebDriver(webDriver);
    }

    @Test(priority = 1, description = "Validate all main fields Login Page")
    public void mainFieldsTest() {
        podiumLoginPage
            .emailFieldVisible()
            .forgotPasswordVisible()
            .nextButtonVisible();
    }

    @Test(priority = 2,
            description = "Validate e-mail or mobile number field",
            dataProvider = DataDrivenProvider.EMAILS_FAILS,
            dataProviderClass = DataDriven.class)
    public void emailMobileFieldFailTest(String email) {
        podiumLoginPage
            .emailType(email)
            .clickNext()
            .cleanInput()
            .invalidMessageVisible()
            .nextButtonVisible()
            .forgotPasswordVisible()
            .emailFieldVisible();
    }

    @Test(priority = 3,
            description = "Validate e-mail or mobile number field with valid input values",
            dataProvider = DataDrivenProvider.VALID_CREDENTIALS,
            dataProviderClass = DataDriven.class)
    public void emailMobileFieldTest(String email) {
        podiumLoginPage
            .emailType(email)
            .clickNext()
            .cleanInput()
            .emailFieldVisible()
            .passwordFieldVisible()
            .signInButtonVisible()
            .forgotPasswordVisible();
    }

    @Test(priority = 4,
            description = "Validate password field")
    public void passwordFieldTest() {
        podiumLoginPage
            .emailType("55848415815")
            .clickNext()
            .passwordFieldVisible()
            .clickSignInButton()
            .showButtonVisible()
            .passwordFieldVisible()
            .signInButtonVisible()
            .forgotPasswordVisible()
            .passwordRequiredVisible();
    }
}
