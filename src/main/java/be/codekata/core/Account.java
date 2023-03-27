package be.codekata.core;

public class Account {
    private final AccountId accountId;
    private final String customerId;

    public Account(AccountId accountId, String customerId) {

        this.accountId = accountId;
        this.customerId = customerId;
    }

    public String customerId() {
        return customerId;
    }

    public String accountId() {
        return accountId.id();
    }
}