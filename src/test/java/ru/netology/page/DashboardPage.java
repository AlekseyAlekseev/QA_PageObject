package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {

    private SelenideElement heading = $("[data-test-id=dashboard]");



    private ElementsCollection refillButton = $$("[data-test-id=action-deposit]");

    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public DashboardPage() {
        heading.shouldBe(visible);
    }

    public TransferPage refillFirstCard() {
        refillButton.first().click();
        return new TransferPage();
    }
//val text = cards.get(id).text();

    private ElementsCollection cards = $$(".list__item");

    public int getCardBalance(String id) {
        val text = cards.find(attribute("data-test-id", id)).getText();
        return extractBalance(text);
    }



    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }
}
