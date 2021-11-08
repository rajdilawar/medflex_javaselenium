package com.medflexAutomation.base;

import com.medflexAutomation.properties.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class initClass {
    public WebDriver driver;
    Configuration configuration;

    public initClass() throws IOException {
        System.out.println("Initialize ");
        initializationMethod();
    }


    public void initializationMethod() throws IOException {

        this.configuration = new Configuration();
        String browserName = configuration.browserName();
        if (browserName.equals("chrome")) {
           // System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver");
            ChromeOptions options = new ChromeOptions();
            // Skip DDOS checks
            options.addArguments("--disable-blink-features=AutomationControlled");
            driver = new ChromeDriver(options);

            System.out.println("Initializing chrome driver");

        } else if (browserName.equals("firefox")) {
            //System.setProperty("webdriver.chrome.driver", "src/driver/geckodriver");
            driver = new FirefoxDriver();
            System.out.println("Initializing Firefox driver");
        }

        //managing driver
        //driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //implicit wait for 10 seconds usually good for page to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    //return configuration object
    public Configuration getConfiguration(){
        return this.configuration;
    }

    public WebDriver getWebdriver() {
        return driver;
    }
}