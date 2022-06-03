package com.todoist.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${typeProperties}.properties"})
public interface WebDriverConfig extends Config {

    @DefaultValue("chrome")
    String browserName();
    @DefaultValue("100.0")
    String browserVersion();
    @DefaultValue("1920x1080")
    String browserSize();
    String remoteUrl();
    String username();
    String password();
}
