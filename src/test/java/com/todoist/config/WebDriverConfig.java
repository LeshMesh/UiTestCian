package com.todoist.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${typeProperties}.properties"})
public interface WebDriverConfig extends Config {

    @Key("browserName")
    @DefaultValue("chrome")
    String browserName();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("remoteUrl")
    String remoteUrl();

    @Key("username")
    String username();

    @Key("password")
    String password();
}
