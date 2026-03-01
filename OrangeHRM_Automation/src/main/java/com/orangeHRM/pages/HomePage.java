package com.orangeHRM.pages;
import com.orangeHRM.utils.ElementUtil;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	
	public void brokenLinksValidation() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total Links found:"+links.size());
		
		for(WebElement link: links) {
			String url=link.getAttribute("href");
			
			if(url == null || url.isEmpty()) {
				System.out.println("No broken links are present");
			}
			try {
				URL linkUrl=new URL(url);
				HttpURLConnection Httpconn=(HttpURLConnection) linkUrl.openConnection();
				Httpconn.setConnectTimeout(5000);
				Httpconn.connect();
				
				int responseCode=Httpconn.getResponseCode();
				
				if(responseCode>400) {
                    System.out.println(url + " --> Broken link (" + responseCode + ")");
                   
				}
				else if(responseCode<400) {
                    System.out.println(url + " --> Valid link (" + responseCode + ")");

				}
			}
			catch(Exception e) {
				System.out.println(url + " --> Exception occurred");
			}
		}
	}

}
