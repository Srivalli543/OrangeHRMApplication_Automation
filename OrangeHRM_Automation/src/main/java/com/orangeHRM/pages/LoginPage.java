package com.orangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Locators
    By username = By.name("username");
    By password = By.name("password");
    By loginBtn = By.xpath("//button[@type='submit']");
    
    // More stable Dashboard locator
    By dashboardText = By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb-module')]");

    By errorMsg = By.xpath("//p[contains(@class,'oxd-alert-content-text')]");

    // Login method
    public void login(String user, String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
        System.out.println(driver.getCurrentUrl());

    }

    // Validate Dashboard
    public boolean isDashboardDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardText));
            String text = driver.findElement(dashboardText).getText();
            return text.equalsIgnoreCase("Dashboard");
        } catch (Exception e) {
            return false;
        }
    }

    // Get Invalid Login Message
    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
        return driver.findElement(errorMsg).getText();
    }
}
