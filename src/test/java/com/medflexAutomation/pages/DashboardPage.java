package com.medflexAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DashboardPage {
    WebDriver driver;
    //creating constructor with driver object
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

        //defining selectors
       By navigateToHomePage = By.xpath("//nav[@data-component=\"PhysicianNavBar\"]/div[2]/a[1]");
       By closeInitialModal = By.xpath("//*[@id=\"portal-root\"]/div/div[2]/div[2]/form/button");


        //action on objects click event if modal appears based on local
        public void closeInitialModalOnDashboard() {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.elementToBeClickable(navigateToHomePage));
            driver.findElement(navigateToHomePage).click();
            driver.findElement(closeInitialModal).click();
        }


   }

