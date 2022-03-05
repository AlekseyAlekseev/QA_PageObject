package ru.netology.data;


import lombok.Value;

public class DataHelper {

    private DataHelper() {}

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOverInfo(AuthInfo original) {
        return new AuthInfo("alexey", "1234asgasf");
    }


    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCode(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class TransferInfo {
        private String amount;
        private String cardNumber;
    }

    public static TransferInfo getTransferInfo() {
        return new TransferInfo("500", "5559 0000 0000 0001");
    }
}
