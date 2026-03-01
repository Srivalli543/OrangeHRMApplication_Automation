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
        

    }

    @Test(priority=2)
    public void invalidLoginTest() {

        LoginPage page = new LoginPage(driver);
        page.login("Admin", "admin");
        

        String errorMessage = page.getErrorMessage();
        Assert.assertEquals(errorMessage, "Invalid credentials");
    }
    
    @Test(priority=3)
    public void multipleWindowValidation() {
    	LoginPage page = new LoginPage(driver);
    	page.multipleWindow();
    }
	
}
