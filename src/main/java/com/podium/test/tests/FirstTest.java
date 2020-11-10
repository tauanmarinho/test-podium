package com.podium.test.tests;

import com.podium.test.UiBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends UiBaseTest {

    @Test
    public void test() {
        Assert.assertEquals(true, true);
    }
}
