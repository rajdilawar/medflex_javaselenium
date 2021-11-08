package com.medflexAutomation.properties;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private Properties configuration;

    public Configuration() throws IOException {
        loadConfig();
    }
    private void loadConfig() throws IOException {

        configuration = new Properties();
        final InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
        final BufferedInputStream stream = new BufferedInputStream(inputStream);
        configuration.load(stream);
        stream.close();
    }

    public String basemedflexUrl_arzt() {
        return configuration.getProperty("base_url");
    }

    public String url_mitarbeiter_url() {
        return configuration.getProperty("mitarbeiter_url");
    }


    public String validLoginName() {
        return configuration.getProperty("login_name");
    }

    public String validPassword() {
        return configuration.getProperty("password");
    }

    public String inValidLoginName() {
        return configuration.getProperty("badLogin_name");
    }

    public String inValidPassword() {
        return configuration.getProperty("bad_Password");
    }

    public String browserName() {
        return configuration.getProperty("browser");
    }

    public String secondUserLogin() {
        return configuration.getProperty("login_name_secondUser");
    }

    public String SecondUserPassword() {
        return configuration.getProperty("password_SecondUser");
    }




}
