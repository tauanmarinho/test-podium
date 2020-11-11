package com.podium.test.data;

import org.testng.annotations.DataProvider;

public class DataDriven {

    @DataProvider(name = DataDrivenProvider.EMAILS_FAILS)
    protected Object[][] emailNotValid() {
        return new Object[][]{
                {
                        "hdjhfjs"
                },
                {
                        "hdjhfjs@"
                },
                {
                        "hdjhfjs@gmail"
                },
                {
                        "hdjhfjs@gmail."
                }
        };
    }

    @DataProvider(name = DataDrivenProvider.VALID_CREDENTIALS)
    protected Object[][] validCredentials() {
        return new Object[][]{
                {
                        "hdjhfjs@gmail.com"
                },
                {
                        "55418989898"
                }
        };
    }
}
