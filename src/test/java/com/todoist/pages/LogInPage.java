package com.todoist.pages;

import com.codeborne.selenide.SelenideElement;
import com.todoist.config.Project;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LogInPage {

    public SelenideElement
            inputUsername = $("#labeled-input-1"),
            inputPassword = $("#labeled-input-3");

    public LogInPage logIn() {
        open("https://todoist.com/auth/login");
        inputUsername.setValue(Project.config.username());
        inputPassword.setValue(Project.config.password()).pressEnter();
        return this;
    }
}
