package com.todoist.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TopFilterPage {

    public SelenideElement
            filterInbox = $("#filter_inbox"),
            filterToday = $("#filter_today"),
            filterUpcoming = $("#filter_upcoming"),
            filterLabels = $("#filters_labels"),
            checkFilterContent = $(".simple_content"),
            calendar = $(".calendar"),
            monthYear = $(".upcoming_view__calendar__controls__picker"),
            dayMonth = $(".calendar__day--selected").$(".upcoming_view__day_cell__weekday"),
            dateMonth = $(".calendar__day--selected").$(".upcoming_view__day_cell__date__number");

    public TopFilterPage openFilterInbox() {
        filterInbox.click();
        return this;
    }

    public TopFilterPage checkOpenFilterInbox() {
        checkFilterContent.shouldHave(Condition.text("Входящие"));
        return this;
    }

    public TopFilterPage openFilterToday() {
        filterToday.click();
        return this;
    }

    public TopFilterPage checkOpenFilterToday() {
        checkFilterContent.shouldHave(Condition.text("Сегодня"));
        return this;
    }

    public TopFilterPage openFilterLabels() {
        filterLabels.click();
        return this;
    }

    public TopFilterPage checkOpenFilterLabels() {
        checkFilterContent.shouldHave(Condition.text("Фильтры и метки"));
        return this;
    }

    public TopFilterPage openFilterUpcoming() {
        filterUpcoming.click();
        return this;
    }

    public TopFilterPage checkOpenFilterUpcoming() {
        calendar.shouldBe(Condition.visible);
        return this;
    }

    public TopFilterPage checkOpenDateUpcoming() {
        String dateCheck = monthYear.innerText() + " " + dayMonth.innerText() + " " + dateMonth.innerText();
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM yyyy E d");
        Date dateNow = new Date();
        try {
            Date date = formatter.parse(dateCheck);
            assertEquals(formatter.format(date), formatter.format(dateNow));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return this;
    }
}
