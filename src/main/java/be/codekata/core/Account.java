package be.codekata.core;

public class Account {
    private final AccountId accountId;
    private final String customerId;
    private final OpeningDate openingDate;

    public Account(AccountId accountId, String customerId, OpeningDate openingDate) {

        this.accountId = accountId;
        this.customerId = customerId;
        this.openingDate = openingDate;
    }

    public String customerId() {
        return customerId;
    }

    public String accountId() {
        return accountId.id();
    }

    public OpeningDate openingDate() {
        return openingDate;
    }
}
