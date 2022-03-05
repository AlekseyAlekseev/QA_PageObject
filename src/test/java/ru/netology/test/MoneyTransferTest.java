package ru.netology.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class MoneyTransferTest {

    @Test
    public void shouldTransferMoneyBetweenOwnCards() {
        open("http://localhost:9999/");

        Configuration.holdBrowserOpen = true;

        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo(); // получаем логин и пароль для авторизации
        var verificationPage = loginPage.validLogin(authInfo); // вводим данные для логина и переходим на страницу верификации
        var verifyInfo = DataHelper.getVerificationCode(authInfo); // получаем код для верификации
        var dashboardPage = verificationPage.validVerify(verifyInfo); // вводим код верификации и переходим на страницу с картами

        var firstBalance = dashboardPage.getCardBalance("92df3f1c-a033-48e6-8390-206f6b1f56c0"); // получаем стартовый баланс по первой карте

//        var firstBalance = dashboardPage.getCardBalance(0); // получаем стартовый баланс по первой карте
        var transferPage = dashboardPage.refillFirstCard(); // переход на страницу пополнения карты
        var transferInfo = DataHelper.getTransferInfo(); // получаем сумму и номер карты для пополнения
        transferPage.transfer(transferInfo); // вводим данные для пополнения и нажимаем "Пополнить"
        var balanceAfterTransfer = firstBalance + (Integer.parseInt(transferInfo.getAmount()));
        Assertions.assertEquals(firstBalance, balanceAfterTransfer);
    }
}
