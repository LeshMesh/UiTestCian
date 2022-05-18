package ru.cian.helpers;

import com.codeborne.selenide.Configuration;
import ru.cian.config.Project;

import static ru.cian.config.Project.isRemoteWebDriver;

public class DriverConfig {

    public static void configure() {

        Configuration.browser = Project.config.browserName();
        Configuration.browserVersion = Project.config.browserVersion();
        Configuration.browserSize = Project.config.browserSize();

        if (isRemoteWebDriver()) {
            Configuration.remote = Project.config.remoteUrl();
        }
    }
}
