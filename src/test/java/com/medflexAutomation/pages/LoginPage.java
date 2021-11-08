package com.medflexAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By emailField = By.id("username");
    By passwordField = By.id("password");
    By loginButton = By.xpath("//button[@type='submit']");
    By errorMessageForIncorrectLogin = By.xpath("//*[contains(text(), 'Ungültige E-Mail-Adresse oder Passwort. Bitte überprüfen Sie Ihre Eingaben.')]");
    By cookiesModalAcceptButton = By.xpath("//*[@id=\"uc-btn-accept-banner\"]");

    public void fillLoginCredentials(String logiName, String loginPassword) {
        driver.findElement(emailField).sendKeys(logiName);
        driver.findElement(passwordField).sendKeys(loginPassword);
    }

    public void acceptCookiesConcept() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(cookiesModalAcceptButton)).click();
    }

    public void clickLoginButton() {
        //can use explicit wait on an element to be able to be clickable
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public void assertErrorMessage() {
       String expectedErrorMessage = "Ungültige E-Mail-Adresse oder Passwort. Bitte überprüfen Sie Ihre Eingaben.";
       String actualErrorMessage = driver.findElement(errorMessageForIncorrectLogin).getText();
        System.out.println("My error Message is " + actualErrorMessage);
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

}

