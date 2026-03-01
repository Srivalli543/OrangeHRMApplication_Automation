package com.orangeHRM.tests;

import org.testng.annotations.Test;

import com.orangeHRM.BaseTest.BaseTest;
import com.orangeHRM.pages.HomePage;
import com.orangeHRM.pages.LoginPage;

public class HomePageValidation extends BaseTest {
	@Test
    public void homePageValidation() {
		LoginPage login = new LoginPage(driver);
		HomePage page=new HomePage(driver);
		
		login.login("Admin", "admin123");
		page.DashBoardValiadtion();
		
		page.brokenLinksValidation();
	}

}
