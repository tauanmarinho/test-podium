package com.podium.test.tests;

import com.podium.test.UiBaseTest;
import com.podium.test.components.EnterprisePage;
import com.podium.test.components.Podium;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EnterprisePageTest extends UiBaseTest {

    private EnterprisePage enterprisePage;

    @BeforeClass
    private void navigateEnterprise() {
        enterprisePage = new Podium(webDriver)
            .navigateTo(BASE_URL)
            .clickEnterpriseButton();
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
