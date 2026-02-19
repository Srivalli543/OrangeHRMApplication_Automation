package com.orangeHRM.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangeHRM.BaseTest.BaseTest;
import com.orangeHRM.pages.LoginPage;
import com.orangeHRM.pages.HomePage;
import com.orangeHRM.utils.ScreenshotUtil;


public class LoginPageValidation extends BaseTest {

    @Test(priority=1)
    public void validateLogin() {

        LoginPage page = new LoginPage(driver);
        page.login("Admin", "admin123");
        
        HomePage hpage=new HomePage(driver);
        hpage.DashBoardValiadtion();

    }

    @Test(priority=2)
    public void invalidLoginTest() {

        LoginPage page = new LoginPage(driver);
        page.login("Admin", "admin");

        String errorMessage = page.getErrorMessage();
        Assert.assertEquals(errorMessage, "Invalid credentials");
    }
	
}
