package com.orangeHRM.pages;
import com.orangeHRM.utils.ElementUtil;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HomePage {
protected WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void DashBoardValiadtion() {
		try {
			ElementUtil.waitforElement(driver, "//h6[contains(@class,'oxd-topbar-header-breadcrumb-module')]", "DashBoard");
			ElementUtil.ElementDisplayed(driver, "//p[contains(.,'Time at Work')]", "TimeAtWorkHeading");
			ElementUtil.ElementDisplayed(driver, "//p[contains(.,'My Actions')]", "MyActionsHeading");
			ElementUtil.ElementDisplayed(driver, "//p[contains(.,'Quick Launch')]", "QuickLaunchHeading");
			ElementUtil.ElementDisplayed(driver, "//p[contains(.,'Buzz Latest Posts')]", "BuzzLatestPostHeading");
			ElementUtil.ElementDisplayed(driver, "//p[contains(.,'Employees on Leave Today')]", "EmployeesonLeaveHeading");
			ElementUtil.ElementDisplayed(driver, "//p[contains(.,'Employee Distribution')]", "EmployeeDistributionHeading");
			ElementUtil.ElementDisplayed(driver, "//p[contains(.,'Employee Distribution by Location')]", "EmployeeDistributionByLocationHeading");
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

	}

}
