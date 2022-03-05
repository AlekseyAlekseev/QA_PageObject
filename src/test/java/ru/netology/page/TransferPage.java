package ru.netology.page;




import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {

    private SelenideElement heading = $("[data-test-id=dashboard]");

    private SelenideElement amountField = $("[data-test-id=amount] input");
    private SelenideElement cardNumberField = $("[data-test-id=from] input");
    private SelenideElement transferButton = $("[data-test-id=action-transfer]");

    public TransferPage() {
        heading.shouldBe(visible);
    }

    public DashboardPage transfer (DataHelper.TransferInfo transferInfo) {
        amountField.setValue(transferInfo.getAmount());
        cardNumberField.setValue(transferInfo.getCardNumber());
        transferButton.click();
        return new DashboardPage();
    }

}
