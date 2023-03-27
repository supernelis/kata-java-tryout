package be.codekata;

public class Account {
    private final AccountId accountId;
    private final String customerId;

    public Account(AccountId accountId, String customerId) {

        this.accountId = accountId;
        this.customerId = customerId;
    }
}
