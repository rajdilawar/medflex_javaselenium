package com.medflexAutomation.tests;

import com.medflexAutomation.base.initClass;
import com.medflexAutomation.pages.ChatPage;
import com.medflexAutomation.pages.DashboardPage;
import com.medflexAutomation.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class ChatTest {

    @Test
    public void ChatWithAlreadyRegisterMember() throws IOException {
        initClass initClass = new initClass();
        WebDriver driver = initClass.getWebdriver();
        driver.get(initClass.getConfiguration().basemedflexUrl_arzt());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.acceptCookiesConcept();
        loginPage.fillLoginCredentials(initClass.getConfiguration().validLoginName(), initClass.getConfiguration().validPassword());
        loginPage.clickLoginButton();
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.closeInitialModalOnDashboard();
        ChatPage chatPage = new ChatPage(driver);
        chatPage.navigateToChatSectionAsArzt();
        chatPage.chat();
        driver.quit();
    }

    @Test
    public void ReplyToChatAsSecondPerson() throws IOException, InterruptedException {
        initClass initClass = new initClass();
        WebDriver driver = initClass.getWebdriver();
        driver.get(initClass.getConfiguration().basemedflexUrl_arzt());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.acceptCookiesConcept();
        loginPage.fillLoginCredentials(initClass.getConfiguration().secondUserLogin(), initClass.getConfiguration().SecondUserPassword());
        loginPage.clickLoginButton();
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.closeInitialModalOnDashboard();
        ChatPage chatPage = new ChatPage(driver);
        chatPage.navigateToChatSectionAsArzt();
        chatPage.chat();
        driver.quit();
    }
}
