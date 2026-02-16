package com.orangeHRM.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddUserPage {

    WebDriver driver;
    WebDriverWait wait;

    public AddUserPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ========= LOCATORS =========

    private By addUserHeader = By.xpath("//h6[text()='Add User']");
    private By userRoleDropdown = By.xpath("(//div[contains(@class,'oxd-select-text-input')])[1]");
    private By employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");
    private By statusDropdown = By.xpath("(//div[contains(@class,'oxd-select-text-input')])[2]");
    private By usernameInput = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private By passwordInput = By.xpath("(//input[@type='password'])[1]");
    private By confirmPasswordInput = By.xpath("(//input[@type='password'])[2]");
    private By saveButton = By.xpath("//button[normalize-space()='Save']");

    // ========= ACTION METHODS =========

    public void waitForAddUserPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addUserHeader));
    }

    public void selectUserRole(String role) {

        waitForAddUserPage();

        wait.until(ExpectedConditions.elementToBeClickable(userRoleDropdown)).click();

        By roleOption = By.xpath("//span[text()='" + role + "']");
        wait.until(ExpectedConditions.elementToBeClickable(roleOption)).click();
    }

    public void enterEmployeeName(String empName) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameInput)).sendKeys(empName);

        // wait for dropdown suggestion
        By suggestion = By.xpath("//div[@role='listbox']//span");
        wait.until(ExpectedConditions.visibilityOfElementLocated(suggestion));

        driver.findElement(employeeNameInput).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(employeeNameInput).sendKeys(Keys.ENTER);
    }
    public void selectStatus(String status) {

        wait.until(ExpectedConditions.elementToBeClickable(statusDropdown)).click();

        By statusOption = By.xpath("//div[@role='listbox']//span[text()='" + status + "']");
        wait.until(ExpectedConditions.elementToBeClickable(statusOption)).click();
    }
    

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput)).sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordInput)).sendKeys(password);
    }

    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
}
