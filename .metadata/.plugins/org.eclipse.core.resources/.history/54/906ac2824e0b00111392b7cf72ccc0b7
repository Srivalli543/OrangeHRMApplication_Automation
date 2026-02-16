package com.orangeHRM.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangeHRM.Base.BaseTest;
import com.orangeHRM.pages.LoginPage;
import com.orangeHRM.utils.ScreenshotUtil;

public class LoginTest extends BaseTest {

    @Test(priority=1)
    public void validateLogin() {

        LoginPage page = new LoginPage(driver);
        page.login("Admin", "admin123");

        boolean status = page.isDashboardDisplayed();

        if (!status) {
            ScreenshotUtil.captureScreenshot(driver, "ValidLoginFailure");
        }

        Assert.assertTrue(status, "Dashboard is NOT displayed after login");
    }

    @Test(priority=2)
    public void invalidLoginTest() {

        LoginPage page = new LoginPage(driver);
        page.login("Admin", "admin");

        String errorMessage = page.getErrorMessage();

        if (!errorMessage.equals("Invalid credentials")) {
            ScreenshotUtil.captureScreenshot(driver, "InvalidLoginFailure");
        }

        Assert.assertEquals(errorMessage, "Invalid credentials");
    }
}
