package com.medflexAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;

public class ChatPage {
    WebDriver driver;
    //creating constructor with driver object
    public ChatPage(WebDriver driver) {
        this.driver = driver;
    }
    //defining selectors
    By textArea = By.xpath("//textarea[@name=\"text\"]");
    By sendButton = By.xpath("//button[@type=\"submit\"]");
    By navigateToTeam = By.xpath("//nav[@data-component=\"PhysicianNavBar\"]/div[2]/div[2]/a[1]");
    By openLeftNavMenu = By.xpath("//*[@id=\"app-main\"]/div/div[2]/div[1]/button");
    By clickElementChat = By.xpath("//li[@data-component=\"ContactListItem\"][1]");



    public void navigateToChatSectionAsArzt()  {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(openLeftNavMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(navigateToTeam)).click();
        wait.until(ExpectedConditions.elementToBeClickable(clickElementChat)).click();
        driver.findElement(textArea).click();
    }


    public void chat() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.findElement(textArea).click();
        String uuid = UUID.randomUUID().toString();
        driver.findElement(textArea).sendKeys(uuid);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(sendButton)).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
