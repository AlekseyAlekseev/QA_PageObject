package ru.netology.test;

import com.codeborne.selenide.Configuration;
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
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verifyInfo = DataHelper.getVerificationCode(authInfo);
        var dashboardPage = verificationPage.validVerify(verifyInfo);

    }
}
